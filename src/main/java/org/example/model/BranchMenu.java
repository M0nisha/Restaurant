package org.example.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@ToString
@AllArgsConstructor
@Getter
@Table
@Entity
@NoArgsConstructor
public class BranchMenu extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private Long branchId;
    @NotNull
    private Integer menuId;
}

