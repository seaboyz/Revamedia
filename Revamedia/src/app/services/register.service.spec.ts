import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { RegisterService } from './register.service';

describe('RegisterService', () => {
  let service: RegisterService;
  let HttpClientSpy: { post: jasmine.Spy } = jasmine.createSpyObj('HttpClient', ['post']);


  beforeEach(() => {

    HttpClientSpy.post.and.returnValue(1);

    TestBed.configureTestingModule({
      providers: [
        { provide: HttpClient, useValue: HttpClientSpy }
      ]
    });
    service = TestBed.inject(RegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe("#createUser", () => {

    it("Should create and return a observable to register", () => {

    });
  })
});
