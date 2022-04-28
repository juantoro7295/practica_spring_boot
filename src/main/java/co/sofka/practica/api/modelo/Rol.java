package co.sofka.practica.api.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(
            targetEntity = Usuario.class,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario;




}
