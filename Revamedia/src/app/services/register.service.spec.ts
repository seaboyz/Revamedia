import { HttpClient } from '@angular/common/http';
import { HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { RegisterService } from './register.service';

describe('RegisterService', () => {

  let registerService: RegisterService;
  let baseUrl;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        HttpClient,
        HttpTestingController
      ]
    });
    registerService = TestBed.inject(RegisterService);

    baseUrl = registerService.baseUrl;
  });

  it('should be created', () => {
    expect(registerService).toBeTruthy();
  });

  describe("#createUser", () => {

    it("Should create and return an Http request observable", () => {

    });
  })
});
