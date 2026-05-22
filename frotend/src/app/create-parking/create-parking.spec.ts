import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateParking } from './create-parking';

describe('CreateParking', () => {
  let component: CreateParking;
  let fixture: ComponentFixture<CreateParking>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateParking],
    }).compileComponents();

    fixture = TestBed.createComponent(CreateParking);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
