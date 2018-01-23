import { Component } from "@angular/core";
import { Persona } from "app/persona";

@Component({
selector: 'personas',
templateUrl: './app.component.html',
styleUrls: ['./app.component.css']
})

export class AppComponent{
  personas = [
    {nombre:'Daniel', apellidos:'Sierra', activo:true},
    {nombre:'Jesús', apellidos:'Rodrigez', activo:true},
    {nombre:'Pablo', apellidos:'Jurado', activo:true},
    {nombre:'Miguel', apellidos:'Jurado', activo:true},
    {nombre:'Alba', apellidos:'Román', activo:true},
    {nombre:'Juan', apellidos:'Gellego', activo:true},
    {nombre:'Luisa', apellidos:'Ferrer', activo:false},
    {nombre:'Miguelin', apellidos:'Lopez', activo:false},
    {nombre:'Jesús', apellidos:'Rodrigez', activo:true},
    {nombre:'Juan Isaac', apellidos:'Huertas', activo:true}
    
  ]

  personasDinamico:Array<Persona> = new Array();
  
  nombre;
  apellidos;
  edad;
  activo;
  sexo:string;

  constructor(){
    let p:Persona =new Persona("Daniel","Sierra",18,true,"masculino");
    this.personasDinamico.push(p);
    let p1:Persona =new Persona("Maria","Sierra",18,true,"femenino");
    this.personasDinamico.push(p1);
    let p2:Persona =new Persona("Luisa","Sierra",18,false,"femenino");
    this.personasDinamico.push(p2);
  }

  addPersona(){
    let sexos:string;
  if(this.sexo == "true"){
    sexos = "Masculino"
  }else if (this.sexo == "false"){
    sexos = "Femenino"
  }
    let p:Persona = new Persona(this.nombre, this.apellidos, this.edad, this.activo, sexos);
    this.personasDinamico.push(p);
  }

};

