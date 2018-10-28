import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Pack} from '../model/pack';
import {Courier} from '../model/courier';
import {Department} from '../model/department';

@Injectable()
export class CourierService {

  constructor(private http: HttpClient) {
  }

  findAllPacks(): Observable<Pack[]> {
    return this.http.get<Pack[]>('api/packs');
  }

  findPack(id: number): Observable<Pack> {
    return this.http.get<Pack>(`api/packs/${id}`);
  }

  getPacksOfCourier(id: number): Observable<Pack[]> {
    return this.http.get<Pack[]>(`api/couriers/${id}/packs`);
  }

  removePack(pack: Pack): Observable<any> {
    return this.http.delete<Pack>(`api/packs/${pack.id}`);
  }

  savePack(pack: Pack): Observable<any> {
    if (pack.id) {
      return this.http.put(`api/packs/${pack.id}`, pack);
    } else {
      return this.http.post('api/packs/', pack);
    }
  }

  findAllCouriers(): Observable<Courier[]> {
    return this.http.get<Courier[]>('api/couriers');
  }

  findCourier(id: number): Observable<Courier> {
    return this.http.get<Courier>(`api/couriers/${id}`);
  }

  removeCourier(courier: Courier): Observable<any> {
    return this.http.delete<Courier>(`api/couriers/${courier.id}`);
  }

  saveCourier(courier: Courier): Observable<any> {
    if (courier.id) {
      return this.http.put(`api/couriers/${courier.id}`, courier);
    } else {
      return this.http.post('api/couriers/', courier);
    }
  }

  findAllDepartments(): Observable<Department[]> {
    return this.http.get<Department[]>('api/departments');
  }

  getCouriersOfDepartment(id: number): Observable<Courier[]> {
    return this.http.get<Courier[]>(`api/departments/${id}/couriers`);
  }

  findDepartment(id: number): Observable<Department> {
    return this.http.get<Department>(`api/departments/${id}`);
  }

  removeDepartment(department: Department) {
    return this.http.delete<Department>(`api/departments/${department.id}`);
  }

  saveDepartment(department: Department) {
    if (department.id) {
      return this.http.put(`api/departments/${department.id}`, department);
    } else {
      return this.http.post('api/departments/', department);
    }
  }
}
