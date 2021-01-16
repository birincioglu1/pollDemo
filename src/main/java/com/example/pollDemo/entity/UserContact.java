package com.example.pollDemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_contact")

@NamedQueries({
        @NamedQuery(name="UserContact.findByValue",query ="FROM UserContact u WHERE u.value = :value" )
})
public class UserContact extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contact_id")
    private int id;

    private String type;

    @Column(unique = true)
    private String value;

    private Boolean isValid;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
