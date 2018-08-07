package sample;
//Модель данных
public class User {
    private String ID;
    private String Name;
    User(String ID,String Name){
        this.ID=ID;
        this.Name=Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
