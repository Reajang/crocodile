/*
package goodnews.crocodile.model;

import goodnews.crocodile.model.statusEnum.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CROC_USERS")
@Table(name = "croc_users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "MESSAGES")
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Message> messages;

    @Column(name = "USER_ROLE")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
}
*/
