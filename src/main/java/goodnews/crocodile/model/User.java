package goodnews.crocodile.model;

import goodnews.crocodile.model.statusEnum.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "CROC_USERS")
@Table(name = "croc_users")
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "MESSAGES")
    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    //Должно работать подругому. через доп таблицу с user_id и списком role_id
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> role = new HashSet<>();
}
