import { EmployeeService } from './employee.service';
import { Employee } from './employee';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-testing';
  name:string="Raj Deep";
  employees:Employee[];
  restEmployees:Employee[];
  res:string;
  constructor(private employeeService:EmployeeService){
    this.employees=[
      new Employee(1,"Raj",12000),
      new Employee(2,"Ravi",14000),
      new Employee(3,"Ramesh",16000),
      new Employee(4,"Rajesh",18000),
    ]

    this.employeeService.getEmployeeInfo().subscribe(data=>this.restEmployees=data);
  }

  storeEmployeeInfo():void {
    this.employeeService.storeEmployeeInOf().subscribe(data=>this.res=data);
  }
}
