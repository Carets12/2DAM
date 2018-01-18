import { Persona } from "./persona";

let per = new Array<Persona>();

per.push(new Persona('Daniel', 'Sierra Ráez', 5000));
per.push(new Persona('Ramón', 'Gomez Lopez', 2000));
per.push(new Persona('Juan', 'Sanchez Jerez', 1000));

for(let pe of per){
    console.log(pe);
}