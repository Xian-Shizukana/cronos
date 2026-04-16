package com.cronos.cronos;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StudentRepository extends JpaRepository<Students, Long> {
    // Use the IN clause to find students by IDs
    @Query("SELECT s FROM Students s WHERE s.id IN :ids")
    List<Students> findByIds(@Param("ids") List<Integer> ids);
}
