import {Component, OnInit} from '@angular/core';
import {CourierService} from '../../services/courier.service';
import {ActivatedRoute} from '@angular/router';
import {Courier} from '../../model/courier';

@Component({
  selector: 'app-view-courier',
  templateUrl: './view-courier.component.html',
  styleUrls: ['./view-courier.component.css']
})
export class ViewCourierComponent implements OnInit {

  courier: Courier;

  constructor(private courierService: CourierService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.courierService.findCourier(Number(id)).subscribe(courier => this.courier = courier);
  }

}
