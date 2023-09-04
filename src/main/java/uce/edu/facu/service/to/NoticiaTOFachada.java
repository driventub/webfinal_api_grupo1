package uce.edu.facu.service.to;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NoticiaTOFachada {
    private String titulo, descripcion;
    
    private List<String>  urlVideo;

    private List<MultipartFile> imagen;
    
    


    public NoticiaTOFachada(String titulo, String descripcion, List<String> urlVideo, List<MultipartFile> imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlVideo = urlVideo;
        this.imagen = imagen;
    }

    public List<MultipartFile> getImagen() {
        return imagen;
    }

    public void setImagen(List<MultipartFile> imagen) {
        this.imagen = imagen;
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

    
    
    

}
