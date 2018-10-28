import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {CourierService} from '../../services/courier.service';
import {Courier} from '../../model/courier';
import {ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-list-courier',
  templateUrl: './list-couriers.component.html',
  styleUrls: ['./list-couriers.component.css']
})

export class ListCouriersComponent implements OnInit {
  couriers: Observable<Courier[]>;

  constructor(private courierService: CourierService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id == null) {
      this.couriers = this.courierService.findAllCouriers();
    } else {
      this.couriers = this.courierService.getCouriersOfDepartment(Number(id));
    }
  }

  remove(courier: Courier) {
    this.courierService.removeCourier(courier)
      .subscribe(() => this.ngOnInit());
  }
}
