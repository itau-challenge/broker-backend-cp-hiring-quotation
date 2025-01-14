package br.com.hpsolutions.app.presentetion;

import br.com.hpsolutions.app.dto.request.HiringQuotationRequest;
import jakarta.ws.rs.core.Response;

public interface HiringQuotationPresenter {

    Response create(final HiringQuotationRequest request);
}
