package fi.mediavustin.firststep.service;

import fi.mediavustin.firststep.domain.City;
import java.util.List;

public interface CityService {
    City findOne(Long id);
    City create(City c);
    List<City> listAll();
    void delete(Long id);
    boolean exists(Long id);

    List<City> findAliased();

    List<City> findAll(List<Long> ids);
}
