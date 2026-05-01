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

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.warehouseForm = this.fb.group({
      warehouseId: ['', Validators.required],
      supplierId: ['', [Validators.required, Validators.min(1)]],
      warehouseName: ['', Validators.required],
      location: ['', Validators.required],
      capacity: ['', [Validators.required, Validators.min(0)]]
    });
  }

  // convenience getter for easy access in template
  get f() {
    return this.warehouseForm.controls;
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.warehouseForm.invalid) {
      return;
    }

    // Placeholder for actual submission logic
    console.log('Warehouse form submitted:', this.warehouseForm.value);

    // Reset form after submission
    this.warehouseForm.reset();
    this.submitted = false;
  }
}
