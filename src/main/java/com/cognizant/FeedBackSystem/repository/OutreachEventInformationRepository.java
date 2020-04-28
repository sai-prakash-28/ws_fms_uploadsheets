package com.cognizant.FeedBackSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognizant.FeedBackSystem.entity.OutreachEventInformation;

public interface OutreachEventInformationRepository extends MongoRepository<OutreachEventInformation, Integer> {
}
