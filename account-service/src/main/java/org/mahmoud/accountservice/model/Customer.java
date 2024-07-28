package org.mahmoud.accountservice.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter @ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
