import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListPacksComponent} from './components/list-packs/list-packs.component';
import {ListCouriersComponent} from './components/list-couriers/list-couriers.component';
import {EditCourierComponent} from './components/edit-courier/edit-courier.component';
import {ViewCourierComponent} from './components/view-courier/view-courier.component';
import {ViewPackComponent} from './components/view-pack/view-pack.component';
import {EditPackComponent} from './components/edit-pack/edit-pack.component';

const routes: Routes = [
  {path: 'packs', component: ListPacksComponent},
  {path: 'packs/:id', component: ViewPackComponent},
  {path: 'packs/:id/edit', component: EditPackComponent},
  {path: 'couriers', component: ListCouriersComponent},
  {path: 'couriers/:id/edit', component: EditCourierComponent},
  {path: 'couriers/:id', component: ViewCourierComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
