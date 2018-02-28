import { TestBed, inject } from '@angular/core/testing';

import { ModifyUserService } from './modify-user.service';

describe('ModifyUserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ModifyUserService]
    });
  });

  it('should be created', inject([ModifyUserService], (service: ModifyUserService) => {
    expect(service).toBeTruthy();
  }));
});
