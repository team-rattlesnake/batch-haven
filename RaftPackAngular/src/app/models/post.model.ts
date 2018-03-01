import { User } from './user.model';
export class Post {

    postId: number;
    message: string;
    image: string;
    numOfLikes: number;
    user: User;
    date: Date;
    // comments: Comment;

    constructor(postId: number, message: string, image: string, numOfLikes: number, user: User, date: Date) {
        this.postId = postId;
        this.message = message;
        this.image = image;
        this.numOfLikes = numOfLikes;
        this.user = user;
        this.date = date;
    }
}
