package br.com.hpsolutions.domain.entity;

import java.util.Date;

public record EPerson(
        String firstName,
        String lastName,
        Date birthDate,
        String job
)  {
}
