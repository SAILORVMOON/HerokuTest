package ru.samsung.springTest2.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.samsung.springTest2.entity.Person;
import ru.samsung.springTest2.repositories.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @RequestMapping(value = "/getperson", method = RequestMethod.GET)
    public Person getPerson(@RequestParam("id") int id){
        return repository.getPerson(id);
    }

    @RequestMapping(value = "/getpersons", method = RequestMethod.GET)
    public List<Person> getPersons(){
        return repository.getPersons();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public int deletePerson(@PathVariable int id){
        return repository.deletePerson(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT,
            consumes = "text/plain")
    public int createPerson(@RequestBody String param){
        Person person = new Person();
        try {
            JSONObject jsonObject = new JSONObject(param);
            person.setName(jsonObject.getString("name"));
        } catch (JSONException e){
            e.getStackTrace();
            System.out.println("Не удалось распарсить тело запроса");
            return 0;
        }
        return repository.createPerson(person);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            consumes = "text/plain")
    public int updatePerson(@RequestBody String param){
        Person person = new Person();
        try {
            JSONObject jsonObject = new JSONObject(param);
            person.setName(jsonObject.getString("name"));
            person.setId(jsonObject.getInt("id"));
        } catch (JSONException e){
            e.getStackTrace();
            System.out.println("Не удалось распарсить тело запроса");
            return 0;
        }
        return repository.updatePerson(person);
    }
}
