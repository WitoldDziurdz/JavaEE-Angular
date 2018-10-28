import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListPacksComponent} from './components/list-packs/list-packs.component';
import {ListCouriersComponent} from './components/list-couriers/list-couriers.component';
import {EditCourierComponent} from './components/edit-courier/edit-courier.component';
import {ViewCourierComponent} from './components/view-courier/view-courier.component';
import {ViewPackComponent} from './components/view-pack/view-pack.component';
import {EditPackComponent} from './components/edit-pack/edit-pack.component';
import {ListDepartmentsComponent} from './components/list-departments/list-departments.component';
import {ViewDepartmentComponent} from './components/view-department/view-department.component';
import {EditDepartmentComponent} from './components/edit-department/edit-department.component';

const routes: Routes = [
  {path: 'packs', component: ListPacksComponent},
  {path: 'packs/new', component: EditPackComponent},
  {path: 'packs/:id', component: ViewPackComponent},
  {path: 'packs/:id/edit', component: EditPackComponent},
  {path: 'couriers', component: ListCouriersComponent},
  {path: 'couriers/new', component: EditCourierComponent},
  {path: 'couriers/:id/edit', component: EditCourierComponent},
  {path: 'couriers/:id', component: ViewCourierComponent},
  {path: 'couriers/:id/packs', component: ListPacksComponent},
  {path: 'departments', component: ListDepartmentsComponent},
  {path: 'departments/:id', component: ViewDepartmentComponent},
  {path: 'departments/:id/edit', component: EditDepartmentComponent},
  {path: 'departments/:id/couriers', component: ListCouriersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
