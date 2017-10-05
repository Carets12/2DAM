
if (process.argv.length < 3){
	process.exit(1);
}

console.log('Cadena leida: ' + process.argv[2]);
const cadena = process.argv[2];

function procesarCadena(valorCadena){
var _cadena = valorCadena;
	return {
		longitudCadena : function() { return _cadena.length;},
		cadenaEsNumero : function() {return !isNan(_cadena);},
		cadenaEnMayuscula : function() {return _cadena.toUpperCase();},
		cadenaAlreves : function() {return _cadena.split('').reverse().join('');},
		esPalindromo : function() { return _cadena === this.cadenaAlReves();}

	};
}

console.log("Longitud de la cadena: " + cadena + " es: " + procesarCadena.longitudCadena());
console.log("La cadena " + cadena + "¿Es un numero?" + _cadeba,cadenaEsNumero);
consoole.log("");
