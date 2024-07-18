package com.ukgG3.Application.repository;

import com.ukgG3.Application.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Optional<Application> findByApplicationId(Long app_id);
    List<Application> findByEmployeeId(Long employee_id);
}

