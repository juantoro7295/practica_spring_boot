package co.sofka.practica.api.controlador;

import co.sofka.practica.api.modelo.Usuario;
import co.sofka.practica.api.servicio.impl.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicioImpl usuarioServicioImpl;

    //listar todos los usuarios
    @GetMapping("/listar")
    public ResponseEntity<ArrayList<Usuario>> listarUsuarios() {
        ArrayList<Usuario> listarUsuarios = usuarioServicioImpl.listarUsuarios();
        try {
            return new ResponseEntity<>(listarUsuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //guardar un usuario
    @PostMapping("/guardar")
    public ResponseEntity<Usuario> guadarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioServicioImpl.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    //Actualizar un usuario
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> obtenerUsuario = usuarioServicioImpl.obtenerUsuarioPorId(usuario.getId_usuario());
        if (obtenerUsuario.isPresent()) {
            return new ResponseEntity<>(usuarioServicioImpl.actualizarUsuario(usuario), HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe el usuario que quieres actualizar", HttpStatus.NOT_FOUND);
    }

    //obtener un usuario por su id
    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        Optional<Usuario> obtenerUsuario = usuarioServicioImpl.obtenerUsuarioPorId(id);
        if (obtenerUsuario.isPresent()) {
            return new ResponseEntity<>(obtenerUsuario, HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontro el usuario", HttpStatus.NOT_FOUND);
    }

    //listar usuarios por prioridad
    @GetMapping("/listarPrioridad/{prioridad}")
    public ResponseEntity<?> listarUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        try {
            return new ResponseEntity<>(usuarioServicioImpl.obtenerPorPrioridad(prioridad), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //eliminar el usuario por su id
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUnUsuario(@PathVariable("id") Long id) {
        Optional<Usuario> obtenerUsuario = usuarioServicioImpl.obtenerUsuarioPorId(id);
        if (obtenerUsuario.isPresent()) {
            usuarioServicioImpl.eliminarUsuario(id);
            return new ResponseEntity<>("Se elimino correctamente", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("No existe el usuario que quiere eliminar", HttpStatus.NOT_FOUND);
    }


}
