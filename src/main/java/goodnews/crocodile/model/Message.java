package goodnews.crocodile.model;

import goodnews.crocodile.model.statusEnum.MessageType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "USERS_MESSAGES")
@Table(name = "messages_from_users")
@Data
@NoArgsConstructor
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MESSAGE_TEXT")
    private String text;

    //@Column(name = "OWNER")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User author;

    //Не знаю как задавать
    /*@Column(name = "MESSAGE_TYPE")
    @Enumerated(value = EnumType.STRING)
    private MessageType messageType;*/

    @Column
    @CreationTimestamp
    private Date creationDate;
}
