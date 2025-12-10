package com.keepr.app.ui.screens.add

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.keepr.app.util.DateUtils
import kotlinx.coroutines.launch
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditApplianceScreen(
    applianceId: Long? = null,
    onNavigateBack: () -> Unit,
    viewModel: AddEditApplianceViewModel = hiltViewModel()
) {
    val name by viewModel.name.collectAsState()
    val category by viewModel.category.collectAsState()
    val purchaseDate by viewModel.purchaseDate.collectAsState()
    val warrantyEndDate by viewModel.warrantyEndDate.collectAsState()
    val modelNumber by viewModel.modelNumber.collectAsState()
    val serialNumber by viewModel.serialNumber.collectAsState()
    val vendorName by viewModel.vendorName.collectAsState()
    val receiptImageUri by viewModel.receiptImageUri.collectAsState()
    val isEditMode by viewModel.isEditMode.collectAsState()
    
    val scope = rememberCoroutineScope()
    
    // Load appliance if editing
    if (applianceId != null && !isEditMode) {
        viewModel.loadAppliance(applianceId)
    }
    
    val categories = listOf("Electronics", "Kitchen", "Vehicle", "Other")
    var categoryExpanded by remember { mutableStateOf(false) }
    
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { viewModel.onImageSelected(it) }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (isEditMode) "Edit Appliance" else "Add Appliance") },
                navigationIcon = {
                    TextButton(onClick = onNavigateBack) {
                        Text("Cancel")
                    }
                },
                actions = {
                    TextButton(
                        onClick = {
                            scope.launch {
                                if (viewModel.onSave()) {
                                    onNavigateBack()
                                }
                            }
                        }
                    ) {
                        Text("Save")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { viewModel.setName(it) },
                label = { Text("Appliance Name *") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            ExposedDropdownMenuBox(
                expanded = categoryExpanded,
                onExpandedChange = { categoryExpanded = it }
            ) {
                OutlinedTextField(
                    value = category,
                    onValueChange = { },
                    readOnly = true,
                    label = { Text("Category *") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryExpanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                DropdownMenu(
                    expanded = categoryExpanded,
                    onDismissRequest = { categoryExpanded = false }
                ) {
                    categories.forEach { cat ->
                        DropdownMenuItem(
                            text = { Text(cat) },
                            onClick = {
                                viewModel.setCategory(cat)
                                categoryExpanded = false
                            }
                        )
                    }
                }
            }
            
            DatePickerField(
                label = "Purchase Date *",
                timestamp = purchaseDate,
                onDateSelected = { viewModel.setPurchaseDate(it) }
            )
            
            DatePickerField(
                label = "Warranty End Date *",
                timestamp = warrantyEndDate,
                onDateSelected = { viewModel.setWarrantyEndDate(it) }
            )
            
            OutlinedTextField(
                value = modelNumber,
                onValueChange = { viewModel.setModelNumber(it) },
                label = { Text("Model Number") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            OutlinedTextField(
                value = serialNumber,
                onValueChange = { viewModel.setSerialNumber(it) },
                label = { Text("Serial Number") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            OutlinedTextField(
                value = vendorName,
                onValueChange = { viewModel.setVendorName(it) },
                label = { Text("Vendor/Shop Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Button(
                onClick = { galleryLauncher.launch("image/*") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Select Receipt Image")
            }
            
            receiptImageUri?.let { uri ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = rememberAsyncImagePainter(uri),
                        contentDescription = "Receipt",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}

@Composable
fun DatePickerField(
    label: String,
    timestamp: Long?,
    onDateSelected: (Long) -> Unit
) {
    val dateText = timestamp?.let { DateUtils.formatDate(it) } ?: ""
    
    OutlinedTextField(
        value = dateText,
        onValueChange = { },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        trailingIcon = {
            TextButton(onClick = {
                // Simple date picker - in production, use Material DatePicker
                val calendar = Calendar.getInstance()
                if (timestamp != null) {
                    calendar.timeInMillis = timestamp
                }
                onDateSelected(calendar.timeInMillis)
            }) {
                Text("Select")
            }
        }
    )
}
