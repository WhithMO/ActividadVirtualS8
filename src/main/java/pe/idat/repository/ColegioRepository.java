package pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.idat.model.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Integer>{
	

}
