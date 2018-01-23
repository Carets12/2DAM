import { Persona } from "./persona";

var suma = 0;

let per = new Array<Persona>();

per.push(new Persona('Daniel', 'Sierra Ráez', 5000));
per.push(new Persona('Ramón', 'Gomez Lopez', 2000));
per.push(new Persona('Juan', 'Sanchez Jerez', 1000));
let p2 = new Persona("Pepe", "Jamora Mora" , 900);

p2.setSalario(2500);
per.push(p2);

for(let pe of per){
    console.log(pe);
    suma = suma + pe.getSalario();
}



//Sumatoria de salarios
console.log("La suma salarial de las personas es de: " + suma);

console.log("La suma salarial de las personas con un metodo: " + Persona.getSalarioTotal(per));
