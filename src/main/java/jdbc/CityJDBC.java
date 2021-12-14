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
        if(result.next()){
        City city = new City(
                result.getInt("city_id"), result.getString("city_name"), result.getInt("country_id"
        ));
        result.close();
        return city;
        }
        return null;
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
    public City updateCity(int cityId, String cityName, int countryId) throws SQLException {
        String sql = "update city set city_name=?,country_id= ? where city_id= ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1,cityName);
        ps.setInt(2,countryId);
        ps.setInt(3,cityId);
        ps.execute();
        return getCity(cityId);
    }

    @Override
    public City createCity(int cityId, String cityName, int countryId) throws SQLException {
        String sql = "insert into city (city_id,city_name,country_id) values (?,?,?)";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1,cityId);
        ps.setString(2,cityName);
        ps.setInt(3,countryId);
        ps.execute();
        return getCity(cityId);
    }

}
