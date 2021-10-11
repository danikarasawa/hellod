package daniela.dev.hellod.user.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import daniela.dev.hellod.user.api.resource.UserResource;
import daniela.dev.hellod.user.domain.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({ @Mapping(source = "email", target = "email") })
    User parse(UserResource resource);

}
