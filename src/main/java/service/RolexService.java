package service;

import CSV.AuditLog;
import models.Rolex;
import persistence.RolexRepository;

import java.io.IOException;
import java.util.Comparator;

import java.util.Iterator;
import java.util.TreeSet;

public class RolexService {
    private RolexRepository rolexRepository = new RolexRepository();

    public void addRolex(Rolex rolex) throws IOException {
        AuditLog.log("Adding Rolex watch: " + rolex.getModel());
        rolexRepository.save(rolex);
    }
    public void getAllRolex(){
        rolexRepository.getAll().forEach(System.out::println);
    }
    public void removeByModel(String model) throws IOException {
        AuditLog.log("Removing Rolex watch: " + model);
        TreeSet<Rolex> rolexTreeSet = rolexRepository.getAll();

        Iterator<Rolex> itr = rolexTreeSet.iterator();
        while (itr.hasNext())
        {
            Rolex rolex = itr.next();
            if(rolex.getModel().equals(model))
            {
                itr.remove();
            }
        }

    }

    public void getRolexModel(){
        rolexRepository.getAll().stream().sorted(Comparator.comparing(Rolex::getModel)).forEach(System.out::println);
    }
    public void updateModelByModel(String modelOld, String modelNew)
    {
        TreeSet<Rolex> rolexTreeSet = rolexRepository.getAll();
        int counter = 0;
        for(Rolex rolex : rolexTreeSet){
            if(rolex.getModel().equals(modelOld))
                rolexRepository.update(counter, "models", modelNew);
        }
    }
    public void updateStrapByModel(String newStrap, String model)
    {
        TreeSet<Rolex> rolexTreeSet = rolexRepository.getAll();
        int counter = 0;
        for(Rolex rolex : rolexTreeSet){
            if(rolex.getModel().equals(model))
                rolexRepository.update(counter, "strap", newStrap);
        }
    }
    public TreeSet<Rolex> getRolexes(){
        return rolexRepository.getAll();
    }
}
