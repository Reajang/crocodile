package goodnews.crocodile.services.implementations;

import goodnews.crocodile.model.Message;
import goodnews.crocodile.repository.MessageRepository;
import goodnews.crocodile.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
@Service
public class MessageServiceTemplate implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Override
    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    @Override
    public List<Message> allMessagesLastHour(Calendar calendar) {

        return repository.findAllByCreationDateGreaterThan(calendar);
    }

    @Override
    public void save(Message message) {
        repository.save(message);
    }
}
