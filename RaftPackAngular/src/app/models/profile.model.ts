import { User } from './User.model';

export class Profile {
    profileId: number;
    user: User;
    biography: string;

    constructor(profileId: number, user: User, biography: string) {
        this.profileId = profileId;
        this.user = user;
        this.biography = biography;
    }
}
