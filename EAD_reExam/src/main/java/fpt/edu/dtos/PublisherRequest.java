package fpt.edu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Truong Duc Duong
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherRequest {
    private String name;

    private String address;

    private String contactPerson;

    private String phone;
}
