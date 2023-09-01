package com.example.Hospital.Management.System;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();

    public String addNurse(Nurse nurse)
    {
        // we should write some logic

        // validations

        if(nurse.getNurseId()<0)
        {
            return "Enter a valid nurseId";

        }

        if(nurse.getName().equals(null))
        {
            return "Name should not be null";
        }


         String ans = nurseRepository.addBNurse(nurse);

         return ans;
    }

    public List<Nurse> getNurseGreaterThanAge(Integer age) {

        // calling all the nurse from the database
        List<Nurse> nurses = nurseRepository.getAllNurses();

        // now i am writing the logic according to requirement

       List<Nurse> finalList = new ArrayList<>();
       for(Nurse nurse : nurses)
       {
           if(nurse.getAge() > age)
           {
               finalList.add(nurse);
           }
       }

       return finalList;
    }

    public List<Nurse> getNursesQualification(String qualification) {
     // reuse previous fun
      List<Nurse> nurseList =  nurseRepository.getAllNurses();

      // logic filter based on qulifcation
        List<Nurse> nurses = new ArrayList<>();
        for(Nurse nurse : nurseList)
        {
            if(nurse.getQulaification().equals(qualification))
            {
                nurses.add(nurse);
            }
        }
    return nurses;
    }
}
