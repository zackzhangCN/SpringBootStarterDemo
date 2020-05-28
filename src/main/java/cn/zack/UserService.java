package cn.zack;

public class UserService {
    private UserProperties userProperties;

    public UserService() {
    }

    public UserService(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public void hello(){
        System.out.println(userProperties.getUsername() + "\n" + userProperties.getAge() + "\n" + userProperties.getGender());
    }
}
