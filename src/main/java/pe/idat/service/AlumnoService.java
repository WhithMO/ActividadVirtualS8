package pe.idat.service;

import java.util.List;

import pe.idat.model.Alumno;


public interface AlumnoService {
	List<Alumno> listar();
	Alumno obtener(Integer id);
    public void actualizar(Alumno alumno);
    public void eliminar(Integer id);
    public void guardar(Alumno alumno);
}
