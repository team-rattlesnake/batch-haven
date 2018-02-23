export class Post {
    postId: number;
    message: string;
    image: Blob;
    numOfLikes: number;
    // comments: Comment;

    constructor(postId: number, message: string, image: Blob, numOfLikes: number) {
        this.postId = postId;
        this.message = message;
        this.image = image;
        this.numOfLikes = numOfLikes;
    }
}
