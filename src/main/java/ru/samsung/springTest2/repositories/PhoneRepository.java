package ru.samsung.springTest2.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.samsung.springTest2.entity.Person;
import ru.samsung.springTest2.entity.PersonMapper;
import ru.samsung.springTest2.entity.Phone;
import ru.samsung.springTest2.entity.PhoneMapper;

import java.util.List;

@Component
public class PhoneRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createPhone(Phone phone){
        return jdbcTemplate.update("insert into \"Phone\" (\"value\", \"id_person\") values(?, ?)",
                phone.getValue(), phone.getIdPerson());
    }

    public int deletePhone(int id){
        return jdbcTemplate.update("delete from \"Phone\" where \"id\"=?", id);
    }

    public Phone getPhone(int id){
        return jdbcTemplate.queryForObject("select * from \"Phone\" where \"id\"=?",
                new PhoneMapper(), id);
    }

    public List<Phone> getPhones(){
        return jdbcTemplate.query("select * from \"Phone\"",
                new PhoneMapper());
    }

    public int updatePhone(Phone phone){
        return jdbcTemplate.update("update \"Phone\" set \"value\" = ? where \"id\" = ?",
                phone.getValue(), phone.getId());
    }
}
