package com.example.Hospital.Management.System;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {
    HashMap<Integer, Nurse> nurseDb = new HashMap<>();
    public String addBNurse(Nurse nurse)
    {
          int key = nurse.getNurseId();
          nurseDb.put(key,nurse);

          return "Nurse added successfully";
    }

    public List<Nurse> getAllNurses() {

        List<Nurse> list = new ArrayList<>();
        for(Nurse s : nurseDb.values())
        {
            list.add(s);
        }

        return list;
    }
}
