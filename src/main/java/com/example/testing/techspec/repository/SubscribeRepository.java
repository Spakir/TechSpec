package com.example.testing.techspec.repository;

import com.example.testing.techspec.dto.TopSubscriptionDto;
import com.example.testing.techspec.entities.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {

    @Query(value = """
            SELECT service_type AS serviceType, COUNT(*) AS count 
            FROM subscribes 
            GROUP BY service_type 
            ORDER BY count DESC 
            LIMIT 3
            """, nativeQuery = true)
    List<TopSubscriptionDto> findTopSubscriptions();

    List<Subscribe> findByUserId(Long userId);

    Optional<Subscribe> findByIdAndUserId(Long subscriptionId, Long userId);
}
