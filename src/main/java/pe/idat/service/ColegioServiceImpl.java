package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Colegio;
import pe.idat.repository.ColegioRepository;

@Service
public class ColegioServiceImpl implements ColegioService{

	@Autowired
	private ColegioRepository repository;
	
	@Override
	public void guardar(Colegio colegio) {
		repository.save(colegio);
		
	}

	@Override
	public void actualizar(Colegio colegio) {
		repository.saveAndFlush(colegio);
		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Colegio> listar() {
		return repository.findAll();
	}

	@Override
	public Colegio obtener(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
