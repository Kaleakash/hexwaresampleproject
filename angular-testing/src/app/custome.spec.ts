import { Employee } from './employee';
import { CustomService } from './custom';

import { TestBed, async, inject } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { EmployeeService } from './employee.service';

describe('Custom Service', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
      providers:[CustomService]
    }).compileComponents();
  }));

  //Service Testing  

  it('Custom Service should be created', inject([CustomService], 
    (service: CustomService) => {
    expect(service).toBeTruthy();
  }));

  it('Custom Service string message', inject([CustomService], 
    (service: CustomService) => {
    expect(service.displayInfo()).toContain("Welcome to Custom Service");
  }));

  xit('Custom Service employee array name', inject([CustomService], 
    (service: CustomService) => {
        let employees = service.displayEmployees();
        let name = employees[1].name;
        expect(name).toContain("Vijay");
  }));


  });

 
  class FakeCustomClass{
    displayInfo():string{
        return "Custom Fake Message";
    }
    emp:Employee[];
    displayEmployees():Employee[]{
        this.emp=[new Employee(1010,"Dinesh",45000)]
        return this.emp;    
    }
  }

  describe('Custom Service - Mock Object ', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          RouterTestingModule
        ],
        declarations: [
          AppComponent
        ],
        providers:[{provide: CustomService, useClass: FakeCustomClass}]
      }).compileComponents();
    }));
  
    //Service Testing   - Mock Service Method 
  
    it('Custom Service string message - Mock Method', inject([CustomService], 
        (service: CustomService) => {
        expect(service.displayInfo()).toContain("Custom Fake Message");
      }));
  
      it('Custom Service employee array name and salary - Mock Method', inject([CustomService], 
        (service: CustomService) => {
            let employees = service.displayEmployees();
            let id = employees[0].id;
            let name = employees[0].name;
            let salary = employees[0].salary;
            expect(id).toEqual(1010);   
            expect(name).toContain("Dinesh");
            expect(salary).toEqual(45000);    
      }));
  
    
    });