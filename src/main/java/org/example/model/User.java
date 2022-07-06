package org.example.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User extends  Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String emailId;
    private String password;
    private  String name;
   private Boolean isActive= true;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;



}

