import { TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';

describe('AuthenticationService', () => {
  let service: AuthenticationService;
  //creates a Spy (like a mock but can call actuall code if needed) named "HttpClient" that monitors all Post requests in methods
  let HttpClientSpy: { post: jasmine.Spy } = jasmine.createSpyObj('HttpClient', ['post']);

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        AuthenticationService,
        { provide: HttpClient, useValue: HttpClientSpy }
      ]
    });
    service = TestBed.inject(AuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe("#Login", () => {
    it("Should send a AuthDto and receive a Response entity with status 'OK'. If an error occurs, then it should display the text in the element class'invalid'")
  })
});
