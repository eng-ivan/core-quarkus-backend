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
    Long id;

    @Column(name = "person_name")
    String personName;

    @Column(name = "cpf")
    String cpf;

    @Column(name = "address")
    String address;

    @Column(name = "token_key")
    String tokenKey;

    @CreationTimestamp
    @Column(name = "registration_date")
    LocalDateTime registrationDate;
}
