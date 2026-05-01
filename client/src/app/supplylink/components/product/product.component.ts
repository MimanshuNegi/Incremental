import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

interface Product {
  productId: string;
  warehouseId: number;
  productName: string;
  productDescription: string;
  quantity: number;
  price: number;
}

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  productForm!: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.productForm = this.fb.group({
      productId: ['', Validators.required],
      warehouseId: ['', [Validators.required, Validators.min(1)]],
      productName: ['', Validators.required],
      productDescription: [''],
      quantity: ['', [Validators.required, Validators.min(0)]],
      price: ['', [Validators.required, Validators.min(1)]]
    });
  }

  // convenience getter for easy access in template
  get f() {
    return this.productForm.controls;
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.productForm.invalid) {
      return;
    }

    // Create a Product instance from form values
    const product: Product = {
      productId: this.productForm.value.productId,
      warehouseId: this.productForm.value.warehouseId,
      productName: this.productForm.value.productName,
      productDescription: this.productForm.value.productDescription,
      quantity: this.productForm.value.quantity,
      price: this.productForm.value.price
    };

    // Placeholder for further processing (e.g., API call, service integration)
    console.log('Product submitted:', product);

    // Reset form after successful submission
    this.productForm.reset();
    this.submitted = false;
  }
}
