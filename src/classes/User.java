package classes;

public class User implements Comparable<User>{

    private int user_id;
    private String username;
    private String password;
    private String email;
    private int age;

    public User(int user_id, String username, String password, String email, int age) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
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
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
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
}
