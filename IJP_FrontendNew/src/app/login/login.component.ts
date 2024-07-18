// login.component.ts
import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-login',
  standalone:true,
  imports:[FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private authService: AuthService) {}

  login() {
    // Simulated login with roles
    const token = 'dummy_access_token'; // Replace with actual token received from OAuth2 provider
    const role = 'EMPLOYEES'; // Replace with role received from OAuth2 provider

    this.authService.login(token, role);
  }
}
