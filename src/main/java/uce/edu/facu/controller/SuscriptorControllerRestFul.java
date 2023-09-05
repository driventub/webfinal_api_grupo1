package uce.edu.facu.controller;

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

import uce.edu.facu.model.Suscriptor;
import uce.edu.facu.service.ISuscriptorService;

@RestController
@RequestMapping("/suscriptores")
@CrossOrigin
public class SuscriptorControllerRestFul {

    @Autowired
    private ISuscriptorService suscriptorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> guardarSuscriptor(@RequestBody Suscriptor suscriptor) {
        if (this.suscriptorService.guardarSuscriptor(suscriptor) == true) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }

    }
    
    @GetMapping(path="/{cedula}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Suscriptor> obtenerPorCedula(@PathVariable(name="cedula")String cedula){
    	return new ResponseEntity<>(this.suscriptorService.buscarPorCedula(cedula),null,HttpStatus.OK);
    }
    
    @GetMapping(path="/verify/{cedula}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> verificarSus(@PathVariable(name="cedula")String cedula){
    	if(this.suscriptorService.verificarExistenciaSuscriptor(cedula)) {
    		return new ResponseEntity<>(true,null,HttpStatus.OK);
    	}else {
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    	}
    }
}
