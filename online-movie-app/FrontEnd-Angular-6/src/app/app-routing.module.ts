import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';

const routes: Routes = [
 { path: 'home/:sessionToken', component: HomeComponent },
 { path: 'login', component: LoginComponent },
 { path: 'movie/:id', component: MovieDetailComponent },
 { path: '**', component: LoginComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
