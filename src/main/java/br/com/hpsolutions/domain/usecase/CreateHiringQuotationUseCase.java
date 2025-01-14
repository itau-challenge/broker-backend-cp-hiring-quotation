package br.com.hpsolutions.domain.usecase;

import br.com.hpsolutions.domain.entity.EHiringQuotation;

public interface CreateHiringQuotationUseCase {

    void execute(final EHiringQuotation entity);
}
