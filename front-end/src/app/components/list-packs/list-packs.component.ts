import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {CourierService} from '../../services/courier.service';
import {Pack} from '../../model/pack';
import {ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-list-pack',
  templateUrl: './list-packs.component.html',
  styleUrls: ['./list-packs.component.css']
})

export class ListPacksComponent implements OnInit {
  packs: Observable<Pack[]>;

  constructor(private courierService: CourierService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id == null) {
      this.packs = this.courierService.findAllPacks();
    } else {
      this.packs = this.courierService.getPacksOfCourier(Number(id));
    }
  }

  remove(pack: Pack) {
    this.courierService.removePack(pack)
      .subscribe(() => this.ngOnInit());
  }
}
