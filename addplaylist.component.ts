import { Component, OnInit } from '@angular/core';
import { Playlist } from '../model/artist';
import { PlaylistService } from '../service/playlist.service';

@Component({
  selector: 'app-addplaylist',
  templateUrl: './addplaylist.component.html',
  styleUrls: ['./addplaylist.component.css']
})
export class AddplaylistComponent implements OnInit {
  play: Playlist = new Playlist();
  msg: string;
  errorMsg: string;
  constructor(private pl: PlaylistService) { }

  ngOnInit(): void {
  }
  addPlaylist() {
    console.log("Add new Playlist.");
    console.log(this.play);
    this.pl.addPlaylist(this.play).subscribe(
      (data) => {
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
  }

}
