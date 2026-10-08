package in.codewithakhil.journalAppNew.service;


import in.codewithakhil.journalAppNew.entity.JournalEntry;
import in.codewithakhil.journalAppNew.entity.User;
import in.codewithakhil.journalAppNew.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void save(JournalEntry journalEntry, String userName) {

        try {
            journalEntry.setDate(LocalDateTime.now());

            User user = userService.findByUserName(userName);

            JournalEntry saved = journalEntryRepository.save(journalEntry);

            user.getJournalEntries().add(saved);

            userService.createUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public boolean deleteById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.createUser(user);
         journalEntryRepository.deleteById(id);
         return true;
    }
}
