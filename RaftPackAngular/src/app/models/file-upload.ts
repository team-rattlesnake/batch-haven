export class FileUpload {
    name: string;
    writable: true;
    url: string;

    constructor(name: string, url: string) {
        this.name = name;
        this.url = url;
    }
}
