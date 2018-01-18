"use strict";
exports.__esModule = true;
var persona_1 = require("./persona");
var per = new Array();
per.push(new persona_1.Persona('Daniel', 'Sierra Ráez', 5000));
per.push(new persona_1.Persona('Ramón', 'Gomez Lopez', 2000));
per.push(new persona_1.Persona('Juan', 'Sanchez Jerez', 1000));
var p2 = new persona_1.Persona("Pepe", "Jamora Mora", 900);
p2.setSalario(2500);
per.push(p2);
for (var _i = 0, per_1 = per; _i < per_1.length; _i++) {
    var pe = per_1[_i];
    console.log(pe);
}
