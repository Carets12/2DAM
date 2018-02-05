import { Component } from '@angular/core';
import { Articulo} from 'app/modelos/articulo';

@Component({
  selector: 'articulo',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  nombre:string;
  contador:number = 1;
  articulo2: string;
  
  listaDinamica: Array<Articulo> = new Array();

  constructor() {
    let p:Articulo = new Articulo(1,"Peras");
    this.listaDinamica.push(p);
  }

  addProducto () {
    if (this.listaDinamica.length === 0) {
      this.contador = 0;
    }
    this.contador++;
    let p:Articulo = new Articulo(this.contador,this.nombre);
    this.listaDinamica.push(p);
  }

  arrayVacio() {
    if (this.listaDinamica.length === 0) return true; 
  }

  removeProducto(id:number) {
    this.listaDinamica.forEach((articulo2, index) => {
      if (articulo2.getId() === id) this.listaDinamica.splice(index,1);
    });
    this.contador--;
  }
}
