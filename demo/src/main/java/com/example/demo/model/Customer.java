
package com.example.demo.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "customer", schema = "public")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long customer_id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String role;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column(name = "card_number")
    private String cardNumber;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Booking> bookings;
}
