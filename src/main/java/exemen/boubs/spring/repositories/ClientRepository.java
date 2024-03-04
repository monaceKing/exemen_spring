package exemen.boubs.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exemen.boubs.spring.entities2.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	public Client findByTelephone(String telephone);

}
