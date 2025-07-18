package com.example.demo3A.repository;

import com.example.demo3A.entity.Debts;
import com.example.demo3A.entity.KBL_Income;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<KBL_Income, Integer> {
	
	 @Query(
	            value = "SELECT SUM(Revenue) AS totalRevenue FROM KBL_Income",
	            nativeQuery = true
	    )
	    double getTotalRevenue();
	   
	
	


}
