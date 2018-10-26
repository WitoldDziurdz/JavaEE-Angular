import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {CourierService} from '../../services/courier.service';
import {Pack} from '../../model/pack';


@Component({
  selector: 'app-list-pack',
  templateUrl: './list-packs.component.html',
  styleUrls: ['./list-packs.component.css']
})

export class ListPacksComponent implements OnInit {
  packs: Observable<Pack[]>;

  constructor(private courierService: CourierService) {
  }

  ngOnInit(): void {
    this.packs = this.courierService.findAllPacks();
  }

  remove(pack: Pack) {
    this.courierService.removePack(pack)
      .subscribe(() => this.ngOnInit());
  }
}
