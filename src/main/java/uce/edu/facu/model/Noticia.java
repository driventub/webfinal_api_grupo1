package uce.edu.facu.model;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "noticia")
public class Noticia {

    @Id
    @Column(name = "noti_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
    @SequenceGenerator(name = "name_generator", sequenceName = "noti_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "noti_titulo")
    private String titulo;

    @Column(name = "noti_descripcion" , columnDefinition = "text")
    private String descripcion;

    @Column(name = "noti_fecha")
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "noticia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Imagen> listaImagenes;

    @OneToMany(mappedBy = "noticia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Video> listaVideo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<Imagen> getListaImagenes() {
        return listaImagenes;
    }

    public void setListaImagenes(List<Imagen> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    public List<Video> getListaVideo() {
        return listaVideo;
    }

    public void setListaVideo(List<Video> listaVideo) {
        this.listaVideo = listaVideo;
    }

    



}