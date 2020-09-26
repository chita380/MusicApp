import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Favo } from '../model/Favo';

@Injectable({
  providedIn: 'root'
})
export class SearchServiceService {
  constructor(private http:HttpClient) { }
  public searchResults(query:String):Observable<any>{
    console.log("Inside all Artists");
    return this.http.get("http://api.napster.com/v2.2/search?apikey=OTE4ZGU3ZDktY2VhYi00MmQxLTk1MTgtZWJjNGI0OWIyODFj&per_type_limit=5&query="+query+"&format=json");
  }
  public getimageobj(link:string):Observable<any>{
    return this.http.get(link+"?apikey=OTE4ZGU3ZDktY2VhYi00MmQxLTk1MTgtZWJjNGI0OWIyODFj");
  }
  favBut(fav:Favo){
    return this.http.post<any>("http://localhost:8086/fav/addmusic",fav);
  }
}
