import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Pack} from '../model/pack';
import {Author} from '../model/author';
import {Book} from '../model/book';
import {Courier} from '../model/courier';

@Injectable()
export class CourierService {

  constructor(private http: HttpClient) {
  }


  findAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>('api/books');
  }

  findBook(id: number): Observable<Book> {
    return this.http.get<Book>(`api/books/${id}`);
  }

  removeBook(book: Book): Observable<any> {
    return this.http.delete(`api/books/${book.id}`);
  }

  saveBook(book: Book): Observable<any> {
    if (book.id) {
      return this.http.put(`api/books/${book.id}`, book);
    } else {
      return this.http.post('api/books/', book);
    }
  }

  findAllAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>('api/authors');
  }

  findAuthor(id: number): Observable<Author> {
    return this.http.get<Author>(`api/authors/${id}`);
  }


  findAllPacks(): Observable<Pack[]> {
    return this.http.get<Pack[]>('api/packs');
  }

  findPack(id: number): Observable<Pack> {
    return this.http.get<Pack>(`api/packs/${id}`);
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
      return this.http.post(`api/couriers/${courier.id}`, courier);
    }
  }

}
