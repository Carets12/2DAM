<?php

require('Persona.php');
  class Cliente extends Persona {

    private $id_cliente;

    function getId(){
      return $this->id_cliente;
    }

    function setId($dato){
      return $this->id_cliente = $dato;
    }
  }

?>
