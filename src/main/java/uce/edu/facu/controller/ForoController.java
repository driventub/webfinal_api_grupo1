package uce.edu.facu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.facu.model.Foro;
import uce.edu.facu.service.IForoService;
import uce.edu.facu.service.to.ForoTO;

@RestController
@CrossOrigin
@RequestMapping("/foros")
public class ForoController {

	@Autowired
	private IForoService foroService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Foro> crearForo(@RequestBody ForoTO foro){
		return new ResponseEntity<>(this.foroService.crearForo(foro),null,HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Foro>> listarForos(){
		return new ResponseEntity<>(this.foroService.listarForos(),null,HttpStatus.OK);
	}
	
	@GetMapping(path="/{tag}")
	public ResponseEntity<List<Foro>> listarPorTag(@PathVariable(name="tag")String tag){
		return new ResponseEntity<>(this.foroService.BuscarPorTag(tag),null,HttpStatus.OK);
	}
	
	@GetMapping(path="/asun/{asunto}")
	public ResponseEntity<List<Foro>> listarPorAsunto(@PathVariable(name="asunto")String sunto){
		return new ResponseEntity<>(this.foroService.buscarPorAsunto(sunto),null,HttpStatus.OK);
	}
	
	@GetMapping(path="/id/{id}")
	public ResponseEntity<Foro> listarPorId(@PathVariable(name="id")Integer id){
		return new ResponseEntity<>(this.foroService.buscarPorID(id),null,HttpStatus.OK);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Foro> actualizarForo(@RequestBody ForoTO foro){
		return new ResponseEntity<>(this.foroService.actualizarForo(foro),null,HttpStatus.OK);
	}
	
	@GetMapping(path="/comen/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> obtenerNumeroComentarios(@PathVariable(name="id")Integer id){
		return new ResponseEntity<>(this.foroService.obtenerNumeroComentarios(id),null,HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Integer> eliminarForoPorId(@PathVariable(name="id")Integer id){
		return new ResponseEntity<>(this.foroService.eliminarPorId(id),null,HttpStatus.OK);
	}
	
	@GetMapping(path="/verify")
	public ResponseEntity<Boolean> verificaraParaEliminar(@RequestParam Integer idForo, @RequestParam String cedula){
		System.out.println("Recibiendo datos en el controller: "+idForo +" cedula "+cedula);
		if(this.foroService.verificarSuscriptorParaEliminar(idForo, cedula)) {
			return new ResponseEntity<>(true,null,HttpStatus.OK);
		}else {
		    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
}
