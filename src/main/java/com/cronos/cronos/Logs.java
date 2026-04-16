
package com.cronos.cronos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_logs")
public class Logs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "timestamp", updatable=false, insertable = false)
    private LocalDateTime timestamp;
    
    @Column(name = "student_id", nullable = false)
    private int student_id;
    
    @Column(name = "type", nullable = false, length = 3)
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int Student_id) {
        this.student_id = Student_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
