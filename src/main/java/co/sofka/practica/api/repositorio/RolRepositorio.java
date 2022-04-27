package co.sofka.practica.api.repositorio;

import co.sofka.practica.api.modelo.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends CrudRepository<Rol, Long> {



}
