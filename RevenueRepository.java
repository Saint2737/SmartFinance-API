package com.example.demo3A.repository;

import com.example.demo3A.entity.KBL_Income;


import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends ReactiveCrudRepository<KBL_Income, Integer> {


}
