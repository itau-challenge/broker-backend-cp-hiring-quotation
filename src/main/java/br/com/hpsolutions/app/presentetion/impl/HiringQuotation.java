package br.com.hpsolutions.app.presentetion.impl;

import br.com.hpsolutions.app.dto.mapper.HiringQuotationRequestMapper;
import br.com.hpsolutions.app.dto.request.HiringQuotationRequest;
import br.com.hpsolutions.app.presentetion.HiringQuotationPresenter;
import br.com.hpsolutions.domain.usecase.CreateHiringQuotationUseCase;
import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Response;

@Singleton
public class HiringQuotation implements HiringQuotationPresenter {

    private final CreateHiringQuotationUseCase useCase;

    public HiringQuotation(CreateHiringQuotationUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Response create(HiringQuotationRequest request) {
        useCase.execute(HiringQuotationRequestMapper.toEntity(request));
        return Response.ok().entity("Created successfully.").build();
    }
}
