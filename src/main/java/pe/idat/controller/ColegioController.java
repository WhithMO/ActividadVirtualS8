package pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.model.Colegio;

import pe.idat.service.ColegioService;


@RestController
@RequestMapping("/colegio/v1")
public class ColegioController {

	
	@Autowired
	private ColegioService repository;
	
	@Autowired
	@RequestMapping(path = "/listar", method = RequestMethod.GET)		// esto es para poner una url, un sub recurso tiene q estar entre los parentesis.
	public ResponseEntity<List<Colegio>> listar() {
		return new ResponseEntity<List<Colegio>>(repository.listar(), HttpStatus.OK);	// cuando es de tipo GET, osea cuando se obtendra un OBJETO, lo que va en el parametro anterior al HTTPSTATUS, sera el OBJETO que estamos trayendo u obteniendo. 
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Colegio colegio) {	// cuando un metodo nos trae un objeto para poder usarlo (interprete y trabajarlo) se usa la anotacion @RequestBody
		repository.guardar(colegio);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/detalle/{id}", method = RequestMethod.GET)
	public ResponseEntity<Colegio> obtenerPorId(@PathVariable Integer id) {	// El @PathVariable es para poder usar una VARIABLE que esta en el PATH.
		Colegio colegio = repository.obtener(id);
		if (colegio != null) {
			return new ResponseEntity<Colegio>(colegio, HttpStatus.OK);
		}else {
			return new ResponseEntity<Colegio>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Colegio colegio) {
		Colegio cole = repository.obtener(colegio.getId());
		
		if (cole != null) {
			repository.actualizar(colegio);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		Colegio colegio = repository.obtener(id);
		
		if (colegio != null) {
			repository.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
