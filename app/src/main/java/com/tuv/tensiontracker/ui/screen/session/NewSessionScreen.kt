package com.tuv.tensiontracker.ui.screen.session

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
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
import com.tuv.tensiontracker.ui.utils.DateFormatter
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewSessionScreen(
    onNavigateBack: () -> Unit,
    onNavigateToStringCatalog: () -> Unit,
    viewModel: NewSessionViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    var showDatePicker by remember { mutableStateOf(false) }
    
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
                title = { Text("New Stringing Session") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    Button(
                        onClick = {
                            viewModel.saveSession(onNavigateBack)
                        },
                        enabled = !uiState.isSaving
                    ) {
                        if (uiState.isSaving) {
                            CircularProgressIndicator(
                                modifier = Modifier.padding(end = 8.dp),
                                strokeWidth = 2.dp
                            )
                        }
                        Text("Save")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Date Section
            item {
                FormSection(title = "Date & Setup") {
                    OutlinedTextField(
                        value = DateFormatter.formatDate(uiState.dateStrung),
                        onValueChange = { },
                        label = { Text("Date Strung") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showDatePicker = true },
                        readOnly = true,
                        trailingIcon = {
                            IconButton(onClick = { showDatePicker = true }) {
                                Text(
                                    text = "📅",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        },
                        supportingText = {
                            Text("Tap to select a different date")
                        }
                    )
                }
            }
            
            // String Selection Section
            item {
                FormSection(title = "String Selection") {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        StringDropdown(
                            label = "Main String *",
                            selectedString = uiState.selectedMainString,
                            availableStrings = uiState.availableStrings,
                            onStringSelected = viewModel::updateMainString,
                            isError = NewSessionValidationError.MAIN_STRING_REQUIRED in uiState.validationErrors,
                            isLoading = uiState.isLoadingStrings
                        )
                        
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { viewModel.toggleIsHybrid() }
                                .padding(4.dp)
                        ) {
                            Checkbox(
                                checked = uiState.isHybrid,
                                onCheckedChange = null // Handled by row click
                            )
                            Text(
                                text = "Hybrid setup (different cross string)",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        
                        if (uiState.isHybrid) {
                            StringDropdown(
                                label = "Cross String",
                                selectedString = uiState.selectedCrossString,
                                availableStrings = uiState.availableStrings,
                                onStringSelected = viewModel::updateCrossString,
                                isLoading = uiState.isLoadingStrings
                            )
                        }
                    }
                }
            }
            
            // Tension Section
            item {
                FormSection(title = "Tension (${uiState.tensionUnit.abbreviation})") {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        OutlinedTextField(
                            value = uiState.mainTensionInput,
                            onValueChange = viewModel::updateMainTension,
                            label = { Text("Main Tension *") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            isError = NewSessionValidationError.MAIN_TENSION_REQUIRED in uiState.validationErrors ||
                                    NewSessionValidationError.MAIN_TENSION_INVALID in uiState.validationErrors,
                            supportingText = {
                                when {
                                    NewSessionValidationError.MAIN_TENSION_REQUIRED in uiState.validationErrors -> 
                                        Text("Main tension is required")
                                    NewSessionValidationError.MAIN_TENSION_INVALID in uiState.validationErrors -> 
                                        Text("Please enter a valid number")
                                }
                            }
                        )
                        
                        if (uiState.isHybrid) {
                            OutlinedTextField(
                                value = uiState.crossTensionInput,
                                onValueChange = viewModel::updateCrossTension,
                                label = { Text("Cross Tension") },
                                modifier = Modifier.fillMaxWidth(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                isError = NewSessionValidationError.CROSS_TENSION_INVALID in uiState.validationErrors,
                                supportingText = {
                                    if (NewSessionValidationError.CROSS_TENSION_INVALID in uiState.validationErrors) {
                                        Text("Please enter a valid number")
                                    }
                                }
                            )
                        }
                    }
                }
            }
            
            // Additional Details Section
            item {
                FormSection(title = "Additional Details") {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        OutlinedTextField(
                            value = uiState.pricePaidInput,
                            onValueChange = viewModel::updatePricePaid,
                            label = { Text("Price Paid") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            isError = NewSessionValidationError.PRICE_INVALID in uiState.validationErrors,
                            leadingIcon = {
                                Text(
                                    text = "$",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            },
                            supportingText = {
                                if (NewSessionValidationError.PRICE_INVALID in uiState.validationErrors) {
                                    Text("Please enter a valid amount")
                                } else {
                                    Text("Enter the price paid for stringing (optional)")
                                }
                            }
                        )
                        
                        OutlinedTextField(
                            value = uiState.locationInput,
                            onValueChange = viewModel::updateLocation,
                            label = { Text("Where Installed") },
                            modifier = Modifier.fillMaxWidth(),
                            supportingText = { Text("e.g., Pro Shop, Local Club, etc.") }
                        )
                    }
                }
            }
            
            // Usage Tracking Section
            item {
                FormSection(title = "Usage Tracking (Optional)") {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        OutlinedTextField(
                            value = uiState.hoursUntilBreakInput,
                            onValueChange = viewModel::updateHoursUntilBreak,
                            label = { Text("Hours Until Break") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            isError = NewSessionValidationError.HOURS_UNTIL_BREAK_INVALID in uiState.validationErrors,
                            supportingText = {
                                if (NewSessionValidationError.HOURS_UNTIL_BREAK_INVALID in uiState.validationErrors) {
                                    Text("Please enter a valid number")
                                } else {
                                    Text("Hours of play before strings broke")
                                }
                            }
                        )
                        

                    }
                }
            }
        }
    }
    
    // Date Picker Dialog
    if (showDatePicker) {
        DatePickerDialog(
            onDateSelected = { selectedDateMillis ->
                selectedDateMillis?.let { millis ->
                    val instant = Instant.fromEpochMilliseconds(millis)
                    viewModel.updateDateStrung(instant)
                }
                showDatePicker = false
            },
            onDismiss = { showDatePicker = false },
            initialDate = uiState.dateStrung
        )
    }
}

@Composable
private fun FormSection(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            content()
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
                IconButton(
                    onClick = { if (!isLoading) expanded = true }
                ) {
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
                    availableStrings.isEmpty() && !isLoading -> Text("No strings available. Check app initialization.")
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
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(
                                    text = "${string.type.displayName} • ${string.priceRange ?: "Price varies"}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        },
                        onClick = {
                            onStringSelected(string)
                            expanded = false
                        },
                        trailingIcon = {
                            if (selectedString?.id == string.id) {
                                Icon(
                                    Icons.Default.Check,
                                    contentDescription = "Selected",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DatePickerDialog(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit,
    initialDate: Instant
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = initialDate.toEpochMilliseconds()
    )
    
    androidx.compose.material3.DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = { onDateSelected(datePickerState.selectedDateMillis) }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

