package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;

/**
 * Created by Lorena on 7/15/2016.
 */
public class LocationServiceImpl implements LocationService {

    @Override
    public List<Location> findAllLocations() {
        LocationDao locationDao = new LocationDao();
        List<Location> locations = locationDao.getAllLocations();

        return locations;
    }
}
