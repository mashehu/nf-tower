import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {AuthService} from "../service/auth.service";
import {User} from "../entity/user/user";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let url: string = state.url;

    return this.checkLogin();
  }

  checkLogin(): boolean {
    let user: User = this.authService.currentUser;
    if (user) {
      return true;
    }

    console.log('User not authenticated');
    this.router.navigate(['/register']);
    return false;
  }
  
}
