package br.com.cinq.sample.resource;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cinq.sample.bean.Person;

/**
 * Service
 */
@Path("/people")
public class PeopleResource {
	Logger logger = LoggerFactory.getLogger(PeopleResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPeople() {
		logger.debug("Received GET requisition");
        List<Person> people = new ArrayList<Person>();
		return Response.ok().entity(generateFakeList()).build();
	}
    
    private List<Person> generateFakeList() {
        Random rnd = new Random();
        String[] name = { "Adam", "Abe", "Maria", "Rose", "Mario", "Luigi"};
        String[] surname = { "Lincoln", "Franklin", "Jackson", "Miyazaki", "M'bebe", "Berger"};
        List<Person> list=new ArrayList<Person>();
        
        int counter = 0;
        for(int i=0;i<6;i++) {
            for(int j=0;j<6;j++) {
                Person person = new Person();
                person.setId(counter++);
                person.setName(name[i] + " " + surname[j]);
                list.add(person);
            }
        }
        
        return list;
    }
}
