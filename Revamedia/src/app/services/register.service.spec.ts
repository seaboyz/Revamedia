import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { Observable } from 'rxjs';

import { RegisterService } from './register.service';

describe('RegisterService', () => {

  let httpClientSpy: { post: jasmine.Spy };
  let registerService: RegisterService;
  let baseUrl;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: HttpClient, useValue: httpClientSpy }
      ]
    });
    registerService = TestBed.inject(RegisterService);

    baseUrl = registerService.baseUrl;
  });

  // Smoke test
  it('should be created', () => {
    expect(registerService).toBeTruthy();
  });

  // Create User Method
  describe("#createUser", () => {

    let body: object;
    let options: object;

    beforeEach( () => {
      body = {
        username: 'username',
        password: 'password',
        email: 'myEmail@email.com',
        firstName: 'John',
        lastName: 'Doe'
      };

      options = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      };
    });

    fit("Should create and return an observable", () => {
      let returnedObservable: Observable<any> = registerService.createUser(body, options);

      expect(returnedObservable).toBeInstanceOf(Observable);
    });

    it("Should create an http request that sends body and options that are passed into method", () => {

    });

  })
});
