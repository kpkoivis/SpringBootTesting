package fi.mediavustin.firststep.controller;

import fi.mediavustin.firststep.domain.City;
import fi.mediavustin.firststep.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("city")
public class CityController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CityService cities;

    @RequestMapping("test")
    public String test() {
        log.info("Test");
        return "OK";
    }

    @RequestMapping("city")
    public City getCity(@RequestParam("id") long id) {
        log.info("Get city");
        return cities.findOne(id);
    }

    @RequestMapping("cities")
    public List<City> getCities(@RequestParam("ids") List<Long> ids) {
        log.info("Get users");
        return cities.findAll(ids);
    }

    @RequestMapping("aliased")
    public List<City> getAliasedUsers() {
        log.info("Get aliased users");
        return cities.findAliased();
    }


    @RequestMapping(method = RequestMethod.GET, value = "model")
    public ModelAndView getCreateForm() {
        log.info("ModelAndView");


        Map map = new HashMap();

        City city = new City("a", "b", "c");

        map.put("foo", "foo value");
        map.put("city", city);

        return new ModelAndView("/test", map);
    }
}

