package persistence;

import models.Rolex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class RolexRepository {
    private TreeSet<Rolex> rolexes = new TreeSet<>();

    public void save(Rolex rolex){
        rolexes.add(rolex);
    }

    public void delete(Rolex rolex){
        rolexes.remove(rolex);
    }

    public void update(int index, String attribute, String newValue) {
        List<Rolex> rolexList = new ArrayList<Rolex>(this.rolexes);


        switch(attribute) {

            case "models":
                rolexList.get(index).setModel(newValue);
                break;
            case "strap":
                rolexList.get(index).setStrap(newValue);
                break;
            default:
                System.out.println("Nothing to update");
                break;
        }
        this.rolexes = new TreeSet<Rolex>(rolexList);
    }

    public TreeSet<Rolex> getAll() {
        return rolexes;
    }

}
