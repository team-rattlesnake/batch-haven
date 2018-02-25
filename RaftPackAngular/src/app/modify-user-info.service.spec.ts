import { TestBed, inject } from '@angular/core/testing';

import { ModifyUserInfoService } from './modify-user-info.service';

describe('ModifyUserInfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ModifyUserInfoService]
    });
  });

  it('should be created', inject([ModifyUserInfoService], (service: ModifyUserInfoService) => {
    expect(service).toBeTruthy();
  }));
});
