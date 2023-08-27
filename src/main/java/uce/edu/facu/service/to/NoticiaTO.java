package uce.edu.facu.service.to;

import java.util.List;

public class NoticiaTO {
    
    private String titulo, descripcion;
    
    private List<String> urlImagen, urlVideo;

    

    public NoticiaTO(String titulo, String descripcion, List<String> urlImagen, List<String> urlVideo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.urlVideo = urlVideo;
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

    public List<String> getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(List<String> urlImagen) {
        this.urlImagen = urlImagen;
    }

    public List<String> getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(List<String> urlVideo) {
        this.urlVideo = urlVideo;
    }

    
    
    
}
