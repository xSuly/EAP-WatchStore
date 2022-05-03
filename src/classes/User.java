package classes;

public class User implements Comparable<User>{

    private static int user_id = 1;
    private String username;
    private String password;
    private String email;
    private int age;

    private String adress;
    private String city;
    private String country;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public User ()
    {
        user_id++;
    }

    public User(String username, String password, String email, int age, String adress, String city, String country) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.adress = adress;
        this.city = city;
        this.country = country;
    }

    public void addWatchUser(Order order, Watch watch)
    {
        if(AgeRestriction()==false)
        {
            order.addWatch(watch);
            System.out.println("Congratulations, " + getUsername() + ", your watch is being placed!");
        }
        else
        {
            System.out.println("We are sorry, " + getUsername() + ", you do not meet the age requirements!"); //todo exception
        }
    }

    public boolean AgeRestriction()
    {
        if(getAge()<18)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int compareTo(User o) {
        if(user_id == o.getUser_id())
            return 0;
        else if (user_id > o.getUser_id())
            return 1;
        else return -1;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
