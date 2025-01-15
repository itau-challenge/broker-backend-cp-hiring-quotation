package br.com.hpsolutions.app.dto.mapper;

import br.com.hpsolutions.app.dto.request.HiringQuotationRequest;
import br.com.hpsolutions.app.dto.request.PersonRequest;
import br.com.hpsolutions.domain.entity.EHiringQuotation;
import br.com.hpsolutions.domain.entity.EPerson;

import java.util.Objects;

public class HiringQuotationRequestMapper {

    private HiringQuotationRequestMapper() {
        throw new IllegalStateException("It's utility class");
    }

    public static EHiringQuotation toEntity(HiringQuotationRequest request) {
        return new EHiringQuotation(
                toEntity(request.getPerson()),
                request.getIntentionChangeIdList(),
                request.getCurrentInsuranceIdList(),
                request.getIntentionInsuranceIdList(),
                request.getActualInsuranceExpireDate(),
                request.getIntentionInsuranceExpireDate(),
                request.getIntentionInsuranceAmount()
        );
    }

    public static EPerson toEntity(PersonRequest request) {
        if(Objects.isNull(request)) {
            return null;
        }

        return new EPerson(request.getFirstName(),
                request.getLastName(),
                request.getBirthDate(),
                request.getJob());
    }
}
