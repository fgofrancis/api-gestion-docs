package org.fedcoop.domain;
import jakarta.persistence.*; import lombok.*;
/** Tenant: la Federación (FEDERATION) o una cooperativa asociada (COOPERATIVE). */
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Organization {
  public enum Kind { FEDERATION, COOPERATIVE }
  @Id @GeneratedValue Long id;
  @Column(nullable=false) String name;
  @Enumerated(EnumType.STRING) Kind kind;
}
