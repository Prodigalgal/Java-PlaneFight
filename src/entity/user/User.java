package entity.user;

public class User {

    private String loginName;
    private String loginPassword;
    private int UserScore;
    private String UserId;
    public int PlaneDamage = 0;//商城购买伤害
    public int PlaneHP = 0;//商城购买血量
    public int PlaneSpeed = 0;//商城购买速度
    private int Money;
    public static User user;

    public User(String nameTextField, String passwordField) {
        this.loginPassword = passwordField;
        this.loginName = nameTextField;
    }

    public User() {}


    public int getPlaneDamage() {
        return PlaneDamage;
    }

    public void setPlaneDamage(int planeDamage) {
        PlaneDamage = planeDamage;
    }

    public int getPlaneHP() {
        return PlaneHP;
    }

    public void setPlaneHP(int planeHP) {
        PlaneHP = planeHP;
    }

    public int getPlaneSpeed() {
        return PlaneSpeed;
    }

    public void setPlaneSpeed(int planeSpeed) {
        PlaneSpeed = planeSpeed;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getUserScore() {
        return UserScore;
    }

    public void setUserScore(int userScore) {
        UserScore = userScore;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

}
