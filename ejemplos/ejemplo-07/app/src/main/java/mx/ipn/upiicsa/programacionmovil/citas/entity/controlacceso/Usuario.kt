package mx.ipn.upiicsa.programacionmovil.citas.entity.controlacceso

class Usuario (var id: Int,
    var idRol: Int,
    var login: String,
    var password: String,
    var activo: Boolean,
    var rol: Rol?){
}