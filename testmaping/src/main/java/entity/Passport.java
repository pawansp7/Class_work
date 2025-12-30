package entity;



import jakarta.persistence.*;

@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String passportNO;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportNO() {
        return passportNO;
    }

    public void setPassportNO(String passportNO) {
        this.passportNO = passportNO;
    }
}
