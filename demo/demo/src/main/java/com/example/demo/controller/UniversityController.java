package com.example.demo.controller;

import com.example.demo.entity.University;
import com.example.demo.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @GetMapping("/test")
    public String test()
    {
        return "working perfectly";
    }

//    This api for save university details
    @PostMapping("/saveUniversity")
    public ResponseEntity<?> saveUniversityDetails(@RequestBody University university){
        System.out.println("inside Controller layer : "+university);

        if(university!=null)
        {
            boolean result=universityService.saveUniversityDetails(university);
            if(result) {
                return ResponseEntity.ok("saved successfully");
            }
            else{
                return ResponseEntity.ok("not saved successfully");
            }
        }
        return ResponseEntity.ok("Please provide valid data");
    }

//    this api for update University details
    @PutMapping("updateUniversity/{id}")
    public ResponseEntity<?> updateUniversityDetails(@PathVariable Integer id,@RequestBody University university){
        if(id!=null || university!=null){
            boolean result= universityService.updateUniversityDetails(id,university);
            if(result)
            {
                return ResponseEntity.ok("Updated successfully");
            }
            else {
                return ResponseEntity.ok("Not updated successfully");
            }
        }
        return ResponseEntity.ok("please provide valid data");
    }

//    This api for delete university by id
    @DeleteMapping("deleteUniversityById/{id}")
    public ResponseEntity<?> deleteUniversityById(@PathVariable Integer id){
        if(id!=null){
            boolean result=universityService.deleteUniversityById(id);
            if(result){
                return ResponseEntity.ok("Deleted successfully");
            }
            else{
                return ResponseEntity.ok("Not deleted successfully");
            }
        }
        throw new RuntimeException("please provide valid id");
    }

//    this api for get university details
    @GetMapping("/getUniversityDetails")
    public ResponseEntity<?> getUniversityDetails(){
        return ResponseEntity.ok(universityService.getUniversityDetails());
    }

    @GetMapping("/getUniversityById/{id}")
    public ResponseEntity<?> getUniversityById(@PathVariable Integer id )
    {
        if(id!=null){
            University university =universityService.getUniversityById(id);
            return ResponseEntity.ok(university);
        }
        throw  new RuntimeException("please provide valid id ");
    }
}

