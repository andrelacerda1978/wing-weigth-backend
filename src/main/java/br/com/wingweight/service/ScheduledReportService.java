package br.com.wingweight.service;

import br.com.wingweight.model.Aviary;
import br.com.wingweight.repository.AviaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledReportService {

    private final ReportService reportService;
    private final AviaryRepository aviaryRepository;

    @Scheduled(cron = "0 59 23 * * *")
    public void generateDailyReports() {
        try {
            Path folder = Path.of("reports");
            Files.createDirectories(folder);

            List<Aviary> aviaries = aviaryRepository.findAll();

            for (Aviary aviary : aviaries) {
                byte[] pdf = reportService.generateDailyReport(aviary.getId());

                Path filePath = folder.resolve(
                        "relatorio-aviario-" + aviary.getId() + ".pdf"
                );

                Files.write(filePath, pdf);

                System.out.println("PDF gerado: " + filePath + " - " + pdf.length + " bytes");
            }

        } catch (Exception e) {
            System.out.println("Erro ao gerar PDFs automáticos: " + e.getMessage());
        }
    }
}