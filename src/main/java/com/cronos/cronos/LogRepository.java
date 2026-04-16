package com.cronos.cronos;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.*;


public interface LogRepository extends JpaRepository<Logs, Long> {
    List<Logs> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
    
    
}