package pe.idat.service;

import java.util.List;

import pe.idat.model.Colegio;

public interface ColegioService {
	void guardar(Colegio colegio);
	void actualizar(Colegio colegio);
	void eliminar (Integer id);
	List<Colegio> listar();
	Colegio obtener(Integer id);
}
