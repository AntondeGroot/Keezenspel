import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})
export class BoardComponent implements OnInit {
  monitorHeight: number = 0;

  @ViewChild("boardCanvas")
  private boardCanvas !: ElementRef;

  private context: any;

  constructor() {
    this.monitorHeight = window.innerHeight
  }

  public ngOnInit(): void {
    // establish socket connection

  }

  public ngAfterViewInit() {
    // execute after the html has rendered
    this.context = this.boardCanvas.nativeElement.getContext("2d");
    this.context.fillRect(20, 20, 20, 20);
  }



}
