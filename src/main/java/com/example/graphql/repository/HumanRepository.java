package com.example.graphql.repository;

import com.example.graphql.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<HumanEntity, Long> {
    HumanEntity findByAgeAndNameAndHeight(Integer age, String name, Integer height);

}
