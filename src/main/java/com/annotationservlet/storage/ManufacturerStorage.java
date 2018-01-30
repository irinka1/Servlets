package com.annotationservlet.storage;

import com.annotationservlet.entity.Manufacturer;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface ManufacturerStorage {

    Manufacturer add(Manufacturer manufacturer) throws SQLException;
    void delete(Manufacturer manufacturer)throws SQLException;
    Manufacturer get(UUID manufacturerId) throws SQLException;
    List<Manufacturer> listAllManufacturer() throws SQLException;
    Manufacturer update(Manufacturer manufacturer) throws SQLException;
}
