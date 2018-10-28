import {Component, OnInit} from '@angular/core';
import {CourierService} from '../../services/courier.service';
import {ActivatedRoute} from '@angular/router';
import {Department} from '../../model/department';

@Component({
  selector: 'app-view-department',
  templateUrl: './view-department.component.html',
  styleUrls: ['./view-department.component.css']
})
export class ViewDepartmentComponent implements OnInit {

  department: Department;

  constructor(private courierService: CourierService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.courierService.findDepartment(Number(id)).subscribe(department => this.department = department);
  }

}
