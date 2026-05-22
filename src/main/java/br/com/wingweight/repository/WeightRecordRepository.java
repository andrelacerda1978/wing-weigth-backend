package br.com.wingweight.repository;
import br.com.wingweight.model.WeightRecord; import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface WeightRecordRepository
        extends JpaRepository<WeightRecord, Long> {

    @Query("""
        SELECT w
        FROM WeightRecord w
        JOIN w.flock f
        JOIN f.aviary a
        WHERE a.id = :aviaryId
    """)
    List<WeightRecord> findByAviaryId(
            @Param("aviaryId") Long aviaryId
    );
}