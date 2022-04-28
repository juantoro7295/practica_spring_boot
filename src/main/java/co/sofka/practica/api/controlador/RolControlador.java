package co.sofka.practica.api.controlador;

import co.sofka.practica.api.modelo.Rol;
import co.sofka.practica.api.servicio.impl.RolServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/rol")
public class RolControlador {
    @Autowired
    private RolServicioImpl rolServicioImpl;

    //listar todos los roles
    @GetMapping("/listar")
    public ResponseEntity<ArrayList<Rol>> listarRoles(){
        ArrayList<Rol> listarRoles = rolServicioImpl.listarRoles();
        try {
            return new ResponseEntity<>(listarRoles, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //guardar un rol
    @PostMapping("/guardar")
    public ResponseEntity<Rol> guardarUnRol(@RequestBody Rol rol){
        return  new ResponseEntity<>(rolServicioImpl.guadarRol(rol),HttpStatus.CREATED);
    }

    //Actualizar un rol
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarUnRol(@RequestBody Rol rol){
        Optional<Rol> existeRol = rolServicioImpl.obtenerRolPorId(rol.getId_rol());
        if(existeRol.isPresent()){
            return new ResponseEntity<>(rolServicioImpl.actualizarRol(rol), HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe el usuario que quieres actualizar", HttpStatus.NOT_FOUND);
    }

    //Obtener un rol por id
    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerRolPorId(@PathVariable("id") Long id){
        Optional<Rol> obtenerUsuario = rolServicioImpl.obtenerRolPorId(id);
        if(obtenerUsuario.isPresent()){
            return new ResponseEntity<>(obtenerUsuario, HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontro el rol", HttpStatus.NOT_FOUND);
    }
    //Eliminar un rol por id
   @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUnRol(@PathVariable("id") Long id){
        Optional<Rol> obtenerUsuario = rolServicioImpl.obtenerRolPorId(id);
        if(obtenerUsuario.isPresent()){
            rolServicioImpl.eliminarRol(id);
            return new ResponseEntity<>("Se elimino correcta", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("No existe el rol que quiere eliminar", HttpStatus.NOT_FOUND);
    }

}
