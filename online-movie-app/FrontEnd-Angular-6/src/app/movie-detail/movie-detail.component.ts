import { Component, OnInit } from '@angular/core';
import { Movie } from '../Movie';
import { MovieService } from '../movie.service';
import { Review } from '../Review';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent implements OnInit {

  movie: Movie = new Movie(); 
  reviewToSubmit: Review;
  reviewForm: FormGroup;

  constructor(private movieService: MovieService, private route: ActivatedRoute) {
    this.reviewForm = new FormGroup({
      review: new FormControl()
    });
   }

  ngOnInit() {
    this.movieService.getMovie(this.route.snapshot.paramMap.get('id')).subscribe(mov => {
      this.movie = mov;
      console.log(this.movie);
    });
  }

  submit(){
    this.movieService.submitReview(this.movie.id, this.reviewForm.value)
  }

}
