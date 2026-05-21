package br.com.wingweight.service;

import br.com.wingweight.dto.DashboardDTO;
import br.com.wingweight.model.WeightRecord;
import br.com.wingweight.repository.AlertRepository;
import br.com.wingweight.repository.AviaryRepository;
import br.com.wingweight.repository.FlockRepository;
import br.com.wingweight.repository.WeightRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

 private final AviaryRepository aviary;
 private final FlockRepository flock;
 private final WeightRecordRepository weight;
 private final AlertRepository alert;

 public DashboardDTO summary() {

  double averageWeight = weight.findAll()
          .stream()
          .mapToDouble(WeightRecord::getWeightKg)
          .average()
          .orElse(0);

  double averageTemperature = weight.findAll()
          .stream()
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
}