package com.example.Hospital.Management.System;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    HashMap<Integer, Patient> patientDb = new HashMap<>();

//    @PostMapping("/addPatientViaParameter")
//    public String addPatient(@RequestParam("patientId") Integer patientId, @RequestParam("name")String name,
//                             @RequestParam("age") Integer age, @RequestParam("disease") String disease)
//    {
//        return "Patient added successfully";
//    }


    // another way to add patient
    @PostMapping("/addPatientViaRequestBody")
    public String addPatientViaRequestBody(@RequestBody Patient patient)
    {
        int key = patient.getPatientId();
        patientDb.put(key,patient);

        return "Patient added via Requestbody";

    }

    @GetMapping("/getPatientInfoViaPathVariable/{patientId}")
    public Patient getPatientInfoViaPathVar(@PathVariable("patientId")Integer patientId)
    {
        Patient patient = patientDb.get(patientId);

        return patient;
    }

    // multiple variable
    @GetMapping("/getPatients/{age}/{disease}")
    public List<Patient> getPatientsMutliPathVar(@PathVariable("age")Integer age,@PathVariable("disease") String disease)
    {
        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDb.values())
        {
            if(p.getAge() > age && p.getDisease().equals(disease))
            {
                patients.add(p);
            }

        }

        return patients;
    }


   @GetMapping("/getPatientInfo")
    public  Patient getPatient(@RequestParam("patientId")Integer patientId)
   {

      Patient patient = patientDb.get(patientId);

      return patient;
   }

   @GetMapping("/getAllPatients")
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

   @PutMapping("/updateDisease")
   public String updateDisease(@RequestParam("patientId")Integer patientId, @RequestParam("disease")String disease)
   {
       if(patientDb.containsKey(patientId))
       {
           Patient patient = patientDb.get(patientId);

           patient.setDisease(disease);
           patientDb.put(patientId, patient);
           return "disease updated susscessfull";
       }
       else
       {
           return "patient not exists";
       }
   }
   @PutMapping("/updatePatientDetails")
    public String updatePatientDetails(@RequestBody Patient patient)
   {
      int key = patient.getPatientId();

      if(patientDb.containsKey(key))
      {
          patientDb.put(key,patient);
          return "patient updated successfully";
      }
      else {
          return "patient not exixts";
      }
   }

   @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientId") Integer patientId)
   {
       patientDb.remove(patientId);

       return "patient deleted";
   }


}
