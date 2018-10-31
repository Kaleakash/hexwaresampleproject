import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
@Injectable()
export class EmployeeService {
    constructor(private httpClient:HttpClient){}

    getEmployeeInfo():Observable<Employee[]>{
        return this.httpClient.get<Employee[]>("http://localhost:9191/Rest/webapi/obj/getEmps");
    }
}