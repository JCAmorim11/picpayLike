package br.com.likepay.picpayLike.converter;

import br.com.likepay.picpayLike.dto.UserDTO;
import br.com.likepay.picpayLike.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends ConverterBase<User, UserDTO> {
    @Override
    public User converterDtoToEntity(UserDTO dto) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<User,UserDTO>() {
            @Override
            protected void configure(){
            }
        });
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserDTO converterEntityToDTO(User entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<UserDTO,User>() {
            @Override
            protected void configure(){
            }
        });
        return modelMapper.map(entity, UserDTO.class);

    }


}
