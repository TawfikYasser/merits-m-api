package com.merits.m.merits.dao;

import com.merits.m.merits.Model.Hadith;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository("DB")
public class HadithDAL implements IHadith{

    @Override
    public List<Hadith> getAllHadith() {
        ResultSet resultSet = null;
        List<Hadith> hadithList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/merits?useSSL=false";
            String userDB = "root";
            String passwordDB = "troot";
            Connection connection = null;
            Statement statement = null;
            String query = "";
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            statement = connection.createStatement();
            query = "SELECT * FROM hadith;";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                hadithList.add(new Hadith(resultSet.getString("hadith_text")));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hadithList;
    }
}
