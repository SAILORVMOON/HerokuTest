package ru.samsung.springTest2.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.samsung.springTest2.entity.Player;
import ru.samsung.springTest2.repositories.PlayerRepository;

@RestController
@RequestMapping("player")

public class PlayerController {
    @Autowired
    private PlayerRepository repository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Player getPlayer(@RequestParam("name, password") String name, String password){
        if(repository.getPerson(name, password).getName() == null){
            return repository.getPerson(name, password);
        }else{
            return null;
        }
    }
    @RequestMapping(value = "/pull", method = RequestMethod.PUT, consumes = "text/plain")
    public int createPlayer(@RequestBody String param){
        Player player = new Player();
        JSONObject jsonObject = new JSONObject(param);
        player.setName(jsonObject.getString("name"));
        player.setPassword(jsonObject.getString("password"));
        player.setLevel1(jsonObject.getString("level1"));
        player.setLevel2(jsonObject.getString("level2"));
        player.setLevel3(jsonObject.getString("level3"));
        player.setLevel4(jsonObject.getString("level4"));
        player.setLevel5(jsonObject.getString("level5"));
        player.setLevel6(jsonObject.getString("level6"));
        player.setLevel7(jsonObject.getString("level7"));
        player.setLevel8(jsonObject.getString("level8"));
        player.setLevel9(jsonObject.getString("level9"));
        player.setLevel10(jsonObject.getString("level10"));
        player.setPrice1(jsonObject.getString("price1"));
        player.setPrice2(jsonObject.getString("price2"));
        player.setPrice3(jsonObject.getString("price3"));
        player.setPrice4(jsonObject.getString("price4"));
        player.setPrice5(jsonObject.getString("price5"));
        player.setPrice6(jsonObject.getString("price6"));
        player.setPrice7(jsonObject.getString("price7"));
        player.setPrice8(jsonObject.getString("price8"));
        player.setPrice9(jsonObject.getString("price9"));
        player.setPrice10(jsonObject.getString("price10"));
        if (getPlayer(player.getName(), player.getPassword()).getName() != null){
            return repository.updatePerson(player);
        }else{
            return repository.createPlayer(player);
        }

    }
}
