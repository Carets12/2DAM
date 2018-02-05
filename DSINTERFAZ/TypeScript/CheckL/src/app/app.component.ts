import { Component } from '@angular/core';
import { Tarea } from './tarea';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'app';
  listaDeTareas = new Array<Tarea>();
  nombreTarea:string;

  arrayVacio(){
    let estado = false;
    if(this.listaDeTareas.length == 0){
      estado = true;
    }
    return estado;
  }

  eliminarTarea(tarea:Tarea){
    let index:number = this.listaDeTareas.indexOf(tarea);
    this.listaDeTareas.splice(index, 1);
  }

  addTarea(){
    let tarea:Tarea = new Tarea(this.nombreTarea);
    this.listaDeTareas.push(tarea);
  }

  cambiarClase(tarea:Tarea){
    /*Si hay nombres de tarea repetidos se cambia el estilo al primero
    Habría que usar un id para solucionarlo.*/
    if(document.getElementById(tarea.getNombre).classList.contains('textoNormal')){
      document.getElementById(tarea.getNombre).classList.remove('textoNormal');
      document.getElementById(tarea.getNombre).classList.add('textoTachado');      
    }else{
      document.getElementById(tarea.getNombre).classList.remove('textoTachado');
      document.getElementById(tarea.getNombre).classList.add('textoNormal');      
    }
  }

}
