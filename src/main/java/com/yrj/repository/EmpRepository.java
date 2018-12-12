package com.yrj.repository;

import com.yrj.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp,Integer> {
}
