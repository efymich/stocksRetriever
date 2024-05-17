package net.efymich.stocksRetriever.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "users", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    String name;

    @NotEmpty
    String email;

    @NotEmpty
    String password;

}
