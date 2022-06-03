import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NgForm } from '@angular/forms';
import { LoginComponent } from './login.component';
import { AuthenticationService } from 'app/Shared/services/auth-service/authentication.service';

fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    let authServiceSpy = jasmine.createSpyObj<AuthenticationService>(['login']);
    authServiceSpy.login.and.returnValue()
    await TestBed.configureTestingModule({
      declarations: [LoginComponent],
      providers: [{ provide: AuthenticationService, userValue: authServiceSpy }]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('AuthenticationService.login should be called', () => {
    const testForm = <NgForm>{
      value: {
        username: "shady",
        password: "Password1!"
      }
    };
    component.TEMPLogIn(testForm);
    fixture.whenStable().then(() => {
      expect(component.auth.login(testForm)).toHaveBeenCalled
    })
  })

  it('toggleShowPassword() should flip the value of showPassword', () => {
    let StoreVal = component.showPassword;
    spyOn(component, 'toggleShowPassword');
    component.toggleShowPassword();
    expect(component.showPassword).not.toEqual(StoreVal);
  })


});
