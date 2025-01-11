import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_Creacion;
    private Boolean status;
    private String autor;
    private String curso;

    public Topico (){
    }

    public Topico(DatosRegistroTopicos datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.status = true;
        this.autor = datos.autor();
        this.curso = datos.curso();
        this.fecha_Creacion = LocalDateTime.now();
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if (datos.autor() != null && !datos.autor().isEmpty()) {
            this.autor = datos.autor();
        }
        if (datos.titulo() != null && !datos.titulo().isEmpty()) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null && !datos.mensaje().isEmpty()) {
            this.mensaje = datos.mensaje();
        }
        if (datos.curso() != null && !datos.curso().isEmpty()) {
            this.curso = datos.curso();
        }
    }

//    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico){
//        if (datosActualizarTopico.titulo() != null){
//            this.titulo = datosActualizarTopico.titulo();
//        }
//        if (datosActualizarTopico.mensaje() != null){
//            this.mensaje = datosActualizarTopico.mensaje();
//        }
//        if (datosActualizarTopico.autor() != null){
//            this.autor = datosActualizarTopico.autor();
//        }
//        if (datosActualizarTopico.curso() != null){
//            this.curso = datosActualizarTopico.curso();
//        }
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(LocalDateTime fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void desactivarTopico(){
        this.status = false;
    }
}
