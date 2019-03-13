package ekrmadonate.data;

public class TabKha {
    private String name;
    private String image;
    private int price;
    private String vegetables;
    private String spices;
    private String liquids;
    private String oil;


    public TabKha() {
    }

    public String getLiquids() {
        return liquids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFlour() {
        return vegetables;
    }

    public void setFlour(String flour) {
        vegetables = flour;
    }

    public String getButter() {
        return spices;
    }

    public void setButter(String butter) {
        this.spices = butter;
    }

    public String getOil() {
        return oil;
    }


    public void setLiquids(String liquids) {
        this.liquids = liquids;
    }

    @Override
    public String toString() {
        return "TabKha{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", vegetables='" + vegetables + '\'' +
                ", spices='" + spices + '\'' +
                ", liquids='" + liquids + '\'' +
                ", oil='" + oil + '\'' +
                '}';
    }

    public void setOil(String oil) {
        this.oil = oil;

    }
}
