package br.com.likepay.picpayLike.converter;

import br.com.likepay.picpayLike.dto.TransactionDTO;
import br.com.likepay.picpayLike.model.Transaction;
import br.com.likepay.picpayLike.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter extends ConverterBase<Transaction, TransactionDTO> {

    @Autowired
    public IUserService userService;
    @Override
    public TransactionDTO converterEntityToDTO(Transaction entity) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Transaction, TransactionDTO>() {
            @Override
            protected void configure(){
            }
        });
         return modelMapper.map(entity, TransactionDTO.class);
    }


    @SuppressWarnings("unchecked")
    public Page<TransactionDTO> converterPageEntityToDTO(Page<Transaction> entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Page<Transaction>, Page<TransactionDTO>>(){
            @Override
            protected void configure(){
            }
    });
        return modelMapper.map(entity, Page.class);
    }


    @Override
    public Transaction converterDtoToEntity(TransactionDTO dto) {
        return Transaction.builder()
                .code(dto.getCode())
                .dateTime(dto.getDateHour())
                .value(dto.getValue())
                .destination(userService.checkEntity(dto.getDestiny().getLogin()))
                .origin(userService.checkEntity(dto.getOrigin().getLogin()))
                .build();
    }
}
