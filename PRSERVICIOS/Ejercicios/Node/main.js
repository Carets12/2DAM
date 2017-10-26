var circunferencia  = require ('./circuferencia');
var objeto1         = circunferencia(12);

var estadistica     = require ('./estadistica');

console.log("Area " + objeto1.area());
console.log("Perimetro " + objeto1.perimetro());
console.log("--------------------------------");
var coleccion = [1,2,3,4,5,6,7,7,8];
var objeto = estadistica(coleccion);
var objeto2         = estadistica(coleccion);
console.log('Nº de elementos ' + objeto2.numeroElementos());
console.log('Nº más alto es: ' + objeto2.numeroMasAlto());
