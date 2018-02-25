export class User {
  userId: number;
  firstname: string;
  lastname: string;
  email: string;
  password: string;
  age: number;


  constructor(userId: number, firstname: string, lastname: string, email: string, password: string, age: number) {
    this.userId = userId;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.age = age;
  }
}



