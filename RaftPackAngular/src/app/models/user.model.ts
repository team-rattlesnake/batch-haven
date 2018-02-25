import { Profile } from './profile.model';
import { Post } from './post.model';

export class User {
    userId: number;
    userEmail: string;
    userPassword: string;
    firstName: string;
    lastName: string;
    monthOfBirth: string;
    dayOfBirth: number;
    yearOfBirth: number;
    gender: string;

    constructor(userId: number, userEmail: string, userPassword: string,
                firstName: string, lastName: string, monthOfBirth: string,
                dayOfBirth: number, yearOfBirth: number, gender: string,
                ) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }
}
