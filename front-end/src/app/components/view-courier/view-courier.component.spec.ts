import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCourierComponent } from './view-courier.component';

describe('ViewCourierComponent', () => {
  let component: ViewCourierComponent;
  let fixture: ComponentFixture<ViewCourierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCourierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCourierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
