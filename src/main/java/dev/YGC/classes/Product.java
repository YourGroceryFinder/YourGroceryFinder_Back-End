package dev.YGC.classes;

public class Product {
    private String Name;
    private String imgLink;
    private String Price;
    private String Store;

    public Product(String Name, String imgLink, String Price, String Store){
        this.Name = Name;
        this.imgLink = imgLink;
        this.Price = Price;
        this.Store = Store;
    }

    public String getName(){
        return this.Name;
    }

    public String getImgLink(){
        return this.imgLink;
    }

    public String getPrice(){
        return this.Price;
    }

    public String getStore(){
        return this.Store;
    }
}
