package com.example.Attendence.Repository;

import com.example.Attendence.Models.Entries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntriesRepository extends JpaRepository<Entries,Integer> {

    Optional<Entries> findByEntriesIdAndEmpCode(Integer entriesId, String empCode);
}
