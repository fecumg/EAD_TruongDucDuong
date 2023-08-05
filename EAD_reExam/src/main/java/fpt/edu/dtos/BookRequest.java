package fpt.edu.dtos;

import fpt.edu.entities.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Truong Duc Duong
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String name;

    private int publisherId;

    private String author;

    private String genre;
}
