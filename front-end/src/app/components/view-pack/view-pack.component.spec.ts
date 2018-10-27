import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPackComponent } from './view-pack.component';

describe('ViewPackComponent', () => {
  let component: ViewPackComponent;
  let fixture: ComponentFixture<ViewPackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
