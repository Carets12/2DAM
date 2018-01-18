<?php
  class Persona {

    protected $nombre;
    protected $apellidos;
    protected $dni;
    protected $email;

    public function Persona($nombre,$apellidos,$dni,$email){
      $this->nombre=$nombre;
      $this->apellidos=$apellidos;
      $this->dni=$dni;
      $this->email=$email;
    }

    public function getNombre(){
      return $this->nombre;
    }

    public function setNombre($dato){
       $this->nombre = $dato;
    }

  }

?>
