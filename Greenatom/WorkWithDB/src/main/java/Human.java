import java.sql.Date;

public class Human {

    private Integer id;
    private String name;
    private String address;
    private String birth;
    private Boolean married;

    public Human() {
    }

    public Human(String name, String adress, String birth, Boolean married) {
        this.name = name;
        this.address = adress;
        this.birth = birth;
        this.married = married;
    }

    public Human(Integer id, String name, String adress, String birth, Boolean married) {
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }
}
