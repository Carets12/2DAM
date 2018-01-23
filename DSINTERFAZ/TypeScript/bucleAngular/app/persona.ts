export class Persona {

    private nombre;
    private apellidos;
    private edad;
    private activo;
    private sexo;

    constructor(nombre, apellidos, edad, activo, sexo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.activo = activo;
        this.sexo = sexo;

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
    setEdad(edad){
        this.edad = edad;

    }
    getEdad(){
        return this.edad;
    }

    setActivo(activo){
        this.activo = activo;

    }
    getActivo(){
        return this.activo;
    }

    setSexo(sexo){
        this.sexo = sexo;

    }
    getSexo(){
        return this.sexo;
    }

    toString(){
        return " / Nombre " + this.nombre +
         " / Apellidos " + this.apellidos +
         " / Edad " + this.edad + " / Activo " + this.activo + " sexo " + this.sexo + " / "
    
    }
}