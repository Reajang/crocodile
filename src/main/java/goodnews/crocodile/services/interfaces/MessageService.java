package goodnews.crocodile.services.interfaces;

import goodnews.crocodile.model.Message;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();

    List<Message> allMessagesLastHour(Date date);

    void save(Message message);
}
