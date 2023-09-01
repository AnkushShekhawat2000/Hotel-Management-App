package com.example.Hospital.Management.System;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nurse")
public class NurseController {

    NurseService nurseService = new NurseService();
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse)
    {
        String ans =  nurseService.addNurse(nurse);

        return ans;
    }

    @PostMapping("/getList")
    public List<Nurse> getNurseGreaterThanAge(@RequestParam("age") Integer age)
    {
        List<Nurse> nurselist = nurseService.getNurseGreaterThanAge(age);
        return nurselist;
    }

   @GetMapping("/getQualification")
    public List<Nurse> getNursesQualification(@RequestParam("qulaification") String qualification) {
       List<Nurse> nurse = nurseService.getNursesQualification(qualification);

       return nurse;
   }


}
