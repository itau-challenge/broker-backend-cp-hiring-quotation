package br.com.hpsolutions.app.dto.request;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
public class HiringQuotationRequest {

    private PersonRequest person;
    private List<Long> intentionChangeIdList;
    private List<Long> currentInsuranceIdList;
    private List<Long> intentionInsuranceIdList;
    private Date actualInsuranceExpireDate;
    private Date intentionInsuranceExpireDate;
    private Double intentionInsuranceAmount;
}

