import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from  '@angular/forms';
import { MovieService } from '../movie.service'
import { Router } from '@angular/router';
import { User } from '../User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  submitText = "Login";
  heads = "Login";
  registering=false;

  loginForm: FormGroup;
  user: User = new User();

 constructor(private formBuilder: FormBuilder, private movieService: MovieService, private router: Router){
   this.loginForm = new FormGroup({
     name: new FormControl() ,
     age: new FormControl() ,
     username: new FormControl(),
     password: new FormControl()
   });
 }
  submit() {
    if(this.registering)
      this.movieService.register(this.loginForm.value).subscribe(usr => {
        console.log(usr)
      })
    else{
      this.movieService.login(this.loginForm.value).subscribe(user => {
        console.log('Logged in: ', user);
          this.user = user;
          this.router.navigate(['/home/'+ this.user.sessionToken]);
      });
    }
  }

  register(){
    this.heads = "Register";
    this.submitText="Register";
    this.registering = true;
  }
}
