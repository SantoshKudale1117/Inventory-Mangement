import {  Component, OnInit, Output, EventEmitter,HostListener, ElementRef} from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],
})
export class NavigationComponent implements OnInit {
  public user: User = null;
  paths = [
    {
      route: '/dashboard/viewprofile',
      class: 'fas fa-user',
      label: 'Profile',
      role: 'User',
    },
    {
      route: '/dashboard/productorders',
      class: 'fas fa-truck-moving',
      label: 'Products Orders',
      role: 'User',
    },
    {
      route: '/dashboard/products',
      class: 'fas fa-boxes',
      label: 'Products',
      role: 'User',
    },
    {
      route: '/dashboard/rawmaterialorders',
      class: 'fas fa-truck-moving',
      label: 'RM Orders',
      role: 'User',
    },
    {
      route: '/dashboard/rawmaterials',
      class: 'fas fa-boxes',
      label: 'Raw Materials',
      role: 'User',
    },
    {
      route: '/dashboard/suppliers',
      class: 'fas fa-people-carry',
      label: 'Suppliers',
      role: 'User',
    },
    {
      route: '/dashboard/distributors',
      class: 'fas fa-people-carry',
      label: 'Distributors',
      role: 'User',
    },
    {
      route: '/dashboard/users',
      class: 'fas fa-users',
      label: 'Manage Users',
      role: 'Admin',
    },
  ];


  constructor(private authService: AuthService, private router: Router) {}
  @Output() toggleSideBarForMe: EventEmitter<any> = new EventEmitter();
 public el:ElementRef= null;
  ngOnInit(): void {
    if (this.authService.fetchFromSessionStorage() !== null)
      this.user = this.authService.fetchFromSessionStorage();
    else this.router.navigateByUrl('/login');
    if (this.user.role === 'User')
      this.paths = this.paths.filter((path) => path.role === this.user.role);
  }

  signOut() {
    this.authService.logout();
  }


  isMenuSmall:boolean = true;
  sideBarOpen: boolean = false;
 

 // Your initial click listener on the host element
 @HostListener('click', ['$event'])onClick(event) {
      event.stopPropagation();
   if (event.target.id == "collapseBtn") {
      document.getElementsByClassName('sidebar')[0].classList.add('showsidebar');
      document.body.classList.add('push');
      this.sideBarOpen = true;
   } else {
    if (this.sideBarOpen) {
       document.getElementsByClassName('sidebar')[0].classList.remove('showsidebar');
       document.body.classList.remove('push');
       this.sideBarOpen = false;
    }
   }
 }

  // Click listener on the window object to handle clicks anywhere on 
  // the screen.
  @HostListener('window:click', ['$event']) onOutsideClick(event){
    if(this.sideBarOpen && !this.el.nativeElement.contains(event.target)){
      this.sideBarOpen=false;
      document.getElementsByClassName('sidebar')[0].classList.remove('showsidebar');
      document.body.classList.remove('push');
    }
  }
  toggleSideBar() {
   
 }
  
}
