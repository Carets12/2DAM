var name = 'daniel'; 
   function clousure(){
    var name = 'pepe';
     	function funcion(){
	return name;
	};
    return funcion();
   };
clousure();
console.log(name);
