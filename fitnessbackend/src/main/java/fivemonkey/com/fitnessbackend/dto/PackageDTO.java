package fivemonkey.com.fitnessbackend.dto;

public class PackageDTO {

    private String id;
    private String name;
    private int duration;
    private Float price;
    private String des;
    private boolean status;

    public PackageDTO() {
    }

    public PackageDTO(String name, int duration, Float price, String des, boolean status) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.des = des;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PackageDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", des='" + des + '\'' +
                ", status=" + status +
                '}';
    }
}
