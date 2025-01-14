package br.com.hpsolutions.app.dto.request;

import lombok.*;

import java.util.Date;

@Getter
public class PersonRequest {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private String job;
}
