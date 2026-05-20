package br.com.wingweight.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import lombok.*; import java.time.LocalDateTime;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class WeightRecord { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @NotNull @DecimalMin("0.001") private Double weightKg; private Double temperature; private Double humidity; private LocalDateTime measuredAt=LocalDateTime.now(); @ManyToOne(optional=false) private Flock flock; @ManyToOne private ScaleDevice device; }
