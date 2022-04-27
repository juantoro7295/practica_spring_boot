package co.sofka.practica.api.servicio;

import co.sofka.practica.api.modelo.Rol;

import java.util.ArrayList;
import java.util.Optional;

public interface RolServicio {

    Rol guadarRol(Rol rol);
    ArrayList<Rol> listarRoles();
    Optional<Rol> obtenerRolPorId(Long id);
    Rol actualizarRol(Rol rol);
    void eliminarRol(Long id);

}
