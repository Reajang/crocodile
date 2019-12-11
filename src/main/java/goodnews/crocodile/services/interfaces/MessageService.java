package goodnews.crocodile.services.interfaces;

import goodnews.crocodile.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();
}
