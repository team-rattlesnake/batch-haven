import { User } from './user.model';

export class Profile {
    profileId: number;
    user: User;
    biography: string;
    profileImage: string;
    constructor(profileId: number, user: User, biography: string, profileImage: string) {
        this.profileId = profileId;
        this.user = user;
        this.biography = biography;
        this.profileImage = profileImage;
    }
}
