package uce.edu.facu.service.to;

import java.io.Serializable;

import lombok.Data;
import uce.edu.facu.model.DiscucionForo;

@Data
public class ForoDiscucionTO implements Serializable {

	
	private static final long serialVersionUID =1L;
	
	private DiscucionForo discuForo;
	
	private Integer idForo;
	
	private String cedulaEstu;
	
	
}
