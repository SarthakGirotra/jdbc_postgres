package jdbc;

import dao.CityDao;
import models.City;

import java.sql.*;

public class CityJDBC implements CityDao {
    private final Connection connection;
    public CityJDBC(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(url, user, password );
    }

    @Override
    public City getCity(int cityId) throws SQLException {
        String sql = "select * from city where city_id = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1,cityId);
        ResultSet result = ps.executeQuery();
        result.next();
        City city = new City(
                result.getInt("city_id"), result.getString("city_name"), result.getInt("country_id"
        ));
        result.close();
        return city;
    }

    @Override
    public Boolean deleteCity(int cityId) throws SQLException {
        String sql = "delete from city where city_id = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1,cityId);
        ps.execute();
        return true;
    }

    @Override
    public City updateCity(int city_id, String cityName, int countryId) throws SQLException {
        return null;
    }

}
