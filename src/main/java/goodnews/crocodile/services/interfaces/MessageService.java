package goodnews.crocodile.services.interfaces;

import goodnews.crocodile.model.Message;

import java.util.Calendar;
import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();

    List<Message> allMessagesLastHour(Calendar calendar);

    void save(Message message);
}
