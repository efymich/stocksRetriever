package net.efymich.stocksRetriever.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    String email;
    String token;
}
