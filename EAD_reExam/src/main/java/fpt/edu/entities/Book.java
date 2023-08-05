package fpt.edu.entities;

import com.sun.istack.Nullable;
import fpt.edu.dtos.BookRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * @author Truong Duc Duong
 */

@Entity
@Table(name = "books")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private String author;

    private String genre;

    public Book(BookRequest bookRequest) {
        this.name = bookRequest.getName();
        this.author = bookRequest.getAuthor();
        this.genre = bookRequest.getGenre();
    }
}
