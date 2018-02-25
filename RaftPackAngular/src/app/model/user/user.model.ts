export class User {
  userId: number;
  firstname: string;
  lastname: string;
  email: string;
  password: string;
  age: number;


  constructor(firstname: string, lastname: string, email: string, password: string, age: number) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.age = age;
  }
}



