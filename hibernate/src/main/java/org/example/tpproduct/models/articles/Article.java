package org.example.tpproduct.models.articles;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.tpproduct.models.selling.Selling;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String description;
    protected double price;
    protected int stock;
    protected LocalDate restockDate;

    @ManyToMany(mappedBy = "articles")
    protected List<Selling> sellings;


//    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
//    private List<Image> images;
//
//    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
//    private List<Comment> comments;

    public void update(String description,double price, int stock, LocalDate restockDate){
        this.description =description;
        this.restockDate = restockDate;
        this.price= price;
        this.stock=stock;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", restockDate=" + restockDate +
                '}';
    }
}
