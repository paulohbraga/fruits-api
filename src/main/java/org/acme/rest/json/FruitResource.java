package org.acme.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

	private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
	
	public FruitResource() {
		fruits.add(new Fruit("Maçã", "fruta vermelha"));
		fruits.add(new Fruit("Laranja", "fruta alaranjada"));
	}
	
	@GET
	public Set<Fruit> list(){
		return fruits;
	}
	
	@POST
	public Response add(Fruit fruit){
		fruits.add(fruit);
		return Response.ok(fruits).status(Response.Status.CREATED).build();
	}
	
	@DELETE
	@Path(/)

	public Set<Fruit> delete(Fruit fruit){
		fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
		return fruits;
	
	}
	

}