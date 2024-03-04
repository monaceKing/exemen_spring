package exemen.boubs.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exemen.boubs.spring.entities2.Gestionnaire;

@Repository
public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Long>{
	
	public boolean existsByEmail(String email);
}
