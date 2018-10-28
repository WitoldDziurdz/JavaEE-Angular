import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {CourierService} from '../../services/courier.service';
import {Department} from '../../model/department';


@Component({
  selector: 'app-list-departments',
  templateUrl: './list-departments.component.html',
  styleUrls: ['./list-departments.component.css']
})

export class ListDepartmentsComponent implements OnInit {
  departments: Observable<Department[]>;

  constructor(private courierService: CourierService) {
  }

  ngOnInit(): void {
    this.departments = this.courierService.findAllDepartments();
  }

  remove(department: Department) {
    this.courierService.removeDepartment(department)
      .subscribe(() => this.ngOnInit());
  }
}
