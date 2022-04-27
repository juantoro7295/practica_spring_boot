package co.sofka.practica.api.repositorio;

import co.sofka.practica.api.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    ArrayList<Usuario> findByPrioridad(Integer prioridad);

}
