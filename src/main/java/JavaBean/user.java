package JavaBean;

import java.util.Arrays;

public class user {
    private String userName;
    private String password;
    private String[] arrayCollect;
    private int numCollect;

    public user(){
        this.userName=null;
        this.password=null;
        arrayCollect=new String[1005];
        numCollect=0;
    }

    public user(String strName, String strPass){
        this.userName=strName;
        this.password=strPass;
        arrayCollect=new String[1005];
        numCollect=0;
    }

    public void addCollect(String str){
        arrayCollect[numCollect]=str;
        numCollect++;
    }

    public void deleteCollect(int tex){
        for(int i=tex; i<numCollect; i++){
            arrayCollect[i]=arrayCollect[i+1];
        }
        numCollect--;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String[] getArrayCollect(){
        return arrayCollect;
    }

    public int getNumCollect(){
        return numCollect;
    }

    public void setUserName(String str){
        this.userName=str;
    }

    public void setPassword(String str){
        this.password=str;
    }

    @Override
    public String toString() {
        return "user{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setArrayCollect(String[] arrayC){
        this.arrayCollect=arrayC;
        numCollect=arrayC.length;
    }
}