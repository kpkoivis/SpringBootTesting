package fi.mediavustin.firststep.service;

import fi.mediavustin.firststep.domain.City;
import fi.mediavustin.firststep.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kris on 7/2/14.
 */

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public City findOne(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    @Transactional
    public City create(City c) {
        return cityRepository.save(c);
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> listAll() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(Long id) {
        return cityRepository.exists(id);
    }

    @Override
    public List<City> findAliased() {
        return cityRepository.findAliased();
    }

    @Override
    public List<City> findAll(List<Long> ids) {
        //return cityRepository.findAll(ids);
        return null;
    }
}
