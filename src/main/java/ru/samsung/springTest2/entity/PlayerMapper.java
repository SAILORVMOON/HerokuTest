package ru.samsung.springTest2.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();
        player.setId(rs.getInt("id"));
        player.setName(rs.getString("name"));
        player.setPassword(rs.getString("password"));
        player.setLevel1(rs.getString("level1"));
        player.setLevel2(rs.getString("level2"));
        player.setLevel3(rs.getString("level3"));
        player.setLevel4(rs.getString("level4"));
        player.setLevel5(rs.getString("level5"));
        player.setLevel6(rs.getString("level6"));
        player.setLevel7(rs.getString("level7"));
        player.setLevel8(rs.getString("level8"));
        player.setLevel9(rs.getString("level9"));
        player.setLevel10(rs.getString("level10"));
        player.setPrice1(rs.getString("price1"));
        player.setPrice2(rs.getString("price2"));
        player.setPrice3(rs.getString("price3"));
        player.setPrice4(rs.getString("price4"));
        player.setPrice5(rs.getString("price5"));
        player.setPrice6(rs.getString("price6"));
        player.setPrice7(rs.getString("price7"));
        player.setPrice8(rs.getString("price8"));
        player.setPrice9(rs.getString("price9"));
        player.setPrice10(rs.getString("price10"));
        return player;
    }

}