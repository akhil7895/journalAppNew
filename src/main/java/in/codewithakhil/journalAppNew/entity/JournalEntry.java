package in.codewithakhil.journalAppNew.entity;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "entries_journal")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    @NonNull
    private String Content;
    private LocalDateTime date;
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public String getContent() {
//        return Content;
//    }
//
//    public void setContent(String content) {
//        Content = content;
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}
