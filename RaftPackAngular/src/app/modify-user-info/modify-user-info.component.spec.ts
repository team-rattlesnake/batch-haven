import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyUserInfoComponent } from './modify-user-info.component';

describe('ModifyUserInfoComponent', () => {
  let component: ModifyUserInfoComponent;
  let fixture: ComponentFixture<ModifyUserInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyUserInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyUserInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
