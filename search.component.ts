import { Component, OnInit } from '@angular/core';
import {SearchServiceService} from '../service/search-service.service'
import {Album, Artist, Data, Image, Playlist, Search, SearchResults, Track,AlbumLinks} from '../model/artist'
import { AbstractJsEmitterVisitor } from '@angular/compiler/src/output/abstract_js_emitter';
import { Favo } from '../model/Favo';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent implements OnInit {
errorMessage:string;
favorite:Favo=new Favo();
 albums : Album[] = [];
 artists : Artist[] = [];
 tracks : Track[] = [];
 playlists :Playlist[] = [];
 searching :Search = new Search();
 datasearch :Data = new Data();
 imageAlbum :Image[] = [];
 searchtext :string="";
 view :boolean=false;
 links :AlbumLinks =new AlbumLinks();
 str:string ="";
 imageurl:string[]=[];
 currentUser:any;
  constructor(private search:SearchServiceService) { this.currentUser=JSON.parse(localStorage.getItem('currentUser')); }

  ngOnInit(): void {
    
   } 

  onSearch(){
    console.log(this.searchtext);
    
    this.search.searchResults(this.searchtext).subscribe(Response => { 
     
      console.log(Response) 

     this.searching=Response.search;
     this.datasearch=this.searching.data;

     this.albums=this.datasearch.albums;
     this.tracks=this.datasearch.tracks;
     this.playlists=this.datasearch.playlists;
     this.artists=this.datasearch.artists;
     console.log(this.artists);
     this.albums.forEach(element => {
       this.str=element.links.images.href;
      this.getimglink();
       console.log(this.str);
     });
    }); 
    this.view=true;
  }
  getimglink(){
    this.search.getimageobj(this.str).subscribe(Response => {
      console.log(Response)
      this.imageurl.push(Response.images[0].url);
      console.log(this.imageurl);
    }
 
    );
  }
  favButton(al:Album){

    console.log(al);
    this.favorite.emailId=this.currentUser.emailId;
    this.favorite.releasedDate=al.released.toString();
    this.favorite.songAlbum=al.href;
    this.favorite.songArtists=al.artistName;
    this.favorite.songId=al.id;
    this.favorite.songImage=al.links.images.href;
    this.favorite.songLabel=al.label;
    this.favorite.songName=al.name;
    this.favorite.songPosts=al.links.posts.href;
    this.favorite.songTracks=al.links.tracks.href;
    this.search.favBut(this.favorite).subscribe(response=>{
    this.favorite.temp=response;
    console.log(this.favorite.temp);
  

    })
  }
  counter:number=0;
  imageelements():string{
    var url:string="";
    if(this.imageurl.length==this.counter){
    url= this.imageurl[this.counter];
    this.counter=0;
    
    }
    else
    {
      url=this.imageurl[this.counter++];
    }
    return url;
  }
   
} 


