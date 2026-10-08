package in.codewithakhil.journalAppNew.controller;


import in.codewithakhil.journalAppNew.entity.JournalEntry;
import in.codewithakhil.journalAppNew.entity.User;
import in.codewithakhil.journalAppNew.service.JournalEntryService;
import in.codewithakhil.journalAppNew.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userName}")
    public ResponseEntity<?> getAll(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()){
            return  new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<JournalEntry>> getOnlyJournalEntries(){
        List<JournalEntry> allJournal = journalEntryService.getAll();
        return new ResponseEntity<>(allJournal , HttpStatus.OK);
    }

    @PostMapping("/{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry,@PathVariable String userName){

        try{

            journalEntryService.save(journalEntry,userName);
            return new ResponseEntity<>(journalEntry,HttpStatus.CREATED);

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }





    }

    @GetMapping("/id/{id}")
    public ResponseEntity<JournalEntry> getById(@PathVariable ObjectId id){
        Optional<JournalEntry> journalEntry =  journalEntryService.getById(id);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get() , HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{userName}/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId id , @PathVariable String userName){

        journalEntryService.deleteById(id,userName);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/{id}")
//    public JournalEntry updateById(@PathVariable ObjectId id , @RequestBody JournalEntry newEntry){
//        JournalEntry old = journalEntryService.getById(id).orElse(null);
//        if(old != null){
//            old.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : old.getContent());
//            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
//        }
//        journalEntryService.save(old, user);
//        return old;
//    }
}
