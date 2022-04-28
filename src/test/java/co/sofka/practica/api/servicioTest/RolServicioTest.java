package co.sofka.practica.api.servicioTest;

import co.sofka.practica.api.modelo.Rol;
import co.sofka.practica.api.modelo.Usuario;
import co.sofka.practica.api.repositorio.RolRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class RolServicioTest {

    @Autowired
    private RolRepositorio rolRepositorio;

    @Test
    public void testGuardarRol(){
        List<Rol> roles = new ArrayList<Rol>();
        Usuario usuario = new Usuario(1L, "juan", "juan@mail.com", 10, roles);
        Rol rol = new Rol(2l,"piloto",usuario);
        Rol rolGuardar = rolRepositorio.save(rol);
        assertNotNull(rolGuardar);
    }
    @Test
    public void testListarRoles() {
        Iterable<Rol> usuarioRolList =  rolRepositorio.findAll();
        assertThat(usuarioRolList).size().isPositive();
    }





}
