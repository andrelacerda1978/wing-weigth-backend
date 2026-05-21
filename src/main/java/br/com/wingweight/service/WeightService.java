package br.com.wingweight.service;

import br.com.wingweight.model.Alert;
import br.com.wingweight.model.WeightRecord;
import br.com.wingweight.repository.AlertRepository;
import br.com.wingweight.repository.WeightRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeightService {

 private final WeightRecordRepository weightRepo;
 private final AlertRepository alertRepo;
 private final GrowthCurveService curveService;

 public WeightRecord save(WeightRecord r) {

  WeightRecord saved = weightRepo.save(r);

  int ageDays = 28;

  double expected = curveService.expectedWeightByAge(ageDays);
  double min = curveService.minAcceptedWeight(ageDays);
  double max = curveService.maxAcceptedWeight(ageDays);

  boolean low = saved.getWeightKg() < min;
  boolean high = saved.getWeightKg() > max;

  if (low || high) {

   Alert alert = new Alert();

   alert.setWeightRecord(saved);

   alert.setMessage(
           "Peso fora da curva esperada. "
                   + "Peso atual: " + saved.getWeightKg() + " kg. "
                   + "Esperado: " + expected + " kg. "
                   + "Faixa aceita: " + min + " kg até " + max + " kg."
   );

   alertRepo.save(alert);
  }

  return saved;
 }

 public Double averageByFlock(Long flockId) {
  return weightRepo.findAll()
          .stream()
          .filter(w -> w.getFlock().getId().equals(flockId))
          .mapToDouble(WeightRecord::getWeightKg)
          .average()
          .orElse(0);
 }

 public List<WeightRecord> findAll() {
  return weightRepo.findAll();
 }
}