package com.example.demo.services;

import com.example.demo.entity.University;
import com.example.demo.exception.UniversityNotFoundException;
import com.example.demo.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public boolean saveUniversityDetails(University university){
        if(university!=null){
            universityRepository.save(university);
            return true;
        }
        return false;
    }

    public boolean updateUniversityDetails(Integer id ,University university){
        Optional<University> existingUniversityOpt=universityRepository.findById(id);
        if(existingUniversityOpt.isPresent()){
            University existingUniversity=existingUniversityOpt.get();
            existingUniversity.setUniversityName(existingUniversity.getUniversityName());
            existingUniversity.setLocation(university.getLocation());
            existingUniversity.setUniversityEmail(university.getUniversityEmail());
            existingUniversity.setUniversityPassword(university.getUniversityPassword());
            existingUniversity.setEstablishedYear(university.getEstablishedYear());
            universityRepository.save(existingUniversity);
            return true;
        }
        return false;
    }

    public boolean deleteUniversityById(Integer id)
    {
        Optional<University> existingUniversityOpt=universityRepository.findById(id);
        if(existingUniversityOpt.isPresent())
        {
            universityRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<University> getUniversityDetails(){
        List<University> list =universityRepository.findAll();
        if(list.isEmpty())
        {
            throw  new UniversityNotFoundException("University record not available");
        }
        return list;
    }

    public University getUniversityById(Integer id ){
        Optional<University> existingUniversityOpt=universityRepository.findById(id);
        if(existingUniversityOpt.isPresent())
        {
            return existingUniversityOpt.get();
        }
        else {
            throw new UniversityNotFoundException("University record not available for the id : " + id);
        }
    }
}
