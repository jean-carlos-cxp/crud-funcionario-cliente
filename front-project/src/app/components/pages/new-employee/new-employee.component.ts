import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Employee } from 'src/app/employee';
import { EmployeeService } from 'src/app/services/employee/employee.service';

import { MessagesService } from 'src/app/services/messages/messages.service';

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrls: ['./new-employee.component.css']
})
export class NewEmployeeComponent implements OnInit {
  btnText = 'Salvar';

  constructor(
    private employeeService: EmployeeService, 
    private messagesService: MessagesService,
    private router: Router) {}

  ngOnInit(): void {}

  async createHandler(employee: Employee) {
    await this.employeeService.createEmployee(employee).subscribe();
    this.messagesService.add('Colaborador cadastrado com sucesso!');
    this.router.navigate(['/']);
  }

}
