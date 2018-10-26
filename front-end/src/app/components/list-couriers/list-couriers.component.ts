import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {CourierService} from '../../services/courier.service';
import {Courier} from '../../model/courier';


@Component({
  selector: 'app-list-courier',
  templateUrl: './list-couriers.component.html',
  styleUrls: ['./list-couriers.component.css']
})

export class ListCouriersComponent implements OnInit {
  couriers: Observable<Courier[]>;

  constructor(private courierService: CourierService) {
  }

  ngOnInit(): void {
    this.couriers = this.courierService.findAllCouriers();
  }

  remove(courier: Courier) {
    this.courierService.removeCourier(courier)
      .subscribe(() => this.ngOnInit());
  }
}
