package br.com.hpsolutions.infra.provider;

import br.com.hpsolutions.commons.PayloadMapper;
import br.com.hpsolutions.domain.entity.EHiringQuotation;
import br.com.hpsolutions.domain.gateway.CreateHiringQuotationGateway;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;


@Singleton
public class KafkaSendHiringQuotation implements CreateHiringQuotationGateway {

    private final Emitter<String> emitter;

    public KafkaSendHiringQuotation(@Channel("send-hiring-quotation") Emitter<String> emitter) {
        this.emitter = emitter;
    }

    @Override
    public void send(EHiringQuotation entity) {
        try {
            emitter.send(PayloadMapper.convertToString(entity));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
