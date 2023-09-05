package uce.edu.facu.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "foro")
public class Foro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foro_id_seq")
	@SequenceGenerator(name = "foro_id_seq", sequenceName = "foro_id_seq", allocationSize = 1)
	@Column(name = "foro_id")
	private Integer id;
	@Column(name = "foro_asunto")
	private String asunto;
	@Column(name="foro_tag")
	private String tag;
	@Column(name = "foro_mensaje")
	private String mensaje;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "foro_fecha_creacion")
	private LocalDateTime fechaCreacion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "foro",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DiscucionForo> discuciones;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 @JoinTable(
		        name = "foro_suscriptor",
		        joinColumns = @JoinColumn(name = "foro_id"),
		        inverseJoinColumns = @JoinColumn(name = "susc_id")
		    )
	private Set<Suscriptor> suscriptores;
	
	
}
















