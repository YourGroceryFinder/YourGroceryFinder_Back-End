package dev.YGC.Logic;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "ID", updatable = false)
    private Integer ID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "imglink")
    private String imglink;

    @Column(name = "Price")
    private Double Price;

    @Column(name = "Store")
    private String Store;

    public Product(String name, String imgLink, Double price, String store) {
        Name = name;
        imglink = imgLink;
        Price = price;
        Store = store;
    }
    public Product(Integer id, String name, String imgLink, Double price, String store) {
        ID = id;
        Name = name;
        imglink = imgLink;
        Price = price;
        Store = store;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getStore() {
        return Store;
    }

    public void setStore(String store) {
        Store = store;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", imglink='" + imglink + '\'' +
                ", Price=" + Price +
                ", Store='" + Store + '\'' +
                '}';
    }
}
