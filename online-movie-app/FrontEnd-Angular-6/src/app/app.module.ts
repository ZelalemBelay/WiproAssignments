import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MovieService } from './movie.service';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';

@NgModule({
  imports:      [ BrowserModule, RouterModule, FormsModule, ReactiveFormsModule, HttpClientModule, AppRoutingModule ],
  declarations: [ AppComponent, LoginComponent, HomeComponent, MovieDetailComponent ],
  bootstrap:    [ AppComponent ],
  providers: [MovieService]
})
export class AppModule { }
