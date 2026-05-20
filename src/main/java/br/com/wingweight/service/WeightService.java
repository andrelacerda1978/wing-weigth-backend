package br.com.wingweight.service;
import br.com.wingweight.model.*; import br.com.wingweight.repository.*; import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import java.util.*;
@Service @RequiredArgsConstructor
public class WeightService {
 private final WeightRecordRepository weightRepo; private final AlertRuleRepository ruleRepo; private final AlertRepository alertRepo;
 public WeightRecord save(WeightRecord r){ WeightRecord saved=weightRepo.save(r); ruleRepo.findAll().stream().filter(x->x.isActive() && x.getFlock().getId().equals(r.getFlock().getId())).forEach(rule->{
  boolean low=rule.getMinWeightKg()!=null && r.getWeightKg()<rule.getMinWeightKg(); boolean high=rule.getMaxWeightKg()!=null && r.getWeightKg()>rule.getMaxWeightKg();
  if(low||high){ Alert a=new Alert(); a.setWeightRecord(saved); a.setMessage("Peso fora do limite: "+r.getWeightKg()+" kg"); alertRepo.save(a);} }); return saved; }
 public Double averageByFlock(Long flockId){ return weightRepo.findAll().stream().filter(w->w.getFlock().getId().equals(flockId)).mapToDouble(WeightRecord::getWeightKg).average().orElse(0); }
}
