package fi.mediavustin.firststep.repository;


import fi.mediavustin.firststep.domain.City;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import java.util.List;

public interface CityRepository extends Repository<City, Long> {

    City findById(Long id);

    Page<City> findAll(Pageable pageable);

    City findByNameAndStateAllIgnoringCase(String name, String state);


    @Query("SELECT c FROM City c WHERE c.alias IS NOT NULL")
    List<City> findAliased();

    City save(City c);

    List<City> findAll();

    void deleteById(Long id);

    boolean exists(Long id);

    //List<City> findAll(List<Long> );
}


