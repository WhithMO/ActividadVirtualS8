package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Estudiante;
import pe.idat.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    @Override
    public List<Estudiante> listar() {
        return repository.findAll();
    }

    @Override
    public Estudiante obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

}
