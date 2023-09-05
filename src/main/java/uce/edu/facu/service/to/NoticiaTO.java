package uce.edu.facu.service.to;

import java.util.List;

public class NoticiaTO {
    
    private String titulo, descripcion;
    
    private List<String>  urlVideo, urlImagen;

    

    public NoticiaTO() {
    }

    public NoticiaTO(String titulo, String descripcion, List<String> urlVideo, List<String> urlImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlVideo = urlVideo;
        this.urlImagen = urlImagen;
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

   

    public List<String> getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(List<String> urlVideo) {
        this.urlVideo = urlVideo;
    }

    public List<String> getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(List<String> urlImagen) {
        this.urlImagen = urlImagen;
    }

    
}
