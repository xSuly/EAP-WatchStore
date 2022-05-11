package service;

import models.Smartwatch;
import models.User;
import exceptions.InvalidDataException;
import persistence.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository = new UserRepository();


    public void registerNewUser (User newUser) throws InvalidDataException
    {

        if(newUser.getUsername() == null || newUser.getUsername().trim().isEmpty()  )
        {
            throw new InvalidDataException("Invalid or taken username.");
        }
        if(newUser.getPassword() == null || newUser.getPassword().trim().isEmpty() || newUser.getPassword().length()<8 )
        {
            throw new InvalidDataException("Invalid or password does not have at least 8 characters.");
        }
        if(newUser.getEmail() == null || newUser.getEmail().trim().isEmpty()  )
        {
            throw new InvalidDataException("Invalid email.");
        }
        if(newUser.getCity() == null || newUser.getCity().trim().isEmpty()  )
        {
            throw new InvalidDataException("Invalid city.");
        }
        if(newUser.getAdress() == null || newUser.getAdress().trim().isEmpty()  )
        {
            throw new InvalidDataException("Invalid address.");
        }
        if(newUser.getCountry() == null || newUser.getCountry().trim().isEmpty()  )
        {
            throw new InvalidDataException("Invalid country.");
        }
        if(newUser.getAge() <= 0)
        {
            throw new InvalidDataException("Invalid age.");
        }
        userRepository.add(newUser);
    }

    public void getAllUsers(){
        for (int i = 0; i < userRepository.getSize(); i++)
        {
            System.out.println(userRepository.get(i));
        }
    }

    public User getUserApp(String username1){
        for (int i = 0; i < userRepository.getSize(); i++)
            if(userRepository.get(i).getUsername().equals(username1))
                return userRepository.get(i);
        return null;
    }

    public UserRepository sortAll(){
        return userRepository;
    }

    public List<User> getUsers(){
        return userRepository.getAll();
    }
}
