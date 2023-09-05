package uce.edu.facu.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "suscriptor")
public class Suscriptor {

    @Id
    @Column(name = "susc_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
    @SequenceGenerator(name = "name_generator", sequenceName = "susc_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "susc_nombre")
    private String nombre;

    @Column(name = "susc_apellido")
    private String apellido;

    @Column(name = "susc_cedula")
    private String cedula;

    @Column(name = "susc_correo")
    private String correo;

    @Column(name = "susc_telefono")
    private String telefono;

    @Column(name = "susc_direccion")
    private String direccion;

    @Column(name = "susc_fecha_suscripcion")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaSuscripcion;

    @Column(name = "susc_estado")
    private String estado;
    
    @ManyToMany(mappedBy = "suscriptores")
    private Set<Foro> foros = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="discForo_id_suscriptor")
    private DiscucionForo discuForo;

  
}
