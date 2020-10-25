package hiber.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "human")
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "human_id")
    private Integer id;

    @Column(name = "human_name")
    private String name;

    @Column(name = "human_birth")
    private Date birth;

    @Column(name = "human_adress")
    private String adress;

    @Column(name = "human_married")
    private Boolean married;

    public Human() {
    }

    public Human(String name, String adress, Date birth, Boolean married) {
        this.name = name;
        this.adress = adress;
        this.birth = birth;
        this.married = married;
    }

    public Human(Integer id, String name, String adress, Date birth, Boolean married) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.birth = birth;
        this.married = married;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", adress='" + adress + '\'' +
                ", married=" + married +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id.equals(human.id) &&
                name.equals(human.name) &&
                birth.equals(human.birth) &&
                Objects.equals(adress, human.adress) &&
                married.equals(human.married);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birth, adress, married);
    }
}