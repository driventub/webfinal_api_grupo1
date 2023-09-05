package uce.edu.facu.service.to;

import java.io.Serializable;

import lombok.Data;
import uce.edu.facu.model.Foro;

@Data
public class ForoTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Foro foro;
	
	private String asunto;
	
	private String mensaje;
	
	private String cedulaEstudiante;
}
