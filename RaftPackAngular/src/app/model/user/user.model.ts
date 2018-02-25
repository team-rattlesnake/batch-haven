export class User {

  firstname: string;
  lastname: string;
  email: string;
  password: string;
  dob: string;
  gender: string;

  constructor(firstname: string, lastname: string, email: string, password: string, gender: string,  dob: string) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.dob = dob;
    this.gender = gender;
  }
}



