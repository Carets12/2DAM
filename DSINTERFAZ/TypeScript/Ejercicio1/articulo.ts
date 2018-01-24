export class articulo{

    private nombre;

    constructor(nombre){
        this.nombre = nombre;
    }

    setNombre(nombre){
        this.nombre = nombre;
    }
    getNombre(nombre){
        return this.nombre;
    }

    toString(){
        "Nombre " + this.nombre;
    }

}