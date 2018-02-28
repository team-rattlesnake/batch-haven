import { User } from './user.model';
export class Post {

    postId: number;
    message: string;
    image: Blob;
    numOfLikes: number;
    user: User;
    // comments: Comment;

    constructor(postId: number, message: string, image: Blob, numOfLikes: number, user: User) {
        this.postId = postId;
        this.message = message;
        this.image = image;
        this.numOfLikes = numOfLikes;
        this.user = user;
    }
}
