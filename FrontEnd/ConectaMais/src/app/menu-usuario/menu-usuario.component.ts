import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-menu-usuario',
  templateUrl: './menu-usuario.component.html',
  styleUrls: ['./menu-usuario.component.css']
})
export class MenuUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario()
  idUser = environment.id
  papelUser = environment.papel
  nomeUser = environment.nome
  imagemUser = environment.imagemPerfilURL


  showFeed: boolean = true
  showMyPost: boolean = false

  showBtn1:boolean = false

  constructor(
    private authService: AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    window.scroll(0,0)
    
    this.findByIdUser()

    this.papelUserIs()
  
  }

    papelUserIs(){
    if (this.papelUser == "usuarioInstituicao") {
      this.showBtn1 = true
    } else {
      this.showBtn1 = false
    }
  }

  expandirMenu(){
    let elemento1 = document.querySelector("#sidebar");
    let elemento2 = document.querySelector("#content");

    elemento1?.classList.toggle("active")
    elemento2?.classList.toggle("active")
    

  }

  findByIdUser(){
    this.authService.getByIdUser(this.idUser).subscribe((resp: Usuario)=>{
      this.usuario = resp
    })
  }

  irMinhasPost() {
    this.showFeed = false
    this.showMyPost = true
  }

  irFeed() {
    this.showFeed = true
    this.showMyPost = false
  }

}

