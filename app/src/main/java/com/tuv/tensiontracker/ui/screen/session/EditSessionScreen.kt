package com.tuv.tensiontracker.ui.screen.session

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tuv.tensiontracker.domain.model.StringModel
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSessionScreen(
    sessionId: Long,
    onNavigateBack: () -> Unit,
    viewModel: EditSessionViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    
    // Load session data when screen opens
    LaunchedEffect(sessionId) {
        viewModel.loadSession(sessionId)
    }
    
    // Show error message
    LaunchedEffect(uiState.errorMessage) {
        uiState.errorMessage?.let { message ->
            snackbarHostState.showSnackbar(message)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Session") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    if (!uiState.isLoading && uiState.errorMessage == null) {
                        Button(
                            onClick = {
                                viewModel.updateSession(onSuccess = onNavigateBack)
                            },
                            enabled = !uiState.isSaving
                        ) {
                            if (uiState.isSaving) {
                                CircularProgressIndicator()
                            } else {
                                Icon(Icons.Default.Check, contentDescription = null)
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text("Save")
                            }
                        }
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            
            uiState.errorMessage != null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Error loading session",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            text = uiState.errorMessage!!,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            
            else -> {
                EditSessionContent(
                    uiState = uiState,
                    onDateChanged = viewModel::updateDateStrung,
                    onMainStringChanged = viewModel::updateMainString,
                    onCrossStringChanged = viewModel::updateCrossString,
                    onIsHybridChanged = viewModel::updateIsHybrid,
                    onMainTensionChanged = viewModel::updateMainTension,
                    onCrossTensionChanged = viewModel::updateCrossTension,
                    onPriceChanged = viewModel::updatePricePaid,
                    onLocationChanged = viewModel::updateLocation,
                    onHoursUntilBreakChanged = viewModel::updateHoursUntilBreak,
                    onHoursUntilDeadChanged = viewModel::updateHoursUntilDead,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
private fun EditSessionContent(
    uiState: EditSessionUiState,
    onDateChanged: (Instant) -> Unit,
    onMainStringChanged: (StringModel?) -> Unit,
    onCrossStringChanged: (StringModel?) -> Unit,
    onIsHybridChanged: (Boolean) -> Unit,
    onMainTensionChanged: (String) -> Unit,
    onCrossTensionChanged: (String) -> Unit,
    onPriceChanged: (String) -> Unit,
    onLocationChanged: (String) -> Unit,
    onHoursUntilBreakChanged: (String) -> Unit,
    onHoursUntilDeadChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Date Selection
        item {
            SessionFormCard(title = "Date") {
                DateField(
                    date = uiState.dateStrung,
                    onDateChanged = onDateChanged
                )
            }
        }
        
        // String Selection
        item {
            SessionFormCard(title = "String Setup") {
                StringSelectionSection(
                    selectedMainString = uiState.selectedMainString,
                    selectedCrossString = uiState.selectedCrossString,
                    availableStrings = uiState.availableStrings,
                    isLoadingStrings = uiState.isLoadingStrings,
                    isHybrid = uiState.isHybrid,
                    onMainStringChanged = onMainStringChanged,
                    onCrossStringChanged = onCrossStringChanged,
                    onIsHybridChanged = onIsHybridChanged,
                    validationErrors = uiState.validationErrors
                )
            }
        }
        
        // Tension Settings
        item {
            SessionFormCard(title = "Tension (${uiState.tensionUnit.abbreviation})") {
                TensionSection(
                    mainTensionInput = uiState.mainTensionInput,
                    crossTensionInput = uiState.crossTensionInput,
                    isHybrid = uiState.isHybrid,
                    tensionUnit = uiState.tensionUnit,
                    onMainTensionChanged = onMainTensionChanged,
                    onCrossTensionChanged = onCrossTensionChanged,
                    validationErrors = uiState.validationErrors
                )
            }
        }
        
        // Session Details
        item {
            SessionFormCard(title = "Session Details") {
                SessionDetailsSection(
                    pricePaidInput = uiState.pricePaidInput,
                    locationInput = uiState.locationInput,
                    recentLocations = uiState.recentLocations,
                    onPriceChanged = onPriceChanged,
                    onLocationChanged = onLocationChanged,
                    validationErrors = uiState.validationErrors
                )
            }
        }
        
        // Usage Tracking
        item {
            SessionFormCard(title = "Usage Tracking") {
                UsageTrackingSection(
                    hoursUntilBreakInput = uiState.hoursUntilBreakInput,
                    hoursUntilDeadInput = uiState.hoursUntilDeadInput,
                    onHoursUntilBreakChanged = onHoursUntilBreakChanged,
                    onHoursUntilDeadChanged = onHoursUntilDeadChanged,
                    validationErrors = uiState.validationErrors
                )
            }
        }
        
        // Bottom spacing
        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
private fun SessionFormCard(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            content()
        }
    }
}

@Composable
private fun DateField(
    date: Instant,
    onDateChanged: (Instant) -> Unit
) {
    val localDate = date.toLocalDateTime(TimeZone.currentSystemDefault())
    val dateString = "${localDate.dayOfMonth}/${localDate.monthNumber}/${localDate.year}"
    
    OutlinedTextField(
        value = dateString,
        onValueChange = { },
        label = { Text("Date Strung") },
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        trailingIcon = {
            Text(
                text = "📅",
                style = MaterialTheme.typography.bodyLarge
            )
        },
        supportingText = {
            Text("Tap to change date (Date picker coming soon)")
        }
    )
}

@Composable
private fun StringSelectionSection(
    selectedMainString: StringModel?,
    selectedCrossString: StringModel?,
    availableStrings: List<StringModel>,
    isLoadingStrings: Boolean,
    isHybrid: Boolean,
    onMainStringChanged: (StringModel?) -> Unit,
    onCrossStringChanged: (StringModel?) -> Unit,
    onIsHybridChanged: (Boolean) -> Unit,
    validationErrors: Set<EditSessionValidationError>
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // Hybrid toggle
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isHybrid,
                onCheckedChange = onIsHybridChanged
            )
            Text(
                text = "Hybrid setup (different main and cross strings)",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        
        // Main string selection
        StringDropdown(
            label = "Main String",
            selectedString = selectedMainString,
            availableStrings = availableStrings,
            onStringSelected = onMainStringChanged,
            isError = EditSessionValidationError.MAIN_STRING_REQUIRED in validationErrors,
            isLoading = isLoadingStrings
        )
        
        // Cross string selection (only if hybrid)
        if (isHybrid) {
            StringDropdown(
                label = "Cross String",
                selectedString = selectedCrossString,
                availableStrings = availableStrings,
                onStringSelected = onCrossStringChanged,
                isLoading = isLoadingStrings
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StringDropdown(
    label: String,
    selectedString: StringModel?,
    availableStrings: List<StringModel>,
    onStringSelected: (StringModel?) -> Unit,
    isError: Boolean = false,
    isLoading: Boolean = false
) {
    var expanded by remember { mutableStateOf(false) }
    
    Box {
        OutlinedTextField(
            value = selectedString?.displayName ?: "",
            onValueChange = { },
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            isError = isError,
            trailingIcon = {
                IconButton(onClick = { if (!isLoading) expanded = true }) {
                    if (isLoading) {
                        CircularProgressIndicator(strokeWidth = 2.dp)
                    } else {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                    }
                }
            },
            supportingText = {
                when {
                    isError -> Text("Please select a string")
                    isLoading -> Text("Loading strings...")
                    availableStrings.isEmpty() && !isLoading -> Text("No strings available")
                    selectedString != null -> Text("${selectedString.brand} | ${selectedString.type.displayName}")
                    else -> Text("Select a string from the dropdown")
                }
            }
        )
        
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            if (availableStrings.isEmpty()) {
                DropdownMenuItem(
                    text = { 
                        Text(
                            text = if (isLoading) "Loading strings..." else "No strings available",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    onClick = { expanded = false }
                )
            } else {
                availableStrings.forEach { string ->
                    DropdownMenuItem(
                        text = {
                            Column {
                                Text(
                                    text = string.displayName,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "${string.brand} | ${string.type.displayName}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        },
                        onClick = {
                            onStringSelected(string)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun TensionSection(
    mainTensionInput: String,
    crossTensionInput: String,
    isHybrid: Boolean,
    tensionUnit: com.tuv.tensiontracker.domain.model.TensionUnit,
    onMainTensionChanged: (String) -> Unit,
    onCrossTensionChanged: (String) -> Unit,
    validationErrors: Set<EditSessionValidationError>
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = mainTensionInput,
            onValueChange = onMainTensionChanged,
            label = { Text("Main Tension (${tensionUnit.abbreviation})") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            isError = EditSessionValidationError.MAIN_TENSION_REQUIRED in validationErrors ||
                     EditSessionValidationError.MAIN_TENSION_INVALID in validationErrors,
            supportingText = {
                when {
                    EditSessionValidationError.MAIN_TENSION_REQUIRED in validationErrors -> 
                        Text("Main tension is required")
                    EditSessionValidationError.MAIN_TENSION_INVALID in validationErrors -> 
                        Text("Please enter a valid tension value")
                    else -> Text("Enter the main string tension")
                }
            }
        )
        
        if (isHybrid) {
            OutlinedTextField(
                value = crossTensionInput,
                onValueChange = onCrossTensionChanged,
                label = { Text("Cross Tension (${tensionUnit.abbreviation})") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                isError = EditSessionValidationError.CROSS_TENSION_INVALID in validationErrors,
                supportingText = {
                    when {
                        EditSessionValidationError.CROSS_TENSION_INVALID in validationErrors -> 
                            Text("Please enter a valid tension value")
                        else -> Text("Enter the cross string tension (optional)")
                    }
                }
            )
        }
    }
}

@Composable
private fun SessionDetailsSection(
    pricePaidInput: String,
    locationInput: String,
    recentLocations: List<com.tuv.tensiontracker.domain.model.StringingLocation>,
    onPriceChanged: (String) -> Unit,
    onLocationChanged: (String) -> Unit,
    validationErrors: Set<EditSessionValidationError>
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = pricePaidInput,
            onValueChange = onPriceChanged,
            label = { Text("Price Paid ($)") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            isError = EditSessionValidationError.PRICE_INVALID in validationErrors,
            supportingText = {
                when {
                    EditSessionValidationError.PRICE_INVALID in validationErrors -> 
                        Text("Please enter a valid price")
                    else -> Text("Enter the price paid for stringing (optional)")
                }
            }
        )
        
        OutlinedTextField(
            value = locationInput,
            onValueChange = onLocationChanged,
            label = { Text("Where Strung") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Enter where the strings were installed (optional)")
            }
        )
    }
}

@Composable
private fun UsageTrackingSection(
    hoursUntilBreakInput: String,
    hoursUntilDeadInput: String,
    onHoursUntilBreakChanged: (String) -> Unit,
    onHoursUntilDeadChanged: (String) -> Unit,
    validationErrors: Set<EditSessionValidationError>
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = hoursUntilBreakInput,
            onValueChange = onHoursUntilBreakChanged,
            label = { Text("Hours Until Break") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            isError = EditSessionValidationError.HOURS_UNTIL_BREAK_INVALID in validationErrors,
            supportingText = {
                when {
                    EditSessionValidationError.HOURS_UNTIL_BREAK_INVALID in validationErrors -> 
                        Text("Please enter a valid number of hours")
                    else -> Text("How many hours until the strings broke? (optional)")
                }
            }
        )
        
        OutlinedTextField(
            value = hoursUntilDeadInput,
            onValueChange = onHoursUntilDeadChanged,
            label = { Text("Hours Until Dead") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            isError = EditSessionValidationError.HOURS_UNTIL_DEAD_INVALID in validationErrors,
            supportingText = {
                when {
                    EditSessionValidationError.HOURS_UNTIL_DEAD_INVALID in validationErrors -> 
                        Text("Please enter a valid number of hours")
                    else -> Text("How many hours until the strings felt dead? (optional)")
                }
            }
        )
    }
}