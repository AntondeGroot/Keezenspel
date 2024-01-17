import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})
export class BoardComponent implements OnInit {

  constructor() {
  }

  public ngOnInit(): void {
    // establish socket connection

  }

  public ngAfterViewInit() {
    // execute after the html has rendered
  }



}
