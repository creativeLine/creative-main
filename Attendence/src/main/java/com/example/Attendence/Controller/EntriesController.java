package com.example.Attendence.Controller;


import com.example.Attendence.Dtos.RequestDto.EntryDto;
import com.example.Attendence.Dtos.RequestDto.ExitDto;
import com.example.Attendence.Service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entries")
public class EntriesController {

    @Autowired
    private EntriesService entriesService;



    @PostMapping("/checkIn")
    public  ResponseEntity In(@RequestBody EntryDto request) throws Exception{
       try{
           entriesService.saveIn(request);
           return new ResponseEntity(HttpStatus.OK);
       }
       catch (Exception e){
           return   new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
       }
    }



    @PostMapping("/checkOut")
    public ResponseEntity out(@RequestBody ExitDto request)throws Exception{
        try{
            String response = entriesService.saveOut(request);
            return new ResponseEntity(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


}
