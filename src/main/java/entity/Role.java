package entity;

public enum Role {
    DIRECTOR("Direktor"),
    VENDOR("Sotuvchi"),
    WORKER("Ishchi"),
    DRIVER("Xaydovchi"),
    USER("User");
    String uz;

    Role(String uz) {
        this.uz = uz;
    }
}
