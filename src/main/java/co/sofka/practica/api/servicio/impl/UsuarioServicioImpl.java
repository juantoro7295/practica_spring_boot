package co.sofka.practica.api.servicio.impl;

import co.sofka.practica.api.modelo.Usuario;
import co.sofka.practica.api.repositorio.UsuarioRepositorio;
import co.sofka.practica.api.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return (ArrayList<Usuario>) usuarioRepositorio.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario existeUsuario = usuarioRepositorio.findById(usuario.getId_usuario()).orElse(null);
        existeUsuario.setNombre(usuario.getNombre());
        existeUsuario.setEmail(usuario.getEmail());
        existeUsuario.setPrioridad(usuario.getPrioridad());
        return usuarioRepositorio.save(existeUsuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    @Override
    public ArrayList<Usuario> obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepositorio.findByPrioridad(prioridad);
    }

}
