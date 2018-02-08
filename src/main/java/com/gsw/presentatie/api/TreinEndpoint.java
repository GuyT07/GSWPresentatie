package com.gsw.presentatie.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gsw.presentatie.domain.Trein;
import com.gsw.presentatie.domain.Wagon;
import com.gsw.presentatie.persistence.TreinService;

@Path("trein")
@Component
public class TreinEndpoint {
	
	@Autowired
	private TreinService treinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Trein> treinen = treinService.findAll();
		return Response.ok(treinen).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postTrein(Trein trein){
		Trein result = treinService.save(trein);
		return Response.accepted(result.getTrein_id()).build();	
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrein(@PathParam("id") final long id){
		Trein trein = treinService.findById(id);
		return Response.ok(trein).build();
	}
	
	@GET
	@Path("/wagons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWagonsForTrain(@PathParam("id") final long id){
		List<Wagon> wagons = treinService.getWagon(id);
		return Response.ok(wagons).build();
	}
	
	@GET
	@Path("/guess/{guess}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWagonsForTrain(@PathParam("guess") final String guess){
		List<Trein> treinen = treinService.guessTrainBrand(guess);
		return Response.ok(treinen).build();
	}

}
