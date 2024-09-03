import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Address } from 'src/app/Address';
import { Employee } from 'src/app/employee';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {
  @Output() onSubmit = new EventEmitter<Employee>();
  @Input() btnText!: string;

  employeeForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.employeeForm = this.formBuilder.group({
        id: new FormControl(''),
        nome: new FormControl('', [Validators.required]),
        cpf: new FormControl('', [Validators.required, Validators.minLength(11), Validators.maxLength(11)]),
        dataNascimento: new FormControl('', [Validators.required]),
        cargo: new FormControl('', Validators.required),
        endereco: this.formBuilder.group({
            logradouro: new FormControl('', [Validators.required]),
            numero: new FormControl('', [Validators.required]),
            bairro: new FormControl('', [Validators.required]),
            cep: new FormControl('', [Validators.required]),
            cidade: new FormControl('', [Validators.required]),
            estado: new FormControl('', [Validators.required])
        })
    });
  }

  get nome() {
    return this.employeeForm.get('nome')!;
  }

  get cpf() {
    return this.employeeForm.get('cpf')!;
  }

  get dataNascimento() {
    return this.employeeForm.get('dataNascimento')!;
  }

  get cargo() {
    return this.employeeForm.get('cargo')!;
  }

  get logradouro() {
    return this.employeeForm.get('endereco.logradouro')!;
  }

  get numero() {
    return this.employeeForm.get('endereco.numero')!;
  }

  get bairro() {
    return this.employeeForm.get('endereco.bairro')!;
  }

  get cep() {
    return this.employeeForm.get('endereco.cep')!;
  }

  get cidade() {
    return this.employeeForm.get('endereco.cidade')!;
  }

  get estado() {
    return this.employeeForm.get('endereco.estado')!;
  }

  submit() {
    if (this.employeeForm.invalid) {
      return;
    }

    console.log(this.employeeForm.value);
    this.onSubmit.emit(this.employeeForm.value);
  }

}
