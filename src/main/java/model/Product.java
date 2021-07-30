package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pName;
    private String pPrice;
    private int pAmount;
    private String pColor;
    private String pDescription;
    @ManyToOne
    private Category category;

    public Product(String pName, String pPrice, int pAmount, String pColor, String pDescription, Category category) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pAmount = pAmount;
        this.pColor = pColor;
        this.pDescription = pDescription;
        this.category = category;
    }

    public Product() {
    }
}
