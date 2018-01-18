export class Persona {

private nombre;
private apellidos;
private salario;

constructor (nombre:string, apellidos:string, salario:number){
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.salario = salario;
}

    setNombre(nombre){
         this.nombre = nombre;

    }

    getNombre(){
        return this.nombre;
    }

    setApellidos(apellidos){
        this.apellidos = apellidos;

    }

    getApellidos(){
        return this.apellidos;
    }

    setSalario(salario){
        this.salario = salario;

    }

    getSalario(){
        return this.salario;
    }

   toString(){
        return "Nombre: " + this.nombre + "Apellidos " + this.apellidos 
        + "Salario " + this.salario;        
    };

}
