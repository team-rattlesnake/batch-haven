import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UploadFileService } from './../services/upload.service';
import { PostService } from '../services/post.service';
import { Post } from '../models/post.model';
import { ProfileService } from './../services/profile.service';
import { User } from '../models/user.model';
import { PostComponent } from './../post/post.component';
import { Socket } from 'ng-socket-io';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-data-upload',
  templateUrl: './form-data-upload.component.html'
})
export class FormdataUploadComponent {
  form: FormGroup;
  loading = false;
  file: any;
  uid: any;
  post = new Post(0, '', '', 0, null, null);
  user = new User(0, '', '', '', '', '', '', '', '');
  @ViewChild('fileInput') fileInput: ElementRef;

  constructor(private fb: FormBuilder, private uploadFileService: UploadFileService, private postService: PostService,
    private profileService: ProfileService, private postComponent: PostComponent, private socket: Socket, private router: Router) {
    this.createForm();
  }

  createForm() {
    this.form = this.fb.group({
      message: ['', Validators.required],
      image: null
    });
  }

  onFileChange(event) {
    if (event.target.files.length > 0) {
      this.file = event.target.files[0];
      this.form.get('image').setValue(this.file);
    }
  }

  private prepareSave(): any {
    const input = new FormData();
    input.append('message', this.form.get('message').value);
    if (this.form.get('image') != null) {
      input.append('image', this.form.get('image').value);
    } else { input.append('image', null); }

    return input;
  }

  onSubmit() {
    const formModel = this.prepareSave();
    this.loading = true;
    if (this.form.get('image').value != null) {
      this.uploadFileService.uploadfile(this.file).subscribe(image => {
        this.post.image = image;
        this.profileService.getProfile(parseInt(document.cookie, 10)).subscribe(user => {
          this.post.user = user;
          console.log(this.post);
          this.post.message = this.form.get('message').value;
          console.log(this.post);
          this.postComponent.createPost(this.post.message, this.post.image);
          console.log(this.post);
          setTimeout(() => {
            alert('done!');
            this.loading = false;
          }, 1000);
          this.sendNotification(user, this.post.message);
          this.router.navigate(['./dashboard']);
        });
      });
    } else {
      this.profileService.getProfile(parseInt(document.cookie, 10)).subscribe(user => {
        this.post.user = user;
        console.log(this.post);
        this.post.message = this.form.get('message').value;
        console.log(this.post);
        this.postComponent.createPost(this.post.message, null);
        console.log(this.post);
        setTimeout(() => {
          alert('done!');
          this.loading = false;
        }, 1000);
        this.sendNotification(user, this.post.message);
        this.router.navigate(['./dashboard']);
      });
    }

  }
  sendNotification(user: User, message: string) {
    this.socket.emit('create notification', user.first_name + user.last_name + ': ' + message );
  }

  clearFile() {
    this.form.get('image').setValue(null);
    this.fileInput.nativeElement.value = '';
  }

}
