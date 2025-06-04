package org.example.productexercise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;
    private LocalDate publicationDate;
    private int rating;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_product")
    private Product product;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", publicationDate=" + publicationDate +
                ", rating=" + rating +
                '}';
    }

    public void update(String userComment, LocalDate publicationDate, int rating) {
        comment = userComment;
        this.publicationDate = publicationDate;
        this.rating = rating;
    }
}
