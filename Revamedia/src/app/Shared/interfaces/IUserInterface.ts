export interface IUserInterface {


    id: number | undefined;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    /*
      constructor(_username: string, _password: string, _fName: string, _lName: string, _email: string) {
        this.username = _username;
        this.password = _password;
        this.firstName = _fName;
        this.lastName = _lName;
        this.email = _email;
    
      }
      */
}