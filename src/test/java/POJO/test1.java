package POJO;

public class test1 {
    String name;
    data data;

    public test1(String name,data data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public POJO.data getData() {
        return data;
    }

    public void setData(POJO.data data) {
        this.data = data;
    }
}
