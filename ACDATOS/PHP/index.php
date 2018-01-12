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

   $mi_Cliente = new Cliente();
   $mi_Cliente->setNombre("Pepe");
   echo $mi_Cliente->getNombre();
   ?>
   </body>
</html>
