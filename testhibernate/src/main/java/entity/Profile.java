package entity;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    @Column(nullable = false)
    private String profileName;

    @OneToOne(mappedBy = "profile")
     @JoinColumn(name = "User_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Profile(){
        super();
    }
    public Profile(int profileId, String address) {
        this.profileId = profileId;
        this.profileName = address;
    }

    public Profile(String address) {
        this.profileName = address;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String address) {
        this.profileName = address;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }
}
