package org.example.productexercise.Ihm;

import org.example.productexercise.dao.CommentDao;
import org.example.productexercise.models.Comment;
import org.example.productexercise.models.Image;
import org.example.productexercise.models.Product;

import java.time.LocalDate;

import static org.example.utils.Utils.*;

public class CommentIhm extends Ihm{
    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter un commentaire
                        2 - Voir tous les commentaires
                        3 - Rechercher un commentaire
                        4 - Modifier un commentaire
                        5 - Supprimer un commentaire
                        6 - Associer un produit
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createComment();
                case 2 -> showAllComment();
                case 3 -> showCommentById();
                case 4 -> updateComment();
                case 5 -> deleteComment();
                case 6 -> associateCommentProduct();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void associateCommentProduct() {
        int idComment= getInt("Quels est l'ID du commentaire ?");
        Comment comment = productService.getComment(idComment);
        int idProduct = getInt("Quels est l'ID du produit ?");
        Product product = productService.getProduct(idProduct);
        comment.setProduct(product);
        productService.updateComment(comment);
    }

    private static void deleteComment() {
        int id = getInt("Quels est l'ID du commentaire ?");
        productService.deleteComment(productService.getComment(id));
    }

    private static void updateComment() {
        int id = getInt("Quels est l'ID du commentaire ?");
        Comment comment = productService.getComment(id);
        String userComment = getString("Commentaire : ");
        LocalDate publicationDate = LocalDate.now();
        int rating = getInt("Note : ");
        comment.update(userComment,publicationDate,rating);
        productService.updateComment(comment);
    }

    private static void showCommentById() {
        int id = getInt("Quels est l'ID du commentaire ?");
        System.out.println(productService.getComment(id));
    }

    private static void showAllComment() {
        for(Comment comment: productService.getComments())
            System.out.println(comment);
    }

    private static void createComment() {
        String userComment = getString("Commentaire : ");
        LocalDate publicationDate = LocalDate.now();
        int rating = getInt("Note : ");
        productService.createComment(userComment,publicationDate,rating);
    }
}
