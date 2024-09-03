import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { error } from 'console';
import { catchError, Observable, throwError } from 'rxjs';
import { Employee } from 'src/app/employee';
import { Response } from 'src/app/response';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseApiUrl = environment.baseApiUrl
  private apiUrl = `${this.baseApiUrl}/v1/funcionarios`

  constructor(private http: HttpClient) {}

  private getDefaultHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json'
    });
  }

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.apiUrl, {
      headers: this.getDefaultHeaders()
    }).pipe(
      catchError(error => {
        console.error('Erro ao buscar colaboradores da base de dados', error);
        return throwError(() => new Error('Erro ao buscar colaboradores da base de dados'));
      })
    );
  }

  createEmployee(employee: Employee) : Observable<any> {
    return this.http.post(this.apiUrl, employee, {
      headers: this.getDefaultHeaders()
    }).pipe(
      catchError(error => {
        console.error('Erro ao tentar cadastrar colaborador.', error);
        return throwError(() => new Error('Erro ao tentar cadastrar colaborador.'));
      })
    );
  }

}
