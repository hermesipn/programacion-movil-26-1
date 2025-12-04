package mx.ipn.upiicsa.programacionmovil.citas.entity.controlacceso

import java.time.LocalDate

class Persona(var id : Int,
              var nombre : String,
              var primerApellido : String,
              var segundoApellido : String,
              var nacimiento : LocalDate) {
    var genero : Genero ?= null

}