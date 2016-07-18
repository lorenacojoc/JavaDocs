package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.domain.Location;
import ro.teamnet.zth.appl.service.JobService;
import ro.teamnet.zth.appl.service.LocationService;
import ro.teamnet.zth.appl.service.LocationServiceImpl;

import java.util.List;

/**
 * Created by Lorena on 7/15/2016.
 */

@MyController(urlPath = "/locations")
public class LocationController {

    @MyRequestMethod(urlPath = "/all")
    public List<Location> getAllLocations(){

        LocationService locationService = new LocationServiceImpl();
        List<Location> locationList = locationService.findAllLocations();
        return locationList;

    };

    @MyRequestMethod(urlPath = "/one")
    public String getOneLocation(){
        return "OneLocation";
    };
}
