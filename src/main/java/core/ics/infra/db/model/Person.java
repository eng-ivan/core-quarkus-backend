package core.ics.infra.db.model;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import java.time.LocalDateTime;

public class Person extends EntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "address")
    private String address;

    @Column(name = "token_key")
    private String tokenKey;

    @CreationTimestamp
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
}
