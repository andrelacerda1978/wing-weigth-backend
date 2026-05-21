package br.com.wingweight.service;

import org.springframework.stereotype.Service;

@Service
public class GrowthCurveService {

    public double expectedWeightByAge(int ageDays) {
        if (ageDays <= 7) return 0.18;
        if (ageDays <= 14) return 0.45;
        if (ageDays <= 21) return 0.90;
        if (ageDays <= 28) return 1.45;
        if (ageDays <= 35) return 2.10;
        if (ageDays <= 42) return 2.80;
        if (ageDays <= 49) return 3.50;

        return 4.00;
    }

    public double minAcceptedWeight(int ageDays) {
        return expectedWeightByAge(ageDays) * 0.90;
    }

    public double maxAcceptedWeight(int ageDays) {
        return expectedWeightByAge(ageDays) * 1.10;
    }
}