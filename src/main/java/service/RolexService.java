package service;

import models.Rolex;
import persistence.RolexRepository;

import java.util.Comparator;
import java.util.TreeSet;

public class RolexService {
    private RolexRepository rolexRepository = new RolexRepository();

    public void addRolex(Rolex rolex)
    {
        rolexRepository.save(rolex);
    }
    public void getAllRolex(){
        rolexRepository.getAll().forEach(System.out::println);
    }
    public void removeByModel(String model){
        TreeSet<Rolex> rolexTreeSet = rolexRepository.getAll();

        for(Rolex rolex : rolexTreeSet)
            if(rolex.getModel().equals(model))
                rolexRepository.delete(rolex);
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
