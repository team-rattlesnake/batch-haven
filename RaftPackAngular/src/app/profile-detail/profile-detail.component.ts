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
  constructor() { }

  ngOnInit() {
    this.getProfile();
  }

  getProfile(): void {
  }

  save(): void {
  }

}
