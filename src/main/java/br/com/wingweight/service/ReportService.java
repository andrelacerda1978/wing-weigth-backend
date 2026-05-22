package br.com.wingweight.service;

import br.com.wingweight.model.Aviary;
import br.com.wingweight.model.WeightRecord;
import br.com.wingweight.repository.AviaryRepository;
import br.com.wingweight.repository.WeightRecordRepository;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final AviaryRepository aviaryRepository;
    private final WeightRecordRepository weightRecordRepository;

    public byte[] generateDailyReport(Long aviaryId) {
        try {
            Aviary aviary = aviaryRepository.findById(aviaryId)
                    .orElseThrow(() -> new RuntimeException("Aviário não encontrado"));

            List<WeightRecord> records =
                    weightRecordRepository.findByAviaryId(aviaryId);

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, output);

            document.open();

            Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Font textFont = new Font(Font.HELVETICA, 12);

            document.add(new Paragraph("Relatório Diário - Wing Weight", titleFont));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Aviário: " + aviary.getName(), textFont));
            document.add(new Paragraph("Localização: " + aviary.getLocation(), textFont));
            document.add(new Paragraph("Capacidade: " + aviary.getCapacity(), textFont));
            document.add(new Paragraph("Total de pesagens: " + records.size(), textFont));
            document.add(new Paragraph(" "));

            if (records.isEmpty()) {
                document.add(new Paragraph("Nenhuma pesagem encontrada para este aviário.", textFont));
            } else {
                DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                for (WeightRecord record : records) {
                    document.add(new Paragraph(
                            "Peso: " + record.getWeightKg() + " kg",
                            textFont
                    ));

                    document.add(new Paragraph(
                            "Temperatura: " + record.getTemperature() + " °C",
                            textFont
                    ));

                    document.add(new Paragraph(
                            "Umidade: " + record.getHumidity() + "%",
                            textFont
                    ));

                    document.add(new Paragraph(
                            "Data: " + (
                                    record.getMeasuredAt() != null
                                            ? record.getMeasuredAt().format(formatter)
                                            : "Sem data"
                            ),
                            textFont
                    ));

                    document.add(new Paragraph("------------------------------------------"));
                }
            }

            document.close();

            return output.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF: " + e.getMessage(), e);
        }
    }
}