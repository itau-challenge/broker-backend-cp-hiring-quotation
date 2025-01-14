package br.com.hpsolutions.domain.gateway;

import br.com.hpsolutions.domain.entity.EHiringQuotation;

public interface CreateHiringQuotationGateway {

    void send(final EHiringQuotation entity);
}
