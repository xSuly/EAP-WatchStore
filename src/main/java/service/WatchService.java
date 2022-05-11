package service;

import CSV.AuditLog;
import exceptions.InvalidDataException;
import models.Rolex;
import models.Smartwatch;
import models.Watch;
import persistence.SmartwatchRepository;
import persistence.WatchRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class WatchService {

    private WatchRepository watchRepository = new WatchRepository();

    public void addWatch(Watch watch) throws IOException {
        AuditLog.log("Adding watch: " + watch.getModel());
        watchRepository.save(watch);
    }
    public void getAllWatches(){
        watchRepository.getAll().forEach(System.out::println);
    }
    public void removeByModel(String model) throws IOException {
        AuditLog.log("Removing watch: " + model);
        List<Watch> watchList = watchRepository.getAll();

        for(Watch watch : watchList)
            if(watch.getModel().equals(model))
                watchRepository.delete(watch);

    }

    public void getRolexModel(){
        watchRepository.getAll().stream().sorted(Comparator.comparing(Watch::getModel)).forEach(System.out::println);
    }
    public void updateModelByModel(String modelOld, String modelNew)
    {
        List<Watch> watchList = watchRepository.getAll();
        int counter = 0;
        for(Watch watch : watchList){
            if(watch.getModel().equals(modelOld))
                watchRepository.update(counter, "models", modelNew);
        }
    }
    public void updateStrapByModel(String newStrap, String model)
    {
        List<Watch> watchList = watchRepository.getAll();
        int counter = 0;
        for(Watch watch : watchList){
            if(watch.getModel().equals(model))
                watchRepository.update(counter, "strap", newStrap);
        }
    }
    public List<Watch> getWatches(){
        return watchRepository.getAll();
    }

}
