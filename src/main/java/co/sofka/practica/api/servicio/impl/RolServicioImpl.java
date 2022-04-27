package co.sofka.practica.api.servicio.impl;

import co.sofka.practica.api.modelo.Rol;
import co.sofka.practica.api.modelo.Usuario;
import co.sofka.practica.api.repositorio.RolRepositorio;
import co.sofka.practica.api.servicio.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolServicioImpl implements RolServicio {
    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public Rol guadarRol(Rol rol) {
        return rolRepositorio.save(rol);
    }

    @Override
    public ArrayList<Rol> listarRoles() {
        return (ArrayList<Rol>) rolRepositorio.findAll();
    }

    @Override
    public Optional<Rol> obtenerRolPorId(Long id) {
        return rolRepositorio.findById(id);
    }

    @Override
    public Rol actualizarRol(Rol rol) {
        Rol existeRol = rolRepositorio.findById(rol.getId_Rol()).orElse(null);
        existeRol.setNombreRol(rol.getNombreRol());
        return rolRepositorio.save(existeRol);
    }

    @Override
    public void eliminarRol(Long id) {
        rolRepositorio.deleteById(id);
    }
}
