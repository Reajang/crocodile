package goodnews.crocodile.repository;

import goodnews.crocodile.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByCreationDateGreaterThan(Date date);

}
