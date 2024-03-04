package exemen.boubs.spring.services;

import org.springframework.http.ResponseEntity;
//import java.util.List;

import exemen.boubs.spring.entities2.Client;
import exemen.boubs.spring.entities2.TransfertArgent;

public interface ClientService {

//	public List<Client> getAllClients();//
	public Client findClientById(Long id);
	public Client createClient(Client client);
	public Client transfertArgent(TransfertArgent transfertArgent);
	public Double consulterSoldeClient(String numeroTelephone);
