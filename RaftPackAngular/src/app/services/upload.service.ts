import { Injectable } from '@angular/core';
import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { FileUpload } from '../models/file-upload';

@Injectable()
export class UploadFileService {

  FOLDER = 'jsa-s3/';
  BUCKET = 'jsa-angular-bucket';

  constructor() { }

  private getS3Bucket(): any {
    const bucket = new S3(
      {
        accessKeyId: 'AKIAJWDG7XULVVOO2HUA',
        secretAccessKey: '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',
        region: 'us-east-1'
      }
    );

    return bucket;
  }

  uploadfile(file) {
    const params = {
      Bucket: this.BUCKET,
      Key: this.FOLDER + file.name,
      Body: file,
      ACL: 'public-read'
    };

    this.getS3Bucket().upload(params, function (err, data) {
      if (err) {
        console.log('There was an error uploading your file: ', err);
        return false;
      }

      console.log('Successfully uploaded file.', data);
      return true;
    });
  }

  getFiles(): Observable<Array<FileUpload>> {
    const fileUploads = new Array<FileUpload>();

    const params = {
      Bucket: this.BUCKET,
      Prefix: this.FOLDER
    };

    this.getS3Bucket().listObjects(params, function (err, data) {
      if (err) {
        console.log('There was an error getting your files: ' + err);
        return;
      }

      console.log('Successfully get files.', data);

      const fileDatas = data.Contents;

      fileDatas.forEach(function (file) {
        fileUploads.push(new FileUpload(file.Key, 'https://s3.amazonaws.com/' + params.Bucket + '/' + file.Key));
      });
    });

    return Observable.of(fileUploads);
  }

}
