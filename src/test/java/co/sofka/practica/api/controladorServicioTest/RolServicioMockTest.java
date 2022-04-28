package co.sofka.practica.api.controladorServicioTest;

import co.sofka.practica.api.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class RolServicioMockTest {

    @MockBean
    UsuarioRepositorio rolRepositorio;


    @Test
    public void testRol() {
        when(rolRepositorio.findAll()).thenReturn(new ArrayList<>());
        assertThat(rolRepositorio.findAll());
        verify(rolRepositorio).findAll();
    }



}
