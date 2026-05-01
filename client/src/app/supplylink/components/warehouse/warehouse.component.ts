import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss']
})
export class WarehouseComponent implements OnInit {
  warehouseForm!: FormGroup;
  submitted = false;
  backendError: string | null = null;
  successMessage: string | null = null;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.warehouseForm = this.fb.group({
      supplierId: ['', Validators.required],
      warehouseName: ['', Validators.required],
      location: [''],
      capacity: ['', [Validators.required, Validators.min(0)]]
    });
  }

  // convenience getter
  get f() {
    return this.warehouseForm.controls;
  }

  onSubmit(): void {
    this.submitted = true;
    this.backendError = null;
    this.successMessage = null;

    if (this.warehouseForm.invalid) {
      return;
    }

    const formData = this.warehouseForm.value;

    if (this.simulateBackendError(formData.warehouseName)) {
      this.backendError = 'Warehouse name already exists. Please choose another.';
      return;
    }

    // Success
    this.successMessage = 'Warehouse registered successfully!';
    console.log('Warehouse form submitted:', formData);

    this.warehouseForm.reset();
    this.submitted = false;
  }

  simulateBackendError(warehouseName: string): boolean {
    const existingWarehouses = ['Central Depot', 'Main Storage'];
    return existingWarehouses.includes(warehouseName);
  }
}
