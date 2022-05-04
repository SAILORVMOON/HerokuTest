package ru.samsung.springTest2.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.samsung.springTest2.entity.Player;
import ru.samsung.springTest2.entity.PlayerMapper;

@Component
public class PlayerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createPlayer(Player player){
        return jdbcTemplate.update("insert into \"Players\" (\"name\", \"password\", \"level1\", \"level2\", \"level3\", " +
                "\"level4\", \"level5\", \"level6\", \"level7\", \"level8\", \"level9\", \"level10\", \"price1\", \"price2\", \"price3\", " +
                "\"price4\", \"price5\", \"price6\", \"price7\", \"price8\", \"price9\", \"price10\") values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", player.getName(), player.getPassword(), player.getLevel1(), player.getLevel2(), player.getLevel3(),
                player.getLevel4(), player.getLevel5(), player.getLevel6(), player.getLevel7(), player.getLevel8(), player.getLevel9(),
                player.getLevel10(), player.getPrice1(), player.getPrice2(), player.getPrice3(), player.getPrice4(), player.getPrice5(),
                player.getPrice6(), player.getPrice7(), player.getPrice8(), player.getPrice9(), player.getPrice10());
    }

    public int deletePlayer(String name, String password){
        return jdbcTemplate.update("delete from \"Players\" where \"name\"=?, \"password\"=?", name, password);
    }

    public Player getPerson(String name, String password){
        return jdbcTemplate.queryForObject("select * from \"Players\" where \"name\"=?, \"password\"= ?",
                new PlayerMapper(), name, password);
    }

//    public List<Person> getPersons(){
//        return jdbcTemplate.query("select * from \"Persons\"",
//                new PersonMapper());
//    }

    public int updatePerson(Player player){
        deletePlayer(player.getName(), player.getPassword());
        return createPlayer(player);
    }
}
