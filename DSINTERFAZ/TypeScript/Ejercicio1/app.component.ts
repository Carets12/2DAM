import { Component } from "@angular/core";
import {articulo} from "./articulo"

@Component({
selector:'articulo',
templateUrl: './app.component.html'
})

export class AppComponent {

 articulos:Array<articulo> = new Array();
 nombre;
 
  addArticulo(){
    let a:articulo = new articulo(this.nombre);
    this.articulos.push(a);
  }

};