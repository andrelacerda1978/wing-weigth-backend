package br.com.wingweight.repository;
import br.com.wingweight.model.WeightRecord; import org.springframework.data.jpa.repository.JpaRepository;
public interface WeightRecordRepository extends JpaRepository<WeightRecord, Long> {}
