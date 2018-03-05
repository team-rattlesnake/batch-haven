import { Component, OnInit, Input } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { User } from '../models/user.model';
import { LoginComponent } from '../login/login.component';
import { Message } from '../models/message.model';
import { UploadFileService } from '../services/upload.service';
import { FileUpload } from '../models/file-upload';
import { Observable } from 'rxjs/Observable';
import { ModifyUserService } from '../services/modify-user.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;
  @Input() exists: boolean;
  show = false;
  selectedFiles: FileList;
  @Input() fileUpload: FileUpload;
  fileUploads: Observable<Array<FileUpload>>;
  imageString: string;

  constructor(
    private profileService: ProfileService,
    private uploadService: UploadFileService,
    private route: ActivatedRoute,
    private modifyUserService: ModifyUserService,
    private router: Router) { }

  public message: Message = new Message('No profile to display.');

  getProfile() {
    const id = +this.route.snapshot.paramMap.get('id');
    if (id) {
      this.profileService.getProfile(id).subscribe(
        user => this.user = user,
        error => this.message.text = `Couldn't find Profile.`
      );
    } else {
      this.profileService.getProfile(parseInt(document.cookie, 10)).subscribe(
        user => {
          this.user = user;
          console.log(this.user);
          console.log(document.cookie = this.user.userId.valueOf().toString());
        },
        error => this.message.text = `Couldn't find Profile.`);
    }
  }

  ngOnInit(): void {
    this.getProfile();
  }

  upload() {
    const file = this.selectedFiles.item(0);
    this.uploadService.uploadfile(file).subscribe(profile_image => this.user.profile_image = profile_image);
    console.log(this.user);
    this.imageString = 'https://s3.amazonaws.com/jsa-angular-bucket/jsa-s3/' + this.user.profile_image + '.png';
    this.user.profile_image = this.imageString;
    this.modifyUserService.update(this.user).subscribe(user => this.user = user);
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  showFiles(enable: boolean) {
    // this.show = enable;
    this.router.navigate(['/profilePosts']);

  }
}
