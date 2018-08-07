package sample;

public class ConData {
    private String URL="jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private String USERNAME="admin";
    private String PASSWORD="admin";
    private String CLASSFORNAME="com.mysql.jdbc.Driver";

    public String getURL() {
        return URL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getCLASSFORNAME() {
        return CLASSFORNAME;
    }
}
