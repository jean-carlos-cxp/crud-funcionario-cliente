import { Component, OnInit } from '@angular/core';

import { Employee } from 'src/app/employee';

import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrls: ['./new-employee.component.css']
})
export class NewEmployeeComponent implements OnInit {
  btnText = 'Salvar';

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {}

  async createHandler(employee: Employee) {
    await this.employeeService.createEmployee(employee).subscribe();
  }

}
