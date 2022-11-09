package pe.idat.service;

import java.util.List;

import pe.idat.model.Estudiante;


public interface EstudianteService {
	List<Estudiante> listar();
	Estudiante obtener(Integer id);
}
