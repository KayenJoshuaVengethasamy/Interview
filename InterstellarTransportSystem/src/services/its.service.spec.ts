import { TestBed } from '@angular/core/testing';

import { ITSService } from './its.service';

describe('ITSService', () => {
  let service: ITSService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ITSService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
