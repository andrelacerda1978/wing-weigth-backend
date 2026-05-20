package br.com.wingweight.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import lombok.*;
@Entity @Table(name="users") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @NotBlank private String name; @Email @Column(unique=true,nullable=false) private String email; @NotBlank private String password; @Enumerated(EnumType.STRING) private Role role=Role.USUARIO; private boolean active=true; }
