import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Playlist } from '../model/artist';
import { PlaylistService } from '../service/playlist.service';

@Component({
  selector: 'app-viewplaylist',
  templateUrl: './viewplaylist.component.html',
  styleUrls: ['./viewplaylist.component.css']
})

export class ViewplaylistComponent implements OnInit {
  playlists: Playlist[] = [];
  isUpdate = false;
  updatePlay: Playlist = new Playlist();
  msg: string;
  errorMsg: string;
  ispresent: number;
  constructor(private palylistService: PlaylistService, private router: Router) { }

  ngOnInit(): void {
    console.log("am inside view component");
    this.palylistService.getallPlaylist().subscribe(data => this.playlists = data)
    console.log(this.playlists);
    this.ispresent = localStorage.length
  }

  public viewUpdatePlaylist(pl: Playlist) {  // emp object of row where update button clicked(old data)
    console.log("Emp :" + JSON.stringify(pl));
    this.isUpdate = true;
    this.updatePlay = pl; //older value rep in form due to this line
  }

  public updatePlaylist() {
    console.log("Update Emp :" + JSON.stringify(this.updatePlay));
    this.palylistService.updatePlaylist(this.updatePlay).subscribe((data) => {
      console.log("Data", data);
      this.msg = data;
      this.errorMsg = undefined;
    },

      (error) => {
        this.errorMsg = error.error;
        console.log(this.errorMsg);
        this.msg = undefined;
      }
    );

    // get the latest data after update
    //this.employeeService.getallEmployees().subscribe(data=>this.employees=data);
    //added for delay as when page is change latest didnt come we have to refresh for latest data
    this.router.navigate(['view emp'])
    this.isUpdate = false;
  }

  public deletePlay(id: number) {
    console.log("Delete employee id:" + id);
    this.palylistService.deletePlaylist(id).subscribe((data) => {
      console.log("Data", data);
      this.msg = data;
      this.errorMsg = undefined;
    },
      (error) => {
        this.errorMsg = error.error;
        console.log(this.errorMsg);
        this.msg = undefined;
      }
    );
    //this.employeeService.getallEmployees().subscribe(data=>this.employees=data); it give refresh glitch
    //added for delay as when page is change latest didnt come we have to refresh for latest data
    this.router.navigate(['view emp'])
    this.isUpdate = false;

  }
  confirmdel(id: number) {
    if (confirm("are you sure delete")) {
      this.deletePlay(id);
    }
    else {
      this.palylistService.getallPlaylist().subscribe(data => this.playlists = data);
      this.isUpdate = false;
    }
  }
}

