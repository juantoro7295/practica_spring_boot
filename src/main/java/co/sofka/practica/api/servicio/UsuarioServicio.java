package co.sofka.practica.api.servicio;

import co.sofka.practica.api.modelo.Usuario;
import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioServicio {

    Usuario guardarUsuario(Usuario usuario);
    ArrayList<Usuario> listarUsuarios();
    Optional<Usuario> obtenerUsuarioPorId(Long id);
    Usuario actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
    ArrayList<Usuario> obtenerPorPrioridad(Integer prioridad);






}
