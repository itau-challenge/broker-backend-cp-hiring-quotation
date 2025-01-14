package br.com.hpsolutions.app.rest;

import br.com.hpsolutions.app.dto.request.HiringQuotationRequest;
import br.com.hpsolutions.app.presentetion.HiringQuotationPresenter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Path("/v1/hiring-quotations")
public class HiringQuotationEntrypoint {

    private final HiringQuotationPresenter presenter;

    public HiringQuotationEntrypoint(HiringQuotationPresenter presenter) {
        this.presenter = presenter;
    }

    @POST
    public Response createHiringQuotation(HiringQuotationRequest request) {
        return Response.ok().entity(presenter.create(request)).build();
    }

    @POST
    @Path("/test")
    public String test(String request) {
        return request;
    }
}
