package Human;

import java.util.Date;
import java.util.Objects;

public class Human {

    private Integer id;
    private String name;
    private String address;
    private Date birth;
    private Boolean married;

    public Human() {
    }

    public Human(String name, String adress, Date birth, Boolean married) {
        this.name = name;
        this.address = adress;
        this.birth = birth;
        this.married = married;
    }

    public Human(Integer id, String name, String adress, Date birth, Boolean married) {
        this.id = id;
        this.name = name;
        this.address = adress;
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

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Boolean getMarried() {
        return married;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(id, human.id) &&
                Objects.equals(name, human.name) &&
                Objects.equals(address, human.address) &&
                Objects.equals(birth, human.birth) &&
                Objects.equals(married, human.married);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, birth, married);
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth='" + birth + '\'' +
                ", married=" + married +
                '}';
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }
}
