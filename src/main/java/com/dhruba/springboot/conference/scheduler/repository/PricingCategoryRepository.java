package com.dhruba.springboot.conference.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruba.springboot.conference.scheduler.models.PricingCategory;

public interface PricingCategoryRepository extends JpaRepository<PricingCategory, String> {

}
