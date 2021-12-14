package JavaBean;

public class website {
    private String webAddress;
    private String frequence;
    private String startDate;
    private String endDate;

    public website(){
        this.webAddress=null;
    }
    public website(String wa, String fq, String sd, String ed){
        this.webAddress=wa;
        this.frequence=fq;
        this.endDate=ed;
        this.startDate=sd;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getFrequence() {
        return frequence;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }
}