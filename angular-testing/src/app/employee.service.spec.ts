import { CustomService } from './custom';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import {HttpClientTestingModule,HttpTestingController} from '@angular/common/http/testing';
import { TestBed, async, inject } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';


describe('Employee Service- Http Mock Object ', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,HttpClientTestingModule
      ],
      declarations: [
        AppComponent
      ],
      providers:[CustomService,EmployeeService]
    }).compileComponents();
  }));

  //Employee Service Testing with Http Service Testing   

  it('Employee Service should be created', inject([EmployeeService], 
    (empService: EmployeeService) => {
    expect(empService).toBeTruthy();
  }));

  it('get Employee Info - Mock Http Service',
  inject(
    [HttpTestingController, EmployeeService],
    (httpMock: HttpTestingController, empService: EmployeeService) => {
      const mockEmp = [
        { "id": 1000, "name":"Ajay","salary":12000},
        { "id": 1001, "name":"Vijay","salary":14000}
      ];

      empService.getEmployeeInfo().subscribe((data:any)=>{
        expect(data[1].id).toEqual(1001);
        expect(data[1].name).toBe("Vijay");
        expect(data[1].salary).toEqual(14000);

        expect(data.length).toBe(2);
      });
      
      const req = httpMock.expectOne(`http://localhost:9191/Rest/webapi/obj/getEmps`, 'call to api');
      expect(req.request.method).toBe('GET');
      req.flush(mockEmp);
      httpMock.verify();
    }
  )
);



  });

 
 
