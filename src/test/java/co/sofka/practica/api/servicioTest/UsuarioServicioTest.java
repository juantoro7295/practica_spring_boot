package co.sofka.practica.api.servicioTest;


import co.sofka.practica.api.modelo.Rol;
import co.sofka.practica.api.modelo.Usuario;
import co.sofka.practica.api.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioServicioTest {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Test
    public void testGuardarUsuario() {
        List<Rol> roles = new ArrayList<Rol>();
        Usuario usuario = new Usuario(1L, "juan", "juan@mail.com", 10, roles);
        Usuario usuarioRegistrado = usuarioRepositorio.save(usuario);
        assertNotNull(usuarioRegistrado);
    }
    @Test
    public void testObtenerUsuarioPorId(){
        Long idObtener=1L;
        Optional<Usuario> usuarioAObtener=usuarioRepositorio.findById(idObtener);
        assertThat(usuarioAObtener.get().getId_usuario()).isEqualTo(idObtener);
    }

    @Test
    public void testListarUsuarios(){
        List<Usuario> usuarioListar=(List<Usuario>) usuarioRepositorio.findAll();
        assertThat(usuarioListar).size().isPositive();
    }

    @Test
    public void testObtenerPrioridad() {
        Integer prioridad = 15;
        List<Usuario> usuarioPrioridad = usuarioRepositorio.findByPrioridad(prioridad);
        assertNotNull(usuarioPrioridad);
    }
}





