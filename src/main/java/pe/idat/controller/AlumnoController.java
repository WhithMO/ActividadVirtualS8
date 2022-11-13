package pe.idat.controller;

import pe.idat.model.Alumno;
import pe.idat.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumno/v1")
public class AlumnoController {
    @Autowired
    private AlumnoService service;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<Alumno>> listar(){
        return new ResponseEntity<List<Alumno>>(service.listar(), HttpStatus.OK) ;
    }

    @RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Integer id){

    	Alumno alumno = service.obtener(id);

        if( alumno != null) {
            return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
        }else {
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }

    }
    
    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> editar(@RequestBody Alumno alumno){

    	Alumno a = service.obtener(alumno.getId());

        if( a != null) {
            service.actualizar(alumno);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void>eliminar(@PathVariable Integer id){

    	Alumno alumno = service.obtener(id);

        if(alumno != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
