package model;

public class User {
//    private static final String USERNAME = "user";
//
//    private static final String PASSWORD = "123456";
//
//    public boolean validation (String username , String password) {
//        return USERNAME.equals(username) && PASSWORD.equals(password);
//    }


    private int id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
