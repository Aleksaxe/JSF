package sample;

public class User {
    private int ID;
    private String Name;
    User(int ID,String Name){
        this.ID=ID;
        this.Name=Name;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
