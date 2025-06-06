package org.example.tpproduct.models.selling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tpproduct.models.Customer;
import org.example.tpproduct.models.articles.Article;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Selling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SellingStatus sellingStatus;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "article_selling", joinColumns =
    @JoinColumn(name = "sellingId"), inverseJoinColumns =
    @JoinColumn(name = "articleId"))
    private List<Article> articles;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public String toString() {
        return "Selling{" +
                "id=" + id +
                ", sellingStatus=" + sellingStatus +
                ", articles=" + articles +
                ", customer=" + customer +
                '}';
    }

    public void addArticle(Article article){
        articles.add(article);


    }

}
