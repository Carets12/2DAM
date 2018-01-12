<?php
  class Cliente {

    private $nombre;
    private $apellidos;
    private $dni;
    private $email;

    public function _construct(){
      $this->nombre="";
      $this->apelidos="";
      $this->dni="";
      $this->email="";
    }

    public function getNombre(){
      return $this->nombre;
    }

    public function setNombre($dato){
       $this->nombre = $dato;
    }

  }

?>
