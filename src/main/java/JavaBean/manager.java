package JavaBean;

public class manager {
    private String mngrName;
    private String password;

    public manager(){
        this.mngrName=null;
        this.password=null;
    }

    public manager(String strMngrName, String strPassWord){
        this.password=strPassWord;
        this.mngrName=strMngrName;
    }

    public String getMngrName() {
        return mngrName;
    }

    public String getPassword(){
        return password;
    }

    public void setMngrName(String str){
        this.mngrName=str;
    }

    public void setPassword(String str){
        this.password=str;
    }

    @Override
    public String toString() {
        return "manager{" +
                "mngrName='" + mngrName + '\'' +
                '}';
    }
}