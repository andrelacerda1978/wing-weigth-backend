package br.com.wingweight.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import lombok.*; import java.time.LocalDateTime;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ScaleDevice { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @NotBlank @Column(unique=true) private String serialNumber; private String description; @ManyToOne private Aviary aviary; private LocalDateTime lastSync; private boolean active=true; }
