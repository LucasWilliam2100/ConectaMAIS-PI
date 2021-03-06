import { Component, OnInit } from '@angular/core';
import { Router, Scroll } from '@angular/router';

@Component({
  selector: 'app-pag-inicial',
  templateUrl: './pag-inicial.component.html',
  styleUrls: ['./pag-inicial.component.css']
})
export class PagInicialComponent implements OnInit {
 
  constructor(
    private router: Router
  ) { }

  ngOnInit() { 
    window.scroll(0,0)
    
     this.scrollMenu()
  }

  scrollMenu() {
    window.addEventListener('scroll',  (event)=> {
      let nav = <HTMLElement>document.querySelector('#navbar-changing');
      let navScroll = nav.scrollHeight


      if ( navScroll >  window.scrollY) {
        nav.style.backgroundColor = 'transparent';
      } else {
        nav.style.backgroundColor = '#1B3659';
        nav.style.transition = 'background-color 200ms linear'
      }
    });
    
  }

}