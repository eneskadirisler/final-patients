package com.enes.patient.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PatientGeneralResponse extends GeneralResponse {

    private List<PatientQueryResponse> patientList;
    private int size;
}
