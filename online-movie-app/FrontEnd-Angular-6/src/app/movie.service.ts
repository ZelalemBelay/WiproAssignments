import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { User } from './User';
import { Review } from './Review';
import { Movie } from './Movie';

@Injectable()
export class MovieService {
  
  constructor(private httpClient: HttpClient) {
   }

register(user: User){
      const headerDict = {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'Access-Control-Allow-Headers': '*',
          }
          
          const requestOptions = {                                                                                                                                                                                 
            headers: new HttpHeaders(headerDict), 
          };
          
      console.log("Registering: ", user);
      return this.httpClient.post<User>("http://localhost:8082/signUp", user, requestOptions);
}

login(user: User){
      console.log('logging in: ', user);
      return this.httpClient.post<User>("http://localhost:8082/login", user);
}

getAllMovies(){
      return this.httpClient.get<Movie[]>("http://localhost:8080/getAllMovies");
}

getAllUsers(){
      return this.httpClient.get<User[]>("http://localhost:8082/getAllUsers");
}

addMovie(movie: Movie){
      return this.httpClient.post<Movie[]>("http://localhost:8082/movie/add", movie);
}

removeMovie(id: string){
      return this.httpClient.delete<Movie[]>("http://localhost:8080/movie/delete/" + id);
}

updateMovie(id: string, movie: Movie){
      return this.httpClient.put<Movie[]>("http://localhost:8080/movie/update/" + id, movie);
}

getMovie(id : string){
      return this.httpClient.get<Movie>("http://localhost:8080/movie/"+id);
}

submitReview(id: string, review: Review) {
      console.log('Adding Review for : '+ id, review);
      return this.httpClient.post("http://localhost:8080/movie/"+id+"/submitReview", review);
    }
  
}