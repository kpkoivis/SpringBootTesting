package fi.mediavustin.firststep.repository;

import fi.mediavustin.firststep.domain.Message;
import org.springframework.data.repository.Repository;

public interface MessageRepository extends Repository<Message, Long> {

    Iterable<Message> findAll();

    Message save(Message message);

    Message findOne(Long id);

}


