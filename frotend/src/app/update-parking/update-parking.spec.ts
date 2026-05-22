import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateParking} from './update-parking';

describe('UpdateParking', () => {
  let component: UpdateParking;
  let fixture: ComponentFixture<UpdateParking>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateParking],
    }).compileComponents();

    fixture = TestBed.createComponent(UpdateParking);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
