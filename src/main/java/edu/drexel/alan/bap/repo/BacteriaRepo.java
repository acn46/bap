package edu.drexel.alan.bap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.drexel.alan.bap.model.Bacteria;

@Repository
public interface BacteriaRepo extends JpaRepository<Bacteria, Integer>{

	Bacteria findByTaxId(int taxId);
	
}
