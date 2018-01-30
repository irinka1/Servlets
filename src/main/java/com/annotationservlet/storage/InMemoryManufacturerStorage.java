package com.annotationservlet.storage;
import com.annotationservlet.entity.Manufacturer;
import java.util.*;

public class InMemoryManufacturerStorage implements  ManufacturerStorage{

    private long manufacturerId;

    private Map<UUID, Manufacturer> manufacturers = new HashMap<UUID, Manufacturer>();

    public Manufacturer add(Manufacturer manufacturer) {
        UUID uuid = UUID.randomUUID();
        manufacturer.setId(uuid);
        manufacturers.put(manufacturer.getId(), manufacturer);
        return manufacturer;
    }

    public void delete(Manufacturer manufacturer) {
        manufacturers.remove(manufacturer.getId());
    }

    public Manufacturer get(UUID manufacturerId) {
        return manufacturers.get(manufacturerId);
    }

    public List<Manufacturer> listAllManufacturer() {
        List<Manufacturer> result = new ArrayList<Manufacturer>();
        for(Manufacturer manufacturer : manufacturers.values()) {
            result.add(manufacturer);
        }
        return result;
    }

    public Manufacturer update(Manufacturer manufacturer) {
        Manufacturer original = manufacturers.get(manufacturer.getId());
        original.setName(manufacturer.getName());
        return original;
    }
}
