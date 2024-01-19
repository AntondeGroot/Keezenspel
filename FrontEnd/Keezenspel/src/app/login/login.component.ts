import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  @Input()
  userName : string = '';
  userId : number = 0;
  invalidUsername: boolean = false;

  constructor(private router: Router){}

  loginUser(){
    this.userId = Math.floor(Math.random() * 10**10);

    sessionStorage.setItem('userName', this.userName);
    sessionStorage.setItem('userId',this.userId.toString());

    if(this.userName){
      this.invalidUsername = false;
      this.router.navigate(['lobby'])
    }else{
      this.invalidUsername = true;
    }
  }

  
}
