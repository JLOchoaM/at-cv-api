package com.jlochoam.atcvapi.repository;

import com.jlochoam.atcvapi.model.cv.CV;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends MongoRepository<CV, String> {
}
