package com.spring.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.SpringrestApplication;
import com.spring.model.Person;

@SpringBootTest(classes = SpringrestApplication.class)
public class SpringRestAppTests extends AbstractTestNGSpringContextTests{
      
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	
	private MockMvc mockMvc;

	@BeforeClass
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGetPerson() throws Exception {
		System.out.println("***** Testing 'persons'  ****");
		mockMvc.perform(get("/persons")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
		
		
	}
	
	@Test
	public void testGetPersonId() throws Exception {
				
		System.out.println("***** Testing 'person/{id}'  ****");
		mockMvc.perform(get("/person/2")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.fname").value("Heena"));

	}
	
	@Test
	public void testDeletePersonId() throws Exception {
				
		System.out.println("***** Testing 'delperson/{id}'  ****");
		mockMvc.perform(delete("/delperson/3")).andExpect(status().isOk());

	}
	
	@Test
	public void testPostAddPerson() throws Exception {
				
		System.out.println("***** Testing 'addPerson'  ****");
		
		Person p = this.createMockPerson();
		
		mockMvc.perform(post("/addperson")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(toJason(p)))
		        .andExpect(status().isOk());

	}
	
	
	@Test
	public void testPutUpdatePersonId() throws Exception {
				
		System.out.println("***** Testing 'updateperson/{id}'  ****");
		
		Person p = this.createMockPerson();
		
		mockMvc.perform(put("/updateperson/3").contentType(MediaType.APPLICATION_JSON_UTF8).content(toJason(p)))
		        .andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));

	}
	
	
	
	private String toJason(Person pPrsn) {
		
		String objJackson = null;
		
		try {
			objJackson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pPrsn);
			System.out.println(objJackson);
        } catch (JsonProcessingException e) {
            System.out.println("failed conversion: Pfra object to Json"+ e.toString());
        }
		
		return objJackson;
	}
	
	private Person createMockPerson() {
		
		Person person = new Person();
		person.setPid(3);
		person.setFname("mockFName");
		person.setLname("mockLName");
		
		
		return person;
	}
	
}
