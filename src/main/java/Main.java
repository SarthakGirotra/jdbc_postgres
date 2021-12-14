import dao.CityDao;
import jdbc.CityJDBC;
import models.City;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5444/postgres";
        String user = "postgres";
        String password = "postgres";
        CityDao cityDao = new CityJDBC(url, user, password);
        //City city = cityDao.getCity(100);
        //Boolean res = cityDao.deleteCity(99);
        //City city = cityDao.updateCity(1,"new12",12);
        //City city = cityDao.createCity(99,"new",23);
        //System.out.println(city);
    }
}
