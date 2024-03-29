import { Routes } from '@angular/router';
import { LobbyComponent } from './lobby/lobby.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { LoginComponent } from './login/login.component';
import { BoardComponent } from './board/board.component';

export const routes: Routes = [
    {path: '', component: MainMenuComponent},
    {path: 'login', component: LoginComponent},
    {path: 'lobby', component: LobbyComponent},
    {path: 'board', component: BoardComponent},
    {path: '**', component: MainMenuComponent}];
