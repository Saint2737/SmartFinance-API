package com.example.demo3.repository;

import com.example.demo3.entity.KBL_Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<KBL_Income, Integer> {


}
