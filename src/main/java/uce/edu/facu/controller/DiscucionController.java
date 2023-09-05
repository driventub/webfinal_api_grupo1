package uce.edu.facu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import uce.edu.facu.model.DiscucionForo;
import uce.edu.facu.service.IForoDiscucionService;
import uce.edu.facu.service.to.ForoDiscucionTO;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/discuciones")
public class DiscucionController {

	
	@Autowired
	private IForoDiscucionService foroDiscuService;
	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DiscucionForo> crearComentarioPorForo(@RequestBody ForoDiscucionTO foroDiscuTO){
		return new ResponseEntity<>(this.foroDiscuService.guardarDiscucion(foroDiscuTO),null,HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DiscucionForo>> obtenerComentariosPorForo(@PathVariable(name="id")Integer id){
		return new ResponseEntity<>(this.foroDiscuService.listarComentariosPorIdForo(id),null,HttpStatus.OK);
	}
}
