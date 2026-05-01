import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.scss']
})
export class SupplierComponent implements OnInit {
  supplierForm!: FormGroup;
  submitted = false;
  backendError: string | null = null;
  successMessage: string | null = null;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.supplierForm = this.fb.group({
      supplierName: ['', [Validators.required, Validators.pattern(/^[A-Za-z ]+$/)]],
      email: ['', [Validators.required, Validators.email]],
      phone: [''],
      address: [''],
      username: ['', [Validators.required, this.noSpecialCharacters]],
      password: ['', [
        Validators.required,
        Validators.pattern(/^(?=.*[A-Z])(?=.*\d).{8,}$/)
      ]],
      role: ['', Validators.required]
    });
  }

  get f() {
    return this.supplierForm.controls;
  }

  noSpecialCharacters(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    if (!value) return null;
    const regex = /^[A-Za-z0-9]+$/; // only letters and numbers allowed
    return regex.test(value) ? null : { noSpecialCharacters: true };
  }

  onSubmit(): void {
    this.submitted = true;
    this.backendError = null;
    this.successMessage = null;

    if (this.supplierForm.invalid) {
      return;
    }

    const formData = this.supplierForm.value;
    if (formData.username === 'existingUser') {
      this.backendError = 'Username already exists. Please choose another.';
      return;
    }

    this.successMessage = 'Supplier registered successfully!';
    console.log('Supplier form submitted:', formData);

    this.supplierForm.reset();
    this.submitted = false;
  }
}
