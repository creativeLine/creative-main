package com.example.Attendence.Service.Impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Attendence.Dtos.RequestDto.DayDto;
import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Models.Month;
import com.example.Attendence.Repository.MonthRepository;

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

@ContextConfiguration(classes = {DayServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DayServiceImplDiffblueTest {
    @Autowired
    private DayServiceImpl dayServiceImpl;

    @MockBean
    private MonthRepository monthRepository;

    /**
     * Method under test: {@link DayServiceImpl#save(DayDto)}
     */
    @Test
    void testSave() throws Exception {
        // Arrange
        Optional<Month> emptyResult = Optional.empty();
        when(monthRepository.findMonthByMonthNameAndMonthIdAndEmpCode(Mockito.<String>any(), Mockito.<Integer>any(),
                Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> dayServiceImpl.save(new DayDto()));
        verify(monthRepository).findMonthByMonthNameAndMonthIdAndEmpCode(isNull(), isNull(), isNull());
    }

}
