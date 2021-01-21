package com.enes.patient.web.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientSaveRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String diagnosis;

    @NotNull
    private String code;
}
