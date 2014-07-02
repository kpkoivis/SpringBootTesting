package fi.mediavustin.firststep.service;

import fi.mediavustin.firststep.domain.City;
import fi.mediavustin.firststep.domain.Message;

import java.util.List;

public interface MessageService {

    Iterable<Message> findAll();

    Message save(Message message);

    Message findMessage(Long id);
}
