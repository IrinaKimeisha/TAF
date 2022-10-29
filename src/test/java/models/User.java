package models;

public class User {
    private String email;
    private String password;

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }
        public Builder withEmail(String value){
            newUser.email = value;
            return this;
        }
        public Builder withPassword(String value){
            newUser.password = value;
            return this;
        }
        public User build(){
            return newUser;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
