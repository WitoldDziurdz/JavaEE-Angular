import {Component, OnInit} from '@angular/core';
import {CourierService} from '../../services/courier.service';
import {ActivatedRoute} from '@angular/router';
import {Pack} from '../../model/pack';

@Component({
  selector: 'app-view-pack',
  templateUrl: './view-pack.component.html',
  styleUrls: ['./view-pack.component.css']
})
export class ViewPackComponent implements OnInit {

  pack: Pack;

  constructor(private courierService: CourierService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.courierService.findPack(Number(id)).subscribe(pack => this.pack = pack);
  }

}
