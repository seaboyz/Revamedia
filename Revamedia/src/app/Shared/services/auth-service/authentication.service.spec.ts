import { TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { NgForm } from '@angular/forms';

describe('AuthenticationService', () => {
  let authService: AuthenticationService;
  let httpSpy: { post: jasmine.Spy };
  let routerSpy: { navigateByUrl: jasmine.Spy };
  /*
  //creates a Spy (like a mock but can call actuall code if needed) named "HttpClient" that monitors all Post requests in methods
  let HttpClientSpy: { post: jasmine.Spy } = jasmine.createSpyObj('HttpClient', ['post']);
  */
  beforeEach(() => {
    httpSpy = jasmine.createSpyObj('HttpClient', ['post']);
    routerSpy = jasmine.createSpyObj('Router', ['navigateByUrl(/home)', 'navigateByUrl(/login)']);
    TestBed.configureTestingModule({
      providers: [AuthenticationService,
        { provide: HttpClient, userValue: httpSpy }
      ],

    });
    authService = TestBed.inject(AuthenticationService);

  });

  it('should be created', () => {
    expect(authService).toBeTruthy();
  });

  it('checkLoginStatus returns true when logged in', () => {
    const testForm = <NgForm>{
      value: {
        username: "shady",
        password: "Password1!"
      }
    };

    expect(authService.loggedIn.value).toEqual(true);

  })
});
