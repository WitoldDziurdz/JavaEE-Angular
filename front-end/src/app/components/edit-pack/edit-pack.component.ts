import {Component, OnInit} from '@angular/core';
import {CourierService} from '../../services/courier.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Pack} from '../../model/pack';
import {TypeSize} from '../../model/typeSize';

@Component({
  selector: 'app-edit-pack',
  templateUrl: './edit-pack.component.html',
  styleUrls: ['./edit-pack.component.css']
})
export class EditPackComponent implements OnInit {

  pack: Pack;
  typeSizes: TypeSize[];

  constructor(private booksService: CourierService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.typeSizes = Object.values(TypeSize).filter(value => typeof value === 'string');

    if (id == null) {
      this.pack = {id: null, address: '', typeSize: null, price: null, express: null};
    } else {
      this.booksService.findPack(Number(id))
        .subscribe(pack => this.pack = pack);
    }

  }

  save() {
    this.booksService.savePack(this.pack)
      .subscribe(() => this.router.navigateByUrl('packs'));
  }
}
