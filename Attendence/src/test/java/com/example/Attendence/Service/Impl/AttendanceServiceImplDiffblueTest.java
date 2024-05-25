package com.example.Attendence.Service.Impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Attendence.Exception.notPresent;
import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Repository.AttendanceRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AttendanceServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AttendanceServiceImplDiffblueTest {
    @MockBean
    private AttendanceRepository attendanceRepository;

    @Autowired
    private AttendanceServiceImpl attendanceServiceImpl;

    /**
     * Method under test: {@link AttendanceServiceImpl#generateAttendance(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateAttendance() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.client.RestTemplate.getForObject(String, java.lang.Class, Object[])" because "this.restTemplate" is null
        //       at com.example.Attendence.Service.Impl.AttendanceServiceImpl.generateAttendance(AttendanceServiceImpl.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        attendanceServiceImpl.generateAttendance("Emp Code");
    }

    /**
     * Method under test: {@link AttendanceServiceImpl#getAttendance(String)}
     */
    @Test
    void testGetAttendance() throws Exception {
        // Arrange
        Attendance attendance = new Attendance();
        attendance.setAttendId(1);
        attendance.setEmpCode("Emp Code");
        attendance.setMonthList(new ArrayList<>());
        Optional<Attendance> ofResult = Optional.of(attendance);
        when(attendanceRepository.findByEmpCode(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        Attendance actualAttendance = attendanceServiceImpl.getAttendance("Emp Code");

        // Assert
        verify(attendanceRepository).findByEmpCode(eq("Emp Code"));
        assertSame(attendance, actualAttendance);
    }

    /**
     * Method under test: {@link AttendanceServiceImpl#getAttendance(String)}
     */
    @Test
    void testGetAttendance2() throws Exception {
        // Arrange
        Optional<Attendance> emptyResult = Optional.empty();
        when(attendanceRepository.findByEmpCode(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(notPresent.class, () -> attendanceServiceImpl.getAttendance("Emp Code"));
        verify(attendanceRepository).findByEmpCode(eq("Emp Code"));
    }

    /**
     * Method under test: {@link AttendanceServiceImpl#getAttendance(String)}
     */
    @Test
    void testGetAttendance3() throws Exception {
        // Arrange
        when(attendanceRepository.findByEmpCode(Mockito.<String>any())).thenThrow(new RuntimeException("Invalid"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> attendanceServiceImpl.getAttendance("Emp Code"));
        verify(attendanceRepository).findByEmpCode(eq("Emp Code"));
    }
}
