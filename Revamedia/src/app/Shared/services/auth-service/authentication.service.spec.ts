import { TestBed } from '@angular/core/testing';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing'



fdescribe('AuthenticationService', () => {
  let authService: AuthenticationService;
  let routerSpy: { navigateByUrl: jasmine.Spy };
  let httpClient: HttpClient;
  let httpController: HttpTestingController;
  beforeEach(() => {
    routerSpy = jasmine.createSpyObj('Router', ['navigateByUrl']);
    let store: any = {};
    const mockSessionStorage = {
      getItem: (key: string): string => {
        return key in store ? store[key] : null;
      },
      setItem: (key: string, value: string) => {
        store[key] = `${value}`;
      },
      removeItem: (key: string) => {
        delete store[key];
      },
      clear: () => {
        store = {};
      }
    };

    spyOn(sessionStorage, 'getItem')
      .and.callFake(mockSessionStorage.getItem);

    spyOn(sessionStorage, 'setItem')
      .and.callFake(mockSessionStorage.setItem);

    spyOn(sessionStorage, 'removeItem')
      .and.callFake(mockSessionStorage.removeItem);


    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AuthenticationService,
        { provide: Router, useValue: routerSpy },
      ],

    });
    authService = TestBed.inject(AuthenticationService);
    httpClient = TestBed.inject(HttpClient);
    httpController = TestBed.inject(HttpTestingController);


  });

  it('should be created', () => {
    expect(authService).toBeTruthy();
  });

  it('checkLoginStatusReturns true when loginCookie is equal to 1', () => {
    sessionStorage.setItem('LoggedIn', '1');
    let result = authService.checkLoginStatus();
    expect(result).toBeTrue;
  });

  it('checkLoginStatusReturns false when loginCookie is not equal to 1', () => {
    let result = authService.checkLoginStatus();
    expect(result).toBeFalse;
  });

  it('Login should navigate to homepage if successful', () => {
    const testForm = <NgForm>{
      value: {
        username: "shady",
        password: "Password1!"
      }
    };
    const user = {
      username: "shady",
      password: "Passowrd1!"
    }
    authService.login(testForm);
    const request = httpController.expectOne(authService.authUrl);
    request.flush(user);
    expect(routerSpy.navigateByUrl).toHaveBeenCalledWith('/home');


  });

  it('Login should print error if there is an error ', () => {
    const testForm = <NgForm>{
      value: {
        username: "",
        password: ""
      }
    };

    authService.login(testForm)

  })


  it('Logout should delete the user cookie and session storage', () => {
    authService.logout();
    expect(authService.loggedIn).toBeFalse;
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('LoggedIn');
  });

  it('Logout should navigate to login', () => {
    authService.logout();
    expect(routerSpy.navigateByUrl).toHaveBeenCalledWith('/login');
  });

});
