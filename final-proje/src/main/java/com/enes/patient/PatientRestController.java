package com.enes.patient;

import com.enes.patient.business.PatientBusinessService;
import com.enes.patient.exception.BusinessException;
import com.enes.patient.web.request.GeneralRequest;
import com.enes.patient.web.request.PatientRemoveRequest;
import com.enes.patient.web.request.PatientSaveRequest;
import com.enes.patient.web.response.GeneralResponse;
import com.enes.patient.web.response.PatientRemoveResponse;
import com.enes.patient.web.response.PatientSaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/patients")
public class PatientRestController {

    private final String  generalMediaType = MediaType.APPLICATION_JSON_VALUE;

    @Autowired
    private PatientBusinessService patientBusinessService;

    @GetMapping(value = "/all", produces = generalMediaType)
    public GeneralResponse getAll() {
        return patientBusinessService.getAll();
    }

    @PostMapping(value = "/patient-by-lastname", produces = generalMediaType
            ,consumes = generalMediaType)
    public GeneralResponse getPatientByLastName(@Valid @RequestBody GeneralRequest request){
        return patientBusinessService.findPatientsByLastName(request);
    }

    @PostMapping(value = "/patient-by-firstname", produces = generalMediaType
            ,consumes = generalMediaType)
    public GeneralResponse getPatientByFirstName(@Valid @RequestBody GeneralRequest request){
        return patientBusinessService.findPatientsByFirstName(request);
    }

    @PostMapping(value = "/patient-by-code", produces = generalMediaType
            ,consumes = generalMediaType)
    public GeneralResponse getPatientByCode(@Valid @RequestBody GeneralRequest request){
        return patientBusinessService.findPatientsByCode(request);
    }

    @PostMapping(value = "/patient-by-diagnosis", produces = generalMediaType
            ,consumes = generalMediaType)
    public GeneralResponse getPatientByDiagnosis(@Valid @RequestBody GeneralRequest request){
        return patientBusinessService.findPatientsByDiagnosis(request);
    }

    @PostMapping(value = "/save", produces = generalMediaType, consumes = generalMediaType)
    public PatientSaveResponse save(@Valid @RequestBody PatientSaveRequest request){
        return patientBusinessService.save(request);
    }

    @PostMapping(value = "/remove", produces = generalMediaType, consumes = generalMediaType)
    public PatientRemoveResponse remove(@Valid @RequestBody PatientRemoveRequest request) {
        return patientBusinessService.remove(request);
    }
}
