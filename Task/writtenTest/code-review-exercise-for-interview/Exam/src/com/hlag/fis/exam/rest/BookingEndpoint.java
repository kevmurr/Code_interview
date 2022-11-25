package com.hlag.fis.exam.rest;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.hlag.fis.exam.model.Booking;
import com.hlag.fis.exam.model.BookingFactory;
import com.hlag.fis.exam.rest.model.BookingCreationComposite;
import com.hlag.fis.exam.service.BookingService;

@Path("v1/booking")
public class BookingEndpoint {

	private BookingService bs;
	private BookingFactory bf;

	public BookingEndpoint() {
		// default
	}

	@Inject
	public BookingEndpoint(BookingService bs, BookingFactory bf) {
		this.bs = bs;
		this.bf = bf;
	}

	@GET
	@Produces("applicatoin/json")
	@Path("{booking_id}")
	public Response getBookingById(@PathParam("booking_id") Integer id) {
		Optional<Booking> bookingOpt = bs.findById(id);
		if (bookingOpt.isPresent()) {
			return Response.status(200).entity(bookingOpt.get()).build();
		} else {
			return Response.status(404).entity("Booking not found").build();
		}
	}

	@GET
	@Path("{booking_id}/delete")
	public Response deleteBooking(@PathParam("booking_id") Integer id) {
		bs.deleteById(id);
		Response wsResponse = Response.status(200).build();
		return wsResponse;
	}

	@POST
	@Consumes("application/json")
	@Path("{booking_id}")
	public Response createBooking(@PathParam("booking_id") Integer id, BookingCreationComposite data) {
		Booking booking = bf.createBooking(data.getContainerIds(), data.getCargoIds());
		return Response.ok(booking).build();
	}

}
