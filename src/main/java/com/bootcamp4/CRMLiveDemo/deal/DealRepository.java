package com.bootcamp4.CRMLiveDemo.deal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal,Long> {
}
