package com.keepr.app.ui.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplianceDetailScreen(
    applianceId: Long,
    onNavigateBack: () -> Unit,
    onNavigateToEdit: (Long) -> Unit,
    viewModel: ApplianceDetailViewModel = hiltViewModel()
) {
    val appliance by viewModel.appliance.collectAsState()
    
    LaunchedEffect(applianceId) {
        viewModel.loadAppliance(applianceId)
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(appliance?.name ?: "Appliance Details") },
                navigationIcon = {
                    Button(onClick = onNavigateBack) {
                        Text("Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        val currentAppliance = appliance
        if (currentAppliance != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DetailRow("Name", currentAppliance.name)
                DetailRow("Category", currentAppliance.category)
                DetailRow("Purchase Date", currentAppliance.formattedPurchaseDate)
                DetailRow("Warranty End Date", currentAppliance.formattedWarrantyEndDate)
                DetailRow("Status", currentAppliance.expiryStatus)
                
                currentAppliance.modelNumber?.let { DetailRow("Model Number", it) }
                currentAppliance.serialNumber?.let { DetailRow("Serial Number", it) }
                currentAppliance.vendorName?.let { DetailRow("Vendor", it) }
                
                currentAppliance.receiptImagePath?.let { imagePath ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        // Load image using ImageManager - for MVP, we'll show placeholder
                        // In production, inject ImageManager and load the image
                        val imageUri = viewModel.getImageUri(imagePath)
                        if (imageUri != null) {
                            Image(
                                painter = rememberAsyncImagePainter(imageUri),
                                contentDescription = "Receipt",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp),
                                contentScale = ContentScale.Fit
                            )
                        } else {
                            Text(
                                text = "Receipt Image",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = { onNavigateToEdit(applianceId) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Edit")
                }
            }
        } else {
            Text(
                text = "Appliance not found",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
