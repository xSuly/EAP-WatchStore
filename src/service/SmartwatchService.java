package service;

import classes.Smartwatch;
import exceptions.InvalidDataException;
import persistence.SmartwatchRepository;


public class SmartwatchService {

    private SmartwatchRepository smartwatchRepository = new SmartwatchRepository();


    public void registerNewSmartwatch (Smartwatch newSmartwatch) throws InvalidDataException
    {

        if(newSmartwatch.getBrand() == null || newSmartwatch.getBrand().trim().isEmpty()  )
        {
            throw new InvalidDataException("Invalid brand.");
        }
        if(newSmartwatch.getModel() == null || newSmartwatch.getModel().trim().isEmpty() )
        {
            throw new InvalidDataException("Invalid model.");
        }
        if(newSmartwatch.getPrice() <=0 )
        {
            throw new InvalidDataException("Invalid price(cannot be lower than 0).");
        }
        if(newSmartwatch.getFabrication_date() <1960  )
        {
            throw new InvalidDataException("Invalid fabrication date.");
        }
        if(newSmartwatch.getMechanism() == null || newSmartwatch.getMechanism().trim().isEmpty() )
        {
            throw new InvalidDataException("Invalid mechanism.");
        }
        if(newSmartwatch.getStrap() == null || newSmartwatch.getStrap().trim().isEmpty() )
        {
            throw new InvalidDataException("Invalid strap type.");
        }
        if(newSmartwatch.getDisplay() <1 || newSmartwatch.getDisplay()>3)
        {
            throw new InvalidDataException("Invalid display inch.");
        }
        if(newSmartwatch.getRAM_Memory() <0.5)
        {
            throw new InvalidDataException("Invalid RAM Memory.");
        }
        if(newSmartwatch.getResolution() == null || newSmartwatch.getResolution().trim().isEmpty() )
        {
            throw new InvalidDataException("Invalid resolution.");
        }
        if(newSmartwatch.getProcessor_freq() < 0.5 )
        {
            throw new InvalidDataException("Invalid CPU Speed.");
        }
        if(newSmartwatch.getBattery_capacity() < 100 )
        {
            throw new InvalidDataException("Invalid battery capacity.");
        }
        if(newSmartwatch.getStorage_memory()<1)
        {
            throw new InvalidDataException("Invalid storage memory.");
        }
        smartwatchRepository.add(newSmartwatch);
    }

    public void getAllSmartwatch(){
        for (int i = 0; i < smartwatchRepository.getSize(); i++)
        {
            System.out.println(smartwatchRepository.get(i));
        }
    }

    public Smartwatch getSmartApp(String model1){
        for (int i = 0; i < smartwatchRepository.getSize(); i++)
            if(smartwatchRepository.get(i).getModel().equals(model1))
                return smartwatchRepository.get(i);
        return null;
    }

    public SmartwatchRepository sortAll(){
        return smartwatchRepository;
    }
}
