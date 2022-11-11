package br.com.likepay.picpayLike.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class ConverterBase<E,D>{
    public abstract D converterEntityToDTO(E entity);
    public abstract E converterDtoToEntity(D dto);


    public List<D> converterEntityToDTO(List<E> entities){
        List<D> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> dtos.add(converterEntityToDTO(entity)));
        return dtos;
    }

    public List<E> converterDtoToEntity(List<D> dtos){
        List<E> entities = new ArrayList<>();
        dtos.stream().forEach(dto -> entities.add(converterDtoToEntity(dto)));
        return entities;
    }

}
