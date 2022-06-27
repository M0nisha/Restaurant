package org.example.model;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Getter
@Table
@Entity
public  class BranchMenu
{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer branchId;
   private Integer menuId;
   @LastModifiedBy
   @Column(columnDefinition = "bigint default 1")
   private LocalDateTime UpdatedAt;
   @CreatedBy
   @Column(columnDefinition = "bigint default 1", updatable = false)
   private LocalDateTime createdBy;

}
