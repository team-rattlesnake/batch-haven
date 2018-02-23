import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { ProfileService } from './../profile.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profiles: Profile[];
  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    this.getProfiles();
  }
  getProfiles(): void {
    this.profileService.getProfiles()
    .subscribe(profiles => this.profiles = profiles);
  }
}
