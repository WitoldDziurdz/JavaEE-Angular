import {Component, OnInit} from '@angular/core';
import {CourierService} from '../../services/courier.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Courier} from '../../model/courier';
import {Pack} from '../../model/pack';

@Component({
  selector: 'app-edit-courier',
  templateUrl: './edit-courier.component.html',
  styleUrls: ['./edit-courier.component.css']
})
export class EditCourierComponent implements OnInit {

  courier: Courier;
  packs: Pack[];

  constructor(private booksService: CourierService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');

    if (id == null) {
      this.courier = {id: null, name: '', surname: '', phone: '', age: null, packs: []};
    } else {
      this.booksService.findCourier(Number(id))
        .subscribe(courier => this.courier = courier);
    }

    this.booksService.findAllPacks()
      .subscribe(packs => this.packs = packs);
  }

  save() {
    this.booksService.saveCourier(this.courier)
      .subscribe(() => this.router.navigateByUrl('couriers'));
  }

  comparePacks(pack1: Pack, pack2: Pack): boolean {
    return pack1 && pack2 ? pack1.id === pack2.id : pack1 === pack2;
  }
}
