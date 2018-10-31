import { Employee } from './employee';
import { Injectable } from "@angular/core";

@Injectable()
export class CustomService {

    emp:Employee[];
    constructor() {
        this.emp=[
            new Employee(100,"Ajay",20000),
            new Employee(200,"Vijay",25000)
        ]
    }
    displayInfo():string{
        return "Welcome to Custom Service";
    }

    displayEmployees():Employee[]{
        return this.emp;
    }
}