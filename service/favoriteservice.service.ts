import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Favo } from '../model/Favo';

@Injectable({
  providedIn: 'root'
})
export class FavoriteserviceService {

  
  constructor(private http:HttpClient) { }

  getFav(emailId:string):Observable<Favo[]>{
    return this.http.get<Favo[]>("http://localhost:8086/fav/"+emailId);
  }

  delfav(fav:Favo){
    return this.http.put<any>("http://localhost:8086/fav/delfav",fav);
  }
  updfav(fav:Favo){
    return this.http.put<any>("http://localhost:8086/fav/updfav",fav);
  }
}