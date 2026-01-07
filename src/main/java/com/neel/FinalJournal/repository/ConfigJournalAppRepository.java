package com.neel.FinalJournal.repository;

import com.neel.FinalJournal.entity.ConfigJournalAppEntity;
import com.neel.FinalJournal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}
