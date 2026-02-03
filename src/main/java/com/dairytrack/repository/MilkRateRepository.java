package com.dairytrack.repository;

import com.dairytrack.model.MilkRate;
import com.dairytrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MilkRateRepository extends JpaRepository<MilkRate,Long> {
    MilkRate findByUser(User user);
    @Query(value = "select price_per_fat from milk_rate where user_id =:userId",nativeQuery = true)
    public Double getMilkRateByUser(@Param("userId") Long userId);
}
