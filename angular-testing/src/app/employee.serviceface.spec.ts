import { Observable ,of} from 'rxjs';
import { Employee } from './employee';
import { TestBed, async, inject } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

/*
export class EmployeeService {
    constructor(private httpClient:HttpClient){}

    getEmployeeInfo():Observable<Employee[]>{
        return this.httpClient.get<Employee[]>("http://localhost:9191/Rest/webapi/obj/getEmps");
    }

    storeEmployeeInOf():Observable<string>{
        return this.httpClient.post("http://localhost:9191/Rest/webapi/obj/pathParamPost/Akash/Kale",{},{responseType:"text"});
    }

}
*/

class EmployeeServiceFake {
    
    emp:Employee[];

    getEmployeeInfo():Observable<Employee[]>{
        let e1 = new Employee(100,"Raj",12000);
        let e2 = new Employee(101,"Ravi",14000);
        let e3 = new Employee(102,"Raju",16000);
        let e4 = new Employee(103,"Ramu",18000);
        this.emp=[e1,e2,e3,e4];
        
        return of(this.emp);
    }

    storeEmployeeInfo():Observable<string>{
        return of("sucessfully store");

    }

}
  describe('Employee Service - Mock Object ', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          RouterTestingModule
        ],
        declarations: [
          AppComponent
        ],
        providers:[{provide: EmployeeServiceFake, useClass: EmployeeServiceFake}]
      }).compileComponents();
    }));
  
    //Service Testing   - Mock Service Method 
  
    it('Employee service post method - Mock Method', inject([EmployeeServiceFake], 
        (service: EmployeeServiceFake) => {
          service.storeEmployeeInfo().subscribe(data=>{
            expect(data).toEqual("sucessfully store")
          })
        
      }));
  
      it('Employee Service get method - Mock Method', inject([EmployeeServiceFake], 
        (service: EmployeeServiceFake) => {
            let employees = service.getEmployeeInfo().subscribe(emp=>{
            let id = emp[0].id;
            let name = emp[0].name;
            let salary = emp[0].salary;
            expect(id).toEqual(100);              
            expect(name).toContain("Raj");
            expect(salary).toEqual(12000);                   
            })
             
      }));
  
    
    });