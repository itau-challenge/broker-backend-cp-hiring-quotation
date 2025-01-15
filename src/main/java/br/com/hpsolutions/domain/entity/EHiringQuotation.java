package br.com.hpsolutions.domain.entity;

import java.util.Date;
import java.util.List;

public record EHiringQuotation(
        EPerson person,
        List<Long> intentionChangeIdList,
        List<Long> currentInsuranceIdList,
        List<Long> intentionInsuranceIdList,
        Date actualInsuranceExpireDate,
        Date intentionInsuranceExpireDate,
        Double intentionInsuranceAmount
) {
}

