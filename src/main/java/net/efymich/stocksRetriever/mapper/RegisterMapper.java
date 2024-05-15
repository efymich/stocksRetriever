package net.efymich.stocksRetriever.mapper;

import net.efymich.stocksRetriever.domain.User;
import net.efymich.stocksRetriever.dto.RegisterDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper {
    RegisterDTO userToDTO(User user);

    User dtoToUser(RegisterDTO dto);
}
