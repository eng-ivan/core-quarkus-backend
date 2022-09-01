package core.ics.infra.db.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "person_name", nullable = false)
    String personName;

    @Column(name = "cpf", nullable = false)
    String cpf;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "token_key", nullable = false)
    String tokenKey;

    @CreationTimestamp
    @Column(name = "registration_date", nullable = false)
    LocalDateTime registrationDate;
}
