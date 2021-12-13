package dao;

import models.City;

import java.sql.SQLException;
import java.util.Optional;

public interface CityDao {
    City getCity(int cityId) throws SQLException;

    Boolean deleteCity(int cityId) throws SQLException;

    City updateCity(int city_id, String cityName, int countryId) throws  SQLException;
}
