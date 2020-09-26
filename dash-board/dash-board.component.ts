import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {
  title: 'Welcome to login view of music app,user login sucess';
  constructor() { }
  ngOnInit(): void { }
}