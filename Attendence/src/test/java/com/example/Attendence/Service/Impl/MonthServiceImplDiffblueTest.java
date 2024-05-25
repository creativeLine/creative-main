package com.example.Attendence.Service.Impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Attendence.Dtos.RequestDto.MonthDto;
import com.example.Attendence.Exception.notPresent;
import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Repository.AttendanceRepository;
import com.example.Attendence.Repository.MonthRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MonthServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MonthServiceImplDiffblueTest {
    @MockBean
    private AttendanceRepository attendanceRepository;

    @MockBean
    private MonthRepository monthRepository;

    @Autowired
    private MonthServiceImpl monthServiceImpl;

    /**
     * Method under test: {@link MonthServiceImpl#save(MonthDto)}
     */
    @Test
    void testSave() throws Exception {
        // Arrange
        Optional<Attendance> emptyResult = Optional.empty();
        when(attendanceRepository.findByEmpCode(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(notPresent.class, () -> monthServiceImpl.save(new MonthDto("Emp Code", "Month Name")));
        verify(attendanceRepository).findByEmpCode(eq("Emp Code"));
    }
}
