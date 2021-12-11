package com.mycompany.store.service.mapper;

import com.mycompany.store.domain.ProductOrder;
import com.mycompany.store.service.dto.ProductOrderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProductOrder} and its DTO {@link ProductOrderDTO}.
 */
@Mapper(componentModel = "spring", uses = { CustomerMapper.class })
public interface ProductOrderMapper extends EntityMapper<ProductOrderDTO, ProductOrder> {
    @Mapping(target = "customer", source = "customer", qualifiedByName = "id")
    ProductOrderDTO toDto(ProductOrder s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductOrderDTO toDtoId(ProductOrder productOrder);
}
