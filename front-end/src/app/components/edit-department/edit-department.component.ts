import {Component, OnInit} from '@angular/core';
import {CourierService} from '../../services/courier.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Courier} from '../../model/courier';
import {Department} from '../../model/department';

@Component({
  selector: 'app-edit-department',
  templateUrl: './edit-department.component.html',
  styleUrls: ['./edit-department.component.css']
})
export class EditDepartmentComponent implements OnInit {

  department: Department;
  couriers: Courier[];

  constructor(private booksService: CourierService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');

    if (id == null) {
      this.department = {id: null, numberOfWorkers: 0, address: '', storage: false, couriers: []};
    } else {
      this.booksService.findDepartment(Number(id))
        .subscribe(department => this.department = department);
    }

    this.booksService.findAllCouriers()
      .subscribe(couriers => this.couriers = couriers);
  }

  save() {
    this.booksService.saveDepartment(this.department)
      .subscribe(() => this.router.navigateByUrl('/departments'));
  }

  compareCourier(courier1: Courier, courier2: Courier): boolean {
    return courier1 && courier2 ? courier1.id === courier2.id : courier1 === courier2;
  }
}
