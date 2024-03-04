package exemen.boubs.spring.controllers;

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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exemen.boubs.spring.entities2.Client;
import exemen.boubs.spring.entities2.TransfertArgent;
import exemen.boubs.spring.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	
	@GetMapping(path = "/{id}")
	public Client findCleintById(@PathVariable Long id) {
		return clientService.findClientById(id);
	}
	
	
	@PostMapping
	public Client createClient(@RequestBody Client client) {
		return clientService.createClient(client);
	}
	
	
    @PostMapping("/transfert")
    public ResponseEntity<Client> transfertArgent(@RequestBody TransfertArgent transfertArgent) {
        Client client = clientService.transfertArgent(transfertArgent);
        
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/solde/{numeroTelephone}")
    public ResponseEntity<Double> consulterSoldeClient(@PathVariable String numeroTelephone) {
        Double solde = clientService.consulterSoldeClient(numeroTelephone);
        if (solde != null) {
            return new ResponseEntity<>(solde, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
	
}
