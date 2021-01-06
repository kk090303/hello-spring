package Hello.hellospring.domain;

public class Member {

    private Long id; //system-defined id
    private String name; //user name

    //getter,setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}