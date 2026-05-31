package br.com.wingweight.service;

import br.com.wingweight.dto.DashboardDTO;
import br.com.wingweight.model.WeightRecord;
import br.com.wingweight.repository.AlertRepository;
import br.com.wingweight.repository.AviaryRepository;
import br.com.wingweight.repository.FlockRepository;
import br.com.wingweight.repository.WeightRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

 private final AviaryRepository aviary;
 private final FlockRepository flock;
 private final WeightRecordRepository weight;
 private final AlertRepository alert;

 public DashboardDTO summary() {
  List<WeightRecord> records = weight.findAll();

  double averageWeight = records.stream()
          .mapToDouble(WeightRecord::getWeightKg)
          .average()
          .orElse(0);

  double averageTemperature = records.stream()
          .filter(w -> w.getTemperature() != null)
          .mapToDouble(WeightRecord::getTemperature)
          .average()
          .orElse(0);

  long alertsOpen = alert.findAll()
          .stream()
          .filter(a -> !a.isResolved())
          .count();

  return new DashboardDTO(
          aviary.count(),
          flock.count(),
          weight.count(),
          averageWeight,
          averageTemperature,
          alertsOpen
  );
 }

 public DashboardDTO summaryByAviary(Long aviaryId) {
  List<WeightRecord> records =
          weight.findByAviaryId(aviaryId);

  List<WeightRecord> recentRecords =
          records.stream()
                  .sorted((a, b) -> Long.compare(b.getId(), a.getId()))
                  .limit(50)
                  .toList();

  double averageWeight = recentRecords.stream()
          .mapToDouble(WeightRecord::getWeightKg)
          .average()
          .orElse(0);

  double averageTemperature = recentRecords.stream()
          .filter(w -> w.getTemperature() != null)
          .mapToDouble(WeightRecord::getTemperature)
          .average()
          .orElse(0);

  long alertsOpen = alert.findAll()
          .stream()
          .filter(a ->
                  !a.isResolved()
                          && a.getWeightRecord() != null
                          && a.getWeightRecord().getFlock() != null
                          && a.getWeightRecord().getFlock().getAviary() != null
                          && a.getWeightRecord().getFlock().getAviary().getId().equals(aviaryId)
          )
          .count();

  long flocksByAviary = flock.findAll()
          .stream()
          .filter(f ->
                  f.getAviary() != null
                          && f.getAviary().getId().equals(aviaryId)
          )
          .count();

  return new DashboardDTO(
          1,
          flocksByAviary,
          records.size(),
          averageWeight,
          averageTemperature,
          alertsOpen
  );
 }
}