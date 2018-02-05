export class Articulo {
    private nombre:string;
    private id:number
    private estado:string;

    constructor(id:number, nombre:string) {
        this.nombre = nombre;
        this.id = id;
        this.estado = "Todo";
    }

    getNombre(){
        return this.nombre;
    }

    set miNombre (nombre:string) {
        this.nombre = nombre;
    }

    getId(){
        return this.id;
    }

    set miId (id:number) {
        this.id = id;
    }

    getEstado(){
        return this.estado;
    }

    setEstado(estado:string) {
        this.estado = estado;
    }

    toString() {
        return "Nombre: " + this.nombre + " ID: " + this.id + " Estado:" + this.estado;
    }
}

