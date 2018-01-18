"use strict";
exports.__esModule = true;
var Persona = /** @class */ (function () {
    function Persona(nombre, apellidos, salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
    }
    Persona.prototype.setNombre = function (nombre) {
        this.nombre = nombre;
    };
    Persona.prototype.getNombre = function () {
        return this.nombre;
    };
    Persona.prototype.setApellidos = function (apellidos) {
        this.apellidos = apellidos;
    };
    Persona.prototype.getApellidos = function () {
        return this.apellidos;
    };
    Persona.prototype.setSalario = function (salario) {
        this.salario = salario;
    };
    Persona.prototype.getSalario = function () {
        return this.salario;
    };
    Persona.prototype.toString = function () {
        return "Nombre: " + this.nombre + "Apellidos " + this.apellidos
            + "Salario " + this.salario;
    };
    ;
    return Persona;
}());
exports.Persona = Persona;
