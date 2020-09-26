import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Playlist } from '../model/artist';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  constructor(private http: HttpClient) { }

  addPlaylist(pl: Playlist): Observable<any> {
    console.log("am inside add PlayList");
    return this.http.post("http://localhost:8086/add", pl, { responseType: 'text' });
  }

  public getallPlaylist(): Observable<any> {
    console.log("am inside get all Playlist");
    return this.http.get("http://localhost:8086/getall");
  }

  public updatePlaylist(updatepl: Playlist): Observable<any> {
    return this.http.put("http://localhost:8086/update/" + updatepl.id, updatepl, { responseType: 'text' });
  }
  public deletePlaylist(id: number): Observable<any> {
    return this.http.delete("http://localhost:8086/delete/" + id, { responseType: 'text' });//restype is written for controller return messege
  }
}
