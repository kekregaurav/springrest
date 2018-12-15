package com.spring.flg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	/*
	public Response updtPerson(Person pPrsn) {
		
		if(this.prsnList.get(pPrsn.getpID()) != null)
		    this.prsnList.put(pPrsn.getpID(), pPrsn);
		
		return Response.ok((Person)this.prsnList.get(pPrsn.getpID())).build();
		
		Person p = repository.save(pPrsn);
        
		return Response.ok(p).build();
	}

	public Response delPerson(long id) {
		
		Response resp;
		if(this.prsnList.get(id) != null) {
		    this.prsnList.remove(id);
		    resp =  Response.ok("The person deleted successfully").build();
		}else {
			resp = Response.notModified().build();
		}
		
		if(repository.findById(id).get() != null) {
			repository.delete(repository.findById(id).get());
			return Response.ok("The person deleted successfully").build();
		}else {
			return Response.notModified().build();
		}
	
	}*/

	
	
	
	
}
