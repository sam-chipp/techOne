package com.techOne.api.converter.controller;

import com.techOne.api.converter.models.ConverterRequest;
import com.techOne.api.converter.models.ConverterResponse;
import com.techOne.api.converter.service.ConverterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A simple Jersey API.
 */
@Controller
@CrossOrigin
@Path("/api")
public class ConverterController
{
    /**
     * Gets the word values for the provided number.
     * @param params The request.
     * @return The word values for the provided number.
     */
    @POST
    @Path("/convert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response converter(final ConverterRequest params)
    {
        /** The conversion service. */
        final ConverterService service = new ConverterService();

        /** The word equivalent of the given number. */
        final String responseString = service.convert(params.getNumber());

        return Response.status(Response.Status.OK)
                .entity(new ConverterResponse(responseString))
                .build();
    }
}


