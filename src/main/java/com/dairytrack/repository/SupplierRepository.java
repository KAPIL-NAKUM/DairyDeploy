package com.dairytrack.repository;

import com.dairytrack.model.Supplier;
import com.dairytrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    Optional<Supplier> findByEmail(String email);

    Optional<List<Supplier>> findByUser(User user);

    Long countByUser(User user);

    Optional<Supplier> findByIdAndUserId(Long supplierId, Long userId);



}
