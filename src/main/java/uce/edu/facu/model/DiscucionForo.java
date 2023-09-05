package uce.edu.facu.model;

import java.time.LocalDateTime;
import java.util.List;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "discucion")
public class DiscucionForo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discu_id_seq")
	@SequenceGenerator(name = "discu_id_seq", sequenceName = "discu_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "discu_mensaje")
	private String mensaje;

	@Column(name = "discu_fecha")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fecha;

	@Column(name = "discu_estudiante")
	private String estudiante;
	
	@ManyToOne
	@JoinColumn(name="foro_id_discucion")
	private Foro foro;

	
	@JsonIgnore
	@OneToMany(mappedBy = "discuForo",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Suscriptor> suscriptores;
	
}
