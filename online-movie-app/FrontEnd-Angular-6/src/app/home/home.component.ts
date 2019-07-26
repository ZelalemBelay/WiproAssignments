import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { Movie } from '../Movie';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../User';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  addMoveForm: FormGroup;
  movieToUpdate: Movie = new Movie();
  isAdmin: boolean = false;

  constructor(private movieService: MovieService, private router: Router, private route: ActivatedRoute) {
    this.addMoveForm = new FormGroup({
      title: new FormControl(),
      description: new FormControl()
    });
  }

  movieList: Movie[] = [];
  users: User[] = [];

  ngOnInit() {
    this.movieService.getAllMovies().subscribe(movies => {
      this.movieList = movies;
    });

    this.movieService.getAllUsers().subscribe(usr => {
      this.users = usr;
    });

    if (this.route.snapshot.paramMap.get('sessionToken') == "admin-session-token-12345-7746-55") {
      this.isAdmin = true;
    }
  }

  movieClick(id: string) {
    this.router.navigate(['/movie/' + id]);
  }

  submitMovie() {
    this.movieService.addMovie(this.addMoveForm.value).subscribe(movies => {
      this.movieList = movies;
    });
  }

  edit(id: string) {
    this.movieService.updateMovie(id, this.addMoveForm.value).subscribe(movies => {
      this.movieList = movies;
    });
  }

  delete(id: string) {
    this.movieService.removeMovie(id).subscribe(movies => {
      this.movieList = movies;
    });
  }

  updating(mov: Movie) {
    this.movieToUpdate = mov;
  }

}
