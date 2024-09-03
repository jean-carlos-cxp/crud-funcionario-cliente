import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseApiUrl = environment.baseApiUrl
  private apiUrl = `${this.baseApiUrl}/v1/funcionarios`

  constructor(private http: HttpClient) {}

  createEmployee(employee: Employee) : Observable<any> {
    return this.http.post(this.apiUrl, employee, {
      headers: {
        'Content-Type': 'application/json'
      }
    });
  }

}
