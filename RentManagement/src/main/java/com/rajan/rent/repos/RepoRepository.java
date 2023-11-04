package com.rajan.rent.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajan.rent.models.RentReceipt;

public interface RepoRepository extends JpaRepository<RentReceipt, Integer> {

}
