/*
package goodnews.crocodile.model;

import goodnews.crocodile.model.statusEnum.MessageType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "USERS_MESSAGES")
@Table(name = "messages_from_users")
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MESSAGE_TEXT")
    private String text;

    @Column(name = "OWNER")
    private User author;

    @Column(name = "MESSAGE_TYPE")
    @Enumerated(value = EnumType.STRING)
    private MessageType messageType;
}
*/
