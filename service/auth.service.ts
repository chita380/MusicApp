import { isPromise } from '@angular/compiler/src/util';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { isEmpty } from 'rxjs/operators';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate {
user = new User();
  constructor(public router:Router) { }
  canActivate(): boolean {
    
   
if(1)//if login successlocalStorage.getItem.length!=null
{
  return true;
}
else{
this.router.navigate(['error']);
return false;
}
  }
}
