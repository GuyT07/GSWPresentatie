package com.gsw.presentatie.api;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gsw.presentatie.domain.Trein;
import com.gsw.presentatie.domain.Wagon;
import com.gsw.presentatie.persistence.TreinService;

@Path("trein")
@RestController
public class TreinEndpoint {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private TreinService treinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		final Iterable <Trein> treinen = treinService.findAll();
		return Response.ok(treinen).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postTrein(final Trein trein){
		final Trein result = treinService.save(trein);
		UriBuilder responseURI = UriBuilder
	            .fromPath("//"+request.getServerName() + ":" + request.getServerPort())
	            .scheme("http")
	            .path(request.getRequestURI() + "/" + result.getId());
		return Response.created(responseURI.build()).build();	
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrein(@PathParam("id") final long id){
		final Trein trein = treinService.findById(id);
		return Response.ok(trein).build();
	}
	
	@GET
	@Path("/wagons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWagonsForTrain(@PathParam("id") final long id){
		final List<Wagon> wagons = treinService.getWagon(id);
		return Response.ok(wagons).build();
	}
	
	@GET
	@Path("/guess/{guess}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWagonsForTrain(@PathParam("guess") final String guess){
		final List<Trein> treinen = treinService.guessTrainBrand(guess);
		return Response.ok(treinen).build();
	}

}
