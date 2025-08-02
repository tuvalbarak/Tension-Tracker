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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tuv.tensiontracker.domain.model.SessionWithDetails
import com.tuv.tensiontracker.domain.model.UserPreferences
import com.tuv.tensiontracker.ui.utils.DateFormatter
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionDetailsScreen(
    sessionId: Long,
    onNavigateBack: () -> Unit,
    onNavigateToEdit: () -> Unit,
    viewModel: SessionDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    
    LaunchedEffect(sessionId) {
        viewModel.loadSessionDetails(sessionId)
    }
    
    LaunchedEffect(uiState.error) {
        uiState.error?.let { error ->
            snackbarHostState.showSnackbar(error)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Session Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            if (uiState.sessionWithDetails != null) {
                ExtendedFloatingActionButton(
                    onClick = onNavigateToEdit,
                    icon = { Icon(Icons.Default.Edit, contentDescription = null) },
                    text = { Text("Edit") }
                )
            }
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
            
            uiState.sessionWithDetails == null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Session not found",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            text = "The requested session could not be found.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            
            else -> {
                SessionDetailsContent(
                    sessionWithDetails = uiState.sessionWithDetails!!,
                    userPreferences = uiState.userPreferences,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
private fun SessionDetailsContent(
    sessionWithDetails: SessionWithDetails,
    userPreferences: UserPreferences,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // String Information Section
        item {
            InfoCard(
                title = "String Setup",
                content = {
                    StringInfoSection(sessionWithDetails)
                }
            )
        }
        
        // Tension Information Section
        item {
            InfoCard(
                title = "Tension",
                content = {
                    TensionInfoSection(sessionWithDetails, userPreferences)
                }
            )
        }
        
        // Session Information Section
        item {
            InfoCard(
                title = "Session Information",
                content = {
                    SessionInfoSection(sessionWithDetails)
                }
            )
        }
        
        // Usage Tracking Section
        item {
            InfoCard(
                title = "Usage Tracking",
                content = {
                    UsageTrackingSection(sessionWithDetails)
                }
            )
        }
        
        // Feedback Section
        sessionWithDetails.feedback?.let { feedback ->
            item {
                InfoCard(
                    title = "Feedback & Rating",
                    content = {
                        FeedbackSection(feedback, userPreferences)
                    }
                )
            }
        }
        
        // Bottom spacing for FAB
        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
private fun InfoCard(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
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
private fun StringInfoSection(sessionWithDetails: SessionWithDetails) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        InfoRow(
            label = "Main String",
            value = "${sessionWithDetails.mainString.brand} ${sessionWithDetails.mainString.name}"
        )
        InfoRow(
            label = "String Type",
            value = sessionWithDetails.mainString.type.displayName
        )
        InfoRow(
            label = "Gauge",
            value = "${sessionWithDetails.mainString.gaugeMm}mm"
        )
        
        val crossString = sessionWithDetails.crossString
        if (sessionWithDetails.session.isHybrid && crossString != null) {
            Spacer(modifier = Modifier.height(8.dp))
            InfoRow(
                label = "Cross String",
                value = "${crossString.brand} ${crossString.name}"
            )
            InfoRow(
                label = "Cross Type",
                value = crossString.type.displayName
            )
            InfoRow(
                label = "Cross Gauge",
                value = "${crossString.gaugeMm}mm"
            )
        }
    }
}

@Composable
private fun TensionInfoSection(
    sessionWithDetails: SessionWithDetails,
    userPreferences: UserPreferences
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        InfoRow(
            label = "Main Tension",
            value = sessionWithDetails.session.mainTension.convertTo(userPreferences.tensionUnit).toString()
        )
        
        val crossTension = sessionWithDetails.session.crossTension
        if (sessionWithDetails.session.isHybrid && crossTension != null) {
            InfoRow(
                label = "Cross Tension",
                value = crossTension.convertTo(userPreferences.tensionUnit).toString()
            )
        }
    }
}

@Composable
private fun SessionInfoSection(sessionWithDetails: SessionWithDetails) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        InfoRow(
            label = "Date Strung",
            value = DateFormatter.formatDateWithYear(sessionWithDetails.session.dateStrung)
        )
        
        InfoRow(
            label = "Days Ago",
            value = "${sessionWithDetails.session.daysSinceStringing} days"
        )
        
        sessionWithDetails.session.locationInstalled?.let { location ->
            InfoRow(
                label = "Location",
                value = location
            )
        }
        
        sessionWithDetails.session.pricePaid?.let { price ->
            InfoRow(
                label = "Price Paid",
                value = "$${"%.2f".format(price)}"
            )
        }
    }
}

@Composable
private fun UsageTrackingSection(sessionWithDetails: SessionWithDetails) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        sessionWithDetails.session.hoursUntilBreak?.let { hours ->
            InfoRow(
                label = "Hours Until Break",
                value = "${"%.1f".format(hours)} hours"
            )
        }
        
        sessionWithDetails.session.hoursUntilDead?.let { hours ->
            InfoRow(
                label = "Hours Until Dead",
                value = "${"%.1f".format(hours)} hours"
            )
        }
        
        if (sessionWithDetails.session.hoursUntilBreak == null && 
            sessionWithDetails.session.hoursUntilDead == null) {
            Text(
                text = "No usage data recorded yet",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun FeedbackSection(
    feedback: com.tuv.tensiontracker.domain.model.SessionFeedback,
    userPreferences: UserPreferences
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        feedback.averageRating?.let { avgRating ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Overall Rating: ",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "${"%.1f".format(avgRating)}/5 ⭐",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        // Individual ratings
        val ratings = listOf(
            "Control" to feedback.controlRating,
            "Power" to feedback.powerRating,
            "Durability" to feedback.durabilityRating,
            "Spin" to feedback.spinRating,
            "Feel" to feedback.feelRating,
            "Comfort" to feedback.comfortRating
        )
        
        val hasAnyRating = ratings.any { it.second != null }
        
        if (hasAnyRating) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                ratings.forEach { (category, rating) ->
                    rating?.let {
                        InfoRow(
                            label = category,
                            value = "$it/5"
                        )
                    }
                }
            }
        }
        
        feedback.notes?.takeIf { it.isNotBlank() }?.let { notes ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Notes:",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Text(
                    text = notes,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
        
        if (!feedback.hasAnyRating && feedback.notes.isNullOrBlank()) {
            Text(
                text = "No feedback recorded yet",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
    }
}