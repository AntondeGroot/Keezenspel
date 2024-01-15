import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-lobby',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './lobby.component.html',
  styleUrl: './lobby.component.css'
})
export class LobbyComponent {
  public users = ['anton', 'edwin', 'ward', 'johan', '', '', '', '']
  public colors = ['rgb(165, 42, 42)', 'rgb(0, 0, 165)', 'rgb(0, 128, 0)', 'rgb(165, 165, 0)', 'rgb(106, 90, 205)', 'rgb(255, 140, 0)', 'rgb(0, 139, 139)', 'rgb(139, 0, 139)']



  public getUserColor(i: number): string {
    if (this.users[i] != '') {
      return this.colors[i];
    }
    return this.colors[i];

  }
  constructor() {

  }
}
