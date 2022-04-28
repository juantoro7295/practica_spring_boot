package co.sofka.practica.api.controladorServicioTest;

import co.sofka.practica.api.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioServicioMockTest {
    @MockBean
    UsuarioRepositorio usuarioRepositorio;



    @Test
    public void testUsuarioMock() {
        when(usuarioRepositorio.findAll()).thenReturn(new ArrayList<>());
        assertThat(usuarioRepositorio.findAll()).isEmpty();
        verify(usuarioRepositorio).findAll();
    }




}
