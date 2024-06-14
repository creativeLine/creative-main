package com.example.Attendence.Service.Impl;

import com.example.Attendence.Dtos.RequestDto.EntryDto;
import com.example.Attendence.Dtos.RequestDto.ExitDto;
import com.example.Attendence.Enum.Status;
import com.example.Attendence.Models.Day;
import com.example.Attendence.Models.Entries;
import com.example.Attendence.Repository.DayRepository;
import com.example.Attendence.Repository.EntriesRepository;
import com.example.Attendence.Repository.MonthRepository;
import com.example.Attendence.Service.EntriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Optional;


@Service
public class EntriesServiceImpl implements EntriesService {

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private EntriesRepository entriesRepository;


    @Autowired
    private MonthRepository monthRepository;

    private final Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);


    @Override
    public void saveIn(EntryDto request) throws Exception {

        Entries In = new Entries();


        Optional<Day> optionalDay = dayRepository.findByMonthMonthNameAndDayIdAndEmpCode(request.getMonthName(),request.getDayId(),request.getEmpCode());
        logger.info(optionalDay.get()+"here is information");
        if(optionalDay.isEmpty()){
            throw new RuntimeException("Invalid");
        }

        //todo marked true in day table
        In.setTimeIn(request.getTimeIn());
        In.setEmpCode(request.getEmpCode());
        In.setEntryMarked(true);

        Day day = optionalDay.get();
        day.setStatus(Status.PP);
        In.setDay(day);

        logger.info(In+"here is information");

        entriesRepository.save(In);

    }

    @Override
    public String saveOut(ExitDto request) throws Exception {
        Optional<Entries> optionalEntries = entriesRepository.findByEntriesIdAndEmpCode(request.getEntriesId(),request.getEmpCode());

        Entries entries = optionalEntries.get();


        Optional<Day> optionalDay = dayRepository.findByDayIdAndEmpCode(request.getDayId(),request.getEmpCode());

        if(entries.getEntryMarked()==false){
            throw new RuntimeException("already marked");
        }
        Day day = optionalDay.get();

        entries.setTimeOut(request.getTimeOut());
        entries.setDay(day);
        day.getEntries().add(entries);
        entries.setEntryMarked(false);

        Time timeIn = entries.getTimeIn();
        Time timeOut = entries.getTimeOut();

        // Convert java.sql.Time to LocalTime
        LocalTime startTime = timeIn.toLocalTime();
        LocalTime endTime = timeOut.toLocalTime();

        // Calculate the duration between the two times
        Duration duration = Duration.between(startTime, endTime);

        // Get the duration in hours, minutes, and seconds
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        Double workingInMonth = day.getMonth().getTotalWorkingHourInMonth();
        workingInMonth=+((hours*60)+minutes)*1.0;
       day.getMonth().setTotalWorkingHourInMonth(workingInMonth/60.0);
        monthRepository.save(day.getMonth());


        // Output the time differences
//        System.out.println("Difference in hours: " + hours);
//        System.out.println("Difference in minutes: " + minutes);
//        System.out.println("Difference in seconds: " + seconds);
        day.setTotalWorkingHourInDay(hours+"hour : "+ minutes+"minute");


        dayRepository.save(day);


        return "success";
    }
}