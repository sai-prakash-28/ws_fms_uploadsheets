package com.cognizant.FeedBackSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognizant.FeedBackSystem.entity.OutreachEventSummary;

public interface OutreachEventSummaryRepository extends MongoRepository<OutreachEventSummary,Integer> {
}
