package br.com.wingweight.dto;

public record DashboardDTO(
        long aviaries,
        long flocks,
        long records,
        double averageWeight,
        double averageTemperature,
        long alertsOpen
) {}