package com.example.Hospital.Management.System;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    HashMap<Integer, Patient> patientDb = new HashMap<>();

    @PostMapping("/addPatientViaParameter")
    public String addPatient(@RequestParam("patientId") Integer patientId, @RequestParam("name")String name,
                             @RequestParam("age") Integer age, @RequestParam("disease") String disease)
    {
        return "Patient added successfully";
    }


    // another way to add patient
    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient)
    {
        int key = patient.getPatientId();
        patientDb.put(key,patient);
        return "Patient added via Requestbody";
    }

   @GetMapping("/getPatientInfo")
    public  Patient getPatient(@RequestParam("patientId") Integer patientId)
   {
      Patient patient = patientDb.get(patientId);

      return patient;
   }

   @GetMapping("/git")
    public List<Patient> getAllPatients(){
       ArrayList<Patient> patients = new ArrayList<>();

       for(Patient p : patientDb.values()){
           patients.add(p);
       }

       return patients;
   }

   @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name") String name){
        for(Patient p : patientDb.values())
        {

            if(p.getName() == name)
            {
                return p;
            }
        }

        return null;
   }

   @GetMapping("/getPatientsListGreaterThanAge")
    public List<Patient> getPatientsGreaterThanAge(@RequestParam("age") Integer age){
         List<Patient> patients = new ArrayList<>();

         for(Patient p : patientDb.values()){
             if(p.getAge() > age)
             {
                 patients.add(p);
             }

         }

         return patients;
   }

}
