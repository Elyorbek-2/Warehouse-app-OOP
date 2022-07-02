package entity;

import repository.UserRepository;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Double balance;
    private Address address;
    private Timestamp createUser;
    private Role role;


    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(balance, user.balance) && Objects.equals(address, user.address) && Objects.equals(createUser, user.createUser) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, balance, address, createUser, role);
    }

    public User(Integer id, String name, String email, String password, Double balance, Address address, Timestamp createUser, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.address = address;
        this.createUser = createUser;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Timestamp getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Timestamp createUser) {
        this.createUser = createUser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
