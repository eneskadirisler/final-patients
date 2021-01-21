package com.enes.patient.business;

import com.enes.patient.entity.Patient;
import com.enes.patient.exception.BusinessException;
import com.enes.patient.service.PatientService;
import com.enes.patient.web.request.GeneralRequest;
import com.enes.patient.web.request.PatientRemoveRequest;
import com.enes.patient.web.request.PatientSaveRequest;
import com.enes.patient.web.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientBusinessService {

    @Autowired
    private PatientService patientService;

    public PatientGeneralResponse getAll()  {
        PatientGeneralResponse response = new PatientGeneralResponse();
        try{
            List<PatientQueryResponse> list =patientService.getAllPatients().stream().map(i->{
                return new PatientQueryResponse(i);
            }).collect(Collectors.toList());
            response.setPatientList(list);
            response.setSize(list.size());
            response.setMessage("Success");
            return response;
        }catch (Exception e){
            throw new BusinessException("Failure");
        }
    }

    public PatientGeneralResponse findPatientsByLastName(GeneralRequest request)  {
        PatientGeneralResponse response = new PatientGeneralResponse();
        try{
            List<PatientQueryResponse> list =patientService.findPatientsByLastName(request.getRequestType())
                    .stream().map(i->{
                return new PatientQueryResponse(i);
            }).collect(Collectors.toList());
            response.setPatientList(list);
            response.setSize(list.size());
            response.setMessage("Success");
            return response;
        }catch (Exception e){
            throw new BusinessException("Failure");
        }

    }
    public PatientGeneralResponse findPatientsByCode(GeneralRequest request)  {
        PatientGeneralResponse response = new PatientGeneralResponse();
        try{
            List<PatientQueryResponse> list =patientService.findPatientsByCode(request.getRequestType())
                    .stream().map(i->{
                        return new PatientQueryResponse(i);
                    }).collect(Collectors.toList());
            response.setPatientList(list);
            response.setSize(list.size());
            response.setMessage("Success");
            return response;
        }catch (Exception e){
            throw new BusinessException("Failure");
        }
    }
    public PatientGeneralResponse findPatientsByFirstName(GeneralRequest request)  {
        PatientGeneralResponse response = new PatientGeneralResponse();
        try{
            List<PatientQueryResponse> list =patientService.findPatientsByFirstName(request.getRequestType())
                    .stream().map(i->{
                        return new PatientQueryResponse(i);
                    }).collect(Collectors.toList());
            response.setPatientList(list);
            response.setSize(list.size());
            response.setMessage("Success");
            return response;
        }catch (Exception e){
            throw new BusinessException("Failure");
        }
    }
    public PatientGeneralResponse findPatientsByDiagnosis(GeneralRequest request){
        PatientGeneralResponse response = new PatientGeneralResponse();
        try{
            List<PatientQueryResponse> list =patientService.findPatientsByDiagnosis(request.getRequestType())
                    .stream().map(i->{
                        return new PatientQueryResponse(i);
                    }).collect(Collectors.toList());
            response.setPatientList(list);
            response.setSize(list.size());
            response.setMessage("Success");
            return response;
        }catch (Exception e){
            throw new BusinessException("Failure");
        }
    }

    public PatientSaveResponse save(PatientSaveRequest request){
        PatientSaveResponse response = new PatientSaveResponse();
        try{
            Patient p = new Patient();
            p.setCode(request.getCode());
            p.setDiagnosis(request.getDiagnosis());
            p.setLastName(request.getLastName());
            p.setFirstName(request.getFirstName());
            p.setId(null);
            Patient persisted = patientService.save(p);
            response.setMessage("Success");
            response.setId(persisted.getId());
            return response;
        }catch (Exception e){
            throw new BusinessException("Failure");
        }
    }

    public PatientRemoveResponse remove(PatientRemoveRequest request) {
        PatientRemoveResponse response = new PatientRemoveResponse();
        try{
            Patient patient=patientService.findPatientsByCode(request.getCode()).get(0);
            patientService.remove(patient);
            response.setMessage("Success");
            return response;
        } catch (Exception e){
            throw new BusinessException("Faiilure");
        }
    }

}
