package classes;

import java.util.Date;

public class User_ratings {
    private int rating_id;
    private User user;
    private double stars;
    private String comments;
    private Date date;
    private Watch watch;

    public User_ratings(int rating_id, User user, double stars, String comments, Date date, Watch watch) {
        this.rating_id = rating_id;
        this.user = user;
        this.stars = stars;
        this.comments = comments;
        this.date = date;
        this.watch = watch;
    }


    public int getRating_id() {
        return rating_id;
    }

    public User getUser() {
        return user;
    }

    public double getStars() {
        return stars;
    }

    public String getComments() {
        return comments;
    }

    public Date getDate() {
        return date;
    }
}
