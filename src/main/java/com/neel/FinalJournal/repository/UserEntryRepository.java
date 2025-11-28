package com.neel.FinalJournal.repository;

import com.neel.FinalJournal.entity.JournalEntry;
import com.neel.FinalJournal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);

    void deleteByusername(String username);
}
