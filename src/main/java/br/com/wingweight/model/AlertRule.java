package br.com.wingweight.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double minWeightKg;
    private Double maxWeightKg;
    @ManyToOne(optional = false)
    private Flock flock;
    private boolean active = true;
}
