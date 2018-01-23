import { Component } from "@angular/core";

//Creamos una clase Componente nombre fichero "app.component.ts"
@Component({
selector:'hello',
templateUrl:'./app.component.html'
})

export class AppComponent{
  nombre:string = 'Daniel Sierra';
  contador:number = 0;

  cambiarNombre(nombre:string){
    this.nombre = nombre;
  }

  incrementarContador(contador:number){
    this.contador = contador+1;
  }

};