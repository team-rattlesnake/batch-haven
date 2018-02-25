export class User {
  userId: number;
  firstname: string;
  lastname: string;
  email: string;
  password: string;
  age: number;

  first_name: string;
  last_name: string;
  user_email: string;
  user_password: string;
  date_of_birth: string;
  gender: string;

  constructor(first_name: string, last_name: string, user_email: string, user_password: string, gender: string,  date_of_birth: string) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.user_email = user_email;
    this.user_password = user_password;
    this.date_of_birth = date_of_birth;
    this.gender = gender;
  }
}



