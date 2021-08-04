package ContestProject.model;

import java.security.DomainLoadStoreParameter;
import java.text.DecimalFormat;
import java.util.List;

public class ContestVO {
    private String entry_no;
    private String entry_name;
    private String entry_jumin;
    private  String entry_type;
    private String entry_area;


    public String getAve(Double avg){
        DecimalFormat format = new DecimalFormat("0.00");
        String avg1 = format.format(avg);
        return avg1;
    }
    private List<Integer> score;
    private int max,min,tot;
    private double ave;

    private List rname;

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }
    public List getRname() {
        return rname;
    }

    public void setRname(List rname) {
        this.rname = rname;
    }

    public String getEntry_no() {
        return entry_no;
    }

    public void setEntry_no(String entry_no) {
        this.entry_no = entry_no;
    }

    public String getEntry_name() {
        return entry_name;
    }

    public void setEntry_name(String entry_name) {
        this.entry_name = entry_name;
    }

    public String getEntry_jumin() {
        return entry_jumin;
    }

    public void setEntry_jumin(String entry_jumin) {
        this.entry_jumin = entry_jumin;
    }

    public String getEntry_type() {
        return entry_type;
    }

    public void setEntry_type(String entry_type) {
        this.entry_type = entry_type;
    }

    public String getEntry_area() {
        return entry_area;
    }

    public void setEntry_area(String entry_area) {
        this.entry_area = entry_area;
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public double getAve() {
        return ave;
    }

    public void setAve(double ave) {
        this.ave = ave;
    }

}
