package daniela.dev.hellod.user.api.mapper;

import daniela.dev.hellod.user.api.resource.UserResource;
import daniela.dev.hellod.user.domain.entity.User;

//@Mapper 
public interface UserMapper {

    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User parse(UserResource resource);
    
}
