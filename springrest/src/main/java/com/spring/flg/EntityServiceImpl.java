package com.spring.flg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Person;
import com.spring.repo.PersonRepo;

@RestController
public class EntityServiceImpl{

		
	@Autowired
	PersonRepo repository;
	
	@GetMapping("persons")
	public List<Person> getAllPersons() {
		
		System.out.println("In GET method");
		return repository.findAll();
	}
    
	@GetMapping("person/{id}")
	public Person getPerson(@PathVariable long id) {
         
    	return repository.findById(id).get();
	}
	
	
    @PostMapping("addperson")
    public Person addPerson(@RequestBody Person pPrsn) {

        Person p = repository.save(pPrsn);
        
		return p;
	}

	
    @PutMapping(path = "updateperson/{id}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	public Person updatePerson(@PathVariable long id,@RequestBody Person pPrsn) {
		
		Person p = repository.findById(id).get();
		
		if(p != null) {
		   p.getClone(pPrsn);
		   p = repository.save(p);
		}
        
		return p;
	}

	@DeleteMapping("delperson/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable long id) {
		
		
        Person p = repository.findById(id).get();
		
		if(p != null) {
		   repository.delete(p);
		   return new ResponseEntity("Delete done!!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No such Person exist!!", HttpStatus.OK);
		}
	}

	
	
	
	
}
