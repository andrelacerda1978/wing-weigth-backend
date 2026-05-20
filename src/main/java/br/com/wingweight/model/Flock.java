package br.com.wingweight.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import lombok.*; import java.time.LocalDate;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Flock { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @NotBlank private String code; private String lineage; private LocalDate startDate; private Integer initialBirds; @ManyToOne(optional=false) private Aviary aviary; private boolean active=true; }
