import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './components/app/app.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {CourierService} from './services/courier.service';
import {FormsModule} from '@angular/forms';
import {ListPacksComponent} from './components/list-packs/list-packs.component';
import {ListCouriersComponent} from './components/list-couriers/list-couriers.component';
import {EditCourierComponent} from './components/edit-courier/edit-courier.component';
import {ViewCourierComponent} from './components/view-courier/view-courier.component';
import {ViewPackComponent} from './components/view-pack/view-pack.component';
import {EditPackComponent} from './components/edit-pack/edit-pack.component';
import {ListDepartmentsComponent} from './components/list-departments/list-departments.component';
import {ViewDepartmentComponent} from './components/view-department/view-department.component';
import {EditDepartmentComponent} from './components/edit-department/edit-department.component';


@NgModule({
  declarations: [
    AppComponent,
    ViewPackComponent,
    ViewCourierComponent,
    ViewDepartmentComponent,
    EditCourierComponent,
    EditPackComponent,
    EditDepartmentComponent,
    ListPacksComponent,
    ListCouriersComponent,
    ListDepartmentsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,

    AppRoutingModule
  ],
  providers: [CourierService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
