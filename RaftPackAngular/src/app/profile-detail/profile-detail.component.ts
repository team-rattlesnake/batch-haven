import { Component, OnInit, Input } from '@angular/core';
import { Profile } from '../models/profile.model';
import { ActivatedRoute } from '@angular/router';
import { ProfileService } from '../services/profile.service';

@Component({
  selector: 'app-profile-detail',
  templateUrl: './profile-detail.component.html',
  styleUrls: ['./profile-detail.component.css']
})
export class ProfileDetailComponent implements OnInit {
  @Input() profile: Profile;
  constructor( private profileService: ProfileService) { }

  ngOnInit() {
    this.getProfile();
  }

  getProfile(): void {
    this.profileService.getProfilec(123)
      .subscribe(profile => this.profile = profile);
  }

  save(): void {
    this.profileService.updateProfile(this.profile).subscribe();
  }

}
