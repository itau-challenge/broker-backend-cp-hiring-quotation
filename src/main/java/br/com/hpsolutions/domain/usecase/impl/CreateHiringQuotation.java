package br.com.hpsolutions.domain.usecase.impl;

import br.com.hpsolutions.domain.entity.EHiringQuotation;
import br.com.hpsolutions.domain.gateway.CreateHiringQuotationGateway;
import br.com.hpsolutions.domain.usecase.CreateHiringQuotationUseCase;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class CreateHiringQuotation implements CreateHiringQuotationUseCase {

    private final CreateHiringQuotationGateway gateway;

    public CreateHiringQuotation(CreateHiringQuotationGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(EHiringQuotation entity) {
        gateway.send(entity);
    }
}
