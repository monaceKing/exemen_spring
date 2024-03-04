package exemen.boubs.spring.controllers;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exemen.boubs.spring.bto.ClientDTO;
import exemen.boubs.spring.entities2.Client;
//import exemen.boubs.spring.entities2.Client;
import exemen.boubs.spring.entities2.Gestionnaire;
import exemen.boubs.spring.entities2.RechargeClient;
//import exemen.boubs.spring.services.ClientService;
import exemen.boubs.spring.services.GestionnaireService;

@RestController
@RequestMapping("/gestionnaire")
public class GestionnaireController {
	
	@Autowired
	private GestionnaireService gestionnaireService;
	
	
	
	@PostMapping
	public Gestionnaire createGestionnaire(@RequestBody Gestionnaire gestionnaire) {
		return gestionnaireService.createGestionnaire(gestionnaire);
	}
	
	
	@GetMapping
	public List<ClientDTO> getAllClients(){
		return gestionnaireService.getAllClients();
	}
	
	
	@GetMapping(path = "findByPhoneNumber/{telephone}")
	public ResponseEntity<Client> findByPhoneNumber(@PathVariable String telephone){
		Client client = gestionnaireService.findByPhoneNumber(telephone);
		
		if (client != null) {
			return new ResponseEntity<>(client, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	
	
	@PutMapping
	public Client updateClient(@RequestBody Client client) {
		return gestionnaireService.updateClient(client);
	}
	
	
	
    @PostMapping("/recharge")
    public ResponseEntity<Client> rechargeCompteClient(@RequestBody RechargeClient rechargeClient) {
        Client clientMisAJour = gestionnaireService.rechargeCompteClient(rechargeClient.getNumeroTelephone(), rechargeClient.getMontant());
        if (clientMisAJour != null) {
            return new ResponseEntity<>(clientMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
    
    
    @PostMapping("/bloquer")
    public ResponseEntity<Client> bloquerClient(@RequestBody Client client) {
        Client clientMisAJour = gestionnaireService.bloquerClient(client);
        if (clientMisAJour != null) {
            return new ResponseEntity<>(clientMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
}
