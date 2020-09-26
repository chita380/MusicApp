import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  currentUser: any;
  currentUserSubject: any;
  public userobj = new User();
  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }
  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }
  loginUser(user: User): Observable<any> {
    console.log("am inside loginUser");
    //console.log(user.userName);
    return this.http.post("http://localhost:8086/login", user, { responseType: 'text' })


  }
  regUser(user: User): Observable<any> {
    console.log("am inside regUser");
    return this.http.post("http://localhost:8086/registeruser", user, { responseType: 'text' });
  }
  public updateUser(updateUser: User): Observable<any> {
    return this.http.put("http://localhost:8086/update/" + updateUser.emailId, updateUser, { responseType: 'text' });
  }
  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }



}
