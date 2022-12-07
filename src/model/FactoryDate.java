package model;


import java.io.Serializable;
import java.sql.Date;

public class FactoryDate implements Serializable {
    private int id_date;
    private Date startDate;
    private Date expiredDate;

    public FactoryDate(){}
    public FactoryDate(Date startDate,Date expiredDate){
        this.startDate = startDate;
        this.expiredDate = expiredDate;
    }

    public void setId_date(int id_date) {
        this.id_date = id_date;
    }

    public int getId_date() {
        return id_date;
    }
    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "FactoryDate{" +
                "id_date=" + id_date +
                ", startDate=" + startDate +
                ", expiredDate=" + expiredDate +
                '}';
    }
}
