package br.com.likepay.picpayLike.converter;

import br.com.likepay.picpayLike.dto.CreditCardDTO;
import br.com.likepay.picpayLike.model.CreditCard;
import br.com.likepay.picpayLike.service.ICreditCardService;
import br.com.likepay.picpayLike.service.IUserService;
import br.com.likepay.picpayLike.util.CreditCardUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Converter;

@Component
public class CreditCardConverter extends ConverterBase<CreditCard, CreditCardDTO> {

    @Autowired
    public IUserService userService;

    @Override
    public CreditCardDTO converterEntityToDTO(CreditCard entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CreditCard, CreditCardDTO>() {
            @Override
            protected void configure(){
            }
        });
        return modelMapper.map(entity, CreditCardDTO.class);

    }

    @Override
    public CreditCard converterDtoToEntity(CreditCardDTO dto) {
        return CreditCard.builder()
                .number(CreditCardUtil.mask(dto.getNumber()))
                .brand(dto.getBrand())
                .numberToken(dto.getNumberToken())
                .user(userService.checkEntity(dto.getUser().getLogin()))
                .build();
    }
}
