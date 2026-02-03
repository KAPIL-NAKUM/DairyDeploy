package com.dairytrack.repository;

import com.dairytrack.model.MilkEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilkEntryRepository extends JpaRepository<MilkEntry,Long> {


}
