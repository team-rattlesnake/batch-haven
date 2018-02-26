import { Profile } from './profile.model';
import { Post } from './post.model';

export class UserOld {
    userId: number;
    userEmail: string;
    userPassword: string;
    firstName: string;
    lastName: string;
    monthOfBirth: string;
    dayOfBirth: number;
    yearOfBirth: number;
    gender: string;
    profile: Profile;
    myPosts: Post[];
    friends: UserOld[];
    likedPosts: Post[];

    constructor(userId: number, userEmail: string, userPassword: string,
                firstName: string, lastName: string, monthOfBirth: string,
                dayOfBirth: number, yearOfBirth: number, gender: string,
                profile: Profile, myPosts: Post[], friends: UserOld[], likedPosts: Post[]) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.profile = profile;
        this.myPosts = myPosts;
        this.friends = friends;
        this.likedPosts = likedPosts;
    }
}
