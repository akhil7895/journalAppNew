//package in.codewithakhil.journalAppNew.controller;
//
//
//import in.codewithakhil.journalAppNew.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//
//    private Map<Long, JournalEntry> hm = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(hm.values());
//    }
//
//    @PostMapping
//    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry){
//        hm.put(journalEntry.getId() , journalEntry);
//        return journalEntry;
//    }
//
//    @GetMapping("/{id}")
//    public JournalEntry getById(@PathVariable Long id){
//        return hm.get(id);
//    }
//    @DeleteMapping("/{id}")
//    public JournalEntry deleteById(@PathVariable Long id){
//        return hm.remove(id);
//    }
//
//    @PutMapping("/{id}")
//    public JournalEntry updateById(@PathVariable Long id , @RequestBody JournalEntry journalEntry){
//        return hm.put(id,journalEntry);
//    }
//}
