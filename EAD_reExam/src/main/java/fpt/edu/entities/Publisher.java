package fpt.edu.entities;

import fpt.edu.dtos.BookRequest;
import fpt.edu.dtos.PublisherRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Truong Duc Duong
 */

@Entity
@Table(name = "publishers")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    @Column(name = "contact_person")
    private String contactPerson;

    private String phone;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Publisher(PublisherRequest publisherRequest) {
        this.name = publisherRequest.getName();
        this.address = publisherRequest.getAddress();
        this.contactPerson = publisherRequest.getContactPerson();
        this.phone = publisherRequest.getPhone();
    }
}
