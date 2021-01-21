package org.acme.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pecas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PecaResource {


	private Set<Peca> pecas = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
	
	public PecaResource() {
		pecas.add(new Peca(1,"Maçã", "fruta vermelha"));
		pecas.add(new Peca(2,"Laranja", "fruta alaranjada"));
	}

	@GET
	public Set<Peca> list(){
		return pecas;
	}
	
	@POST
	public Response add(Peca fruit){
		fruit.id = pecas.size() + 1;
		pecas.add(fruit);
		return Response.ok(pecas).status(Response.Status.CREATED).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id){
		pecas.removeIf(existingPeca -> existingPeca.id.equals(id));
		return Response.status(Response.Status.NO_CONTENT).build();
	
	}
	

}