package com.example.hakaton2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hakaton2.data.LocationDatabase
import com.example.hakaton2.data.LocationRecommendation
import com.example.hakaton2.ui.theme.HAKATON2Theme
import kotlin.math.min

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HAKATON2Theme {
                var currentScreen by remember { mutableStateOf("welcome") }
                var userName by remember { mutableStateOf("") }
                var selectedCity by remember { mutableStateOf("") }
                var isITProfessional by remember { mutableStateOf(false) }
                var hasFamily by remember { mutableStateOf(false) }
                var dropdownExpanded by remember { mutableStateOf(false) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimatedContent(
                        targetState = currentScreen,
                        transitionSpec = {
                            fadeIn(animationSpec = tween(300)) with 
                            fadeOut(animationSpec = tween(300))
                        }
                    ) { screen ->
                        when (screen) {
                            "welcome" -> WelcomeScreen { currentScreen = "userInput" }
                            "userInput" -> UserInputScreen(
                                userName = userName,
                                onNameChange = { userName = it },
                                selectedCity = selectedCity,
                                onCitySelected = { selectedCity = it },
                                isITProfessional = isITProfessional,
                                onITProfessionalChange = { isITProfessional = it },
                                hasFamily = hasFamily,
                                onFamilyStatusChange = { hasFamily = it },
                                dropdownExpanded = dropdownExpanded,
                                onDropdownExpandedChange = { dropdownExpanded = it },
                                onSubmit = { currentScreen = "results" }
                            )
                            "results" -> ResultsScreen(
                                city = selectedCity,
                                isITProfessional = isITProfessional,
                                hasFamily = hasFamily,
                                onBackPressed = { currentScreen = "userInput" }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(onGetStarted: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    val buttonScale = remember { Animatable(0.8f) }
    
    LaunchedEffect(Unit) {
        isVisible = true
        buttonScale.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(
                initialOffsetY = { -40 }
            ) + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Text(
                text = "Welcome to SafeNest",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(
                initialOffsetY = { 40 }
            ) + expandVertically(
                expandFrom = Alignment.Bottom
            ) + fadeIn(initialAlpha = 0.3f),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Find your perfect home in the safest locations",
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        LaunchedEffect(Unit) {
            buttonScale.animateTo(
                targetValue = 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
        
        Button(
            onClick = onGetStarted,
            modifier = Modifier.graphicsLayer {
                scaleX = buttonScale.value
                scaleY = buttonScale.value
            }
        ) {
            Text("Get Started")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputScreen(
    userName: String,
    onNameChange: (String) -> Unit,
    selectedCity: String,
    onCitySelected: (String) -> Unit,
    isITProfessional: Boolean,
    onITProfessionalChange: (Boolean) -> Unit,
    hasFamily: Boolean,
    onFamilyStatusChange: (Boolean) -> Unit,
    dropdownExpanded: Boolean,
    onDropdownExpandedChange: (Boolean) -> Unit,
    onSubmit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Tell us about yourself",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        OutlinedTextField(
            value = userName,
            onValueChange = onNameChange,
            label = { Text("Your Name") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        ExposedDropdownMenuBox(
            expanded = dropdownExpanded,
            onExpandedChange = onDropdownExpandedChange
        ) {
            OutlinedTextField(
                value = selectedCity,
                onValueChange = { },
                readOnly = true,
                label = { Text("Select City") },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            
            ExposedDropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { onDropdownExpandedChange(false) }
            ) {
                listOf("Mumbai", "Bangalore", "Delhi", "Chennai", "Kolkata", "Hyderabad", "Ahmedabad")
                    .forEach { city ->
                        DropdownMenuItem(
                            text = { Text(city) },
                            onClick = {
                                onCitySelected(city)
                                onDropdownExpandedChange(false)
                            }
                        )
                    }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isITProfessional,
                onCheckedChange = onITProfessionalChange
            )
            Text("IT Professional")
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = hasFamily,
                onCheckedChange = onFamilyStatusChange
            )
            Text("With Family")
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(
            onClick = onSubmit,
            enabled = userName.isNotBlank() && selectedCity.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Find My Perfect Location")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HAKATON2Theme {
        WelcomeScreen {}
    }
}

@Composable
fun ResultsScreen(
    city: String,
    isITProfessional: Boolean,
    hasFamily: Boolean,
    onBackPressed: () -> Unit
) {
    val recommendations = LocationDatabase.getRecommendations(city, isITProfessional, hasFamily)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = "Recommended Locations",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (recommendations.isNullOrEmpty()) {
            Text(
                text = "No recommendations found for the selected criteria",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            recommendations.forEachIndexed { index, recommendation ->
                LocationRecommendationCard(
                    recommendation = recommendation,
                    rank = index + 1
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun PreferencesCard(city: String, isITProfessional: Boolean, hasFamily: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PreferenceItem("City", city)
            PreferenceItem("Professional Type", if (isITProfessional) "IT Professional" else "Non-IT Professional")
            PreferenceItem("Family Status", if (hasFamily) "With Family" else "Without Family")
        }
    }
}

@Composable
fun PreferenceItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun LocationRecommendationCard(
    recommendation: LocationRecommendation,
    rank: Int
) {
    var expanded by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${rank}. ${recommendation.name}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                
                IconButton(onClick = { expanded = !expanded }) {
                    val rotation by animateFloatAsState(
                        targetValue = if (expanded) 180f else 0f,
                        label = "Expand arrow rotation"
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = if (expanded) "Show less" else "Show more",
                        modifier = Modifier.graphicsLayer { rotationZ = rotation }
                    )
                }
            }
            
            AnimatedVisibility(visible = expanded) {
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    MetricRow("Flood Risk", recommendation.floodRisk)
                    MetricRow("Connectivity", recommendation.connectivity)
                    MetricRow("Water Supply", recommendation.waterSupply)
                    MetricRow("Traffic", recommendation.trafficCongestion)
                    MetricRow("Business Hub Proximity", recommendation.proximityToHubs)
                    MetricRow("Air Quality", recommendation.airQuality)
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Property Price: ${recommendation.propertyPrice}",
                style = MaterialTheme.typography.bodyMedium
            )
            
            Text(
                text = "Overall Score: ${recommendation.overallScore}/10",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            AnimatedVisibility(visible = expanded) {
                Text(
                    text = recommendation.verdict,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun MetricRow(label: String, score: Double) {
    var progress by remember { mutableStateOf(0f) }
    
    LaunchedEffect(Unit) {
        animate(
            initialValue = 0f,
            targetValue = score.toFloat() / 10f,
            animationSpec = tween(1000)
        ) { value, _ -> progress = value }
    }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .width(100.dp)
                .height(8.dp),
            color = when {
                score >= 8.0 -> MaterialTheme.colorScheme.primary
                score >= 6.0 -> MaterialTheme.colorScheme.secondary
                else -> MaterialTheme.colorScheme.error
            }
        )
        Text(
            text = "${score.toInt()}/10",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun EmptyRecommendations() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = null,
            modifier = Modifier.size(48.dp),
            tint = MaterialTheme.colorScheme.error
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "No recommendations found",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Please try different preferences",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}