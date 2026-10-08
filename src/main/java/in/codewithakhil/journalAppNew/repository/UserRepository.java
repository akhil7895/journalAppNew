package in.codewithakhil.journalAppNew.repository;

import in.codewithakhil.journalAppNew.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
}
