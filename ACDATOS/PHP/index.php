<!DOCTYPE html>
<html>
  <head>
      <meta charset="utf-8"/>
      <title>Hola Mundo </title>
      <meta name = "generator" content="Geany 1.27"/>
  </head>
  <body>
    Test Hola mundo. <br>
  <?php
   require('Cliente.php');

   $mi_Cliente = new Cliente("Juan","Garcia Martinez", 12345678, "juan@sincorreo.com");
   echo $mi_Cliente->setId(1234);
   //echo $mi_Cliente->getNombre();
   echo " El cliente con nombre ". $mi_Cliente->getNombre()." tiene el ID=". $mi_Cliente->getId();
   ?>
   </body>
</html>
