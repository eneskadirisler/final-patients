package com.enes.patient.web.response;

import com.enes.patient.entity.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientQueryResponse {

    private String lastName;
    private String firstName;
    private String code;
    private String diagnosis;

    public PatientQueryResponse(Patient p) {
        this.lastName = p.getLastName();
        this.firstName = p.getFirstName();
        this.code = p.getCode();
        this.diagnosis = p.getDiagnosis();
    }

}
