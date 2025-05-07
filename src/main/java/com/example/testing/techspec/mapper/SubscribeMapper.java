package com.example.testing.techspec.mapper;

import com.example.testing.techspec.dto.SubscribeDto;
import com.example.testing.techspec.entities.Subscribe;
import com.example.testing.techspec.entities.User;
import com.example.testing.techspec.enums.SubscribeServiceType;
import com.example.testing.techspec.service.UserService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SubscribeMapper {

    @Mapping(target = "serviceType", source = "serviceType", qualifiedByName = "toServiceType")
    @Mapping(target = "user", source = "userId", qualifiedByName = "toUser")
    Subscribe toEntity(SubscribeDto dto, @Context UserService userService);

    @Mapping(target = "serviceType", source = "serviceType", qualifiedByName = "toAlias")
    @Mapping(target = "userId", source = "user.id")
    SubscribeDto toDto(Subscribe subscribe);

    @Named("toServiceType")
    default SubscribeServiceType toServiceType(String service) {
        return SubscribeServiceType.fromAlias(service);
    }

    @Named("toAlias")
    default String toAlias(SubscribeServiceType type) {
        return type.getAlias();
    }

    @Named("toUser")
    default User toUser(Long userId, @Context UserService userService) {
        return userService.getUserEntityById(userId);
    }
}
