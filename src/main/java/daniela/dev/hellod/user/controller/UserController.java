package daniela.dev.hellod.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import daniela.dev.hellod.user.api.UserApi;
import daniela.dev.hellod.user.api.mapper.UserMapper;
import daniela.dev.hellod.user.api.resource.UserResource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController implements UserApi {

    @Override
    public ResponseEntity<Void> create(UserResource resource) {
        log.info("Recebendo informações: {}", resource);

        // TODO: Converter para um objeto de dominio do usuario

        //TODO: incluir Mappers
        //User parse = UserMapper.INSTANCE.parse(resource);
        //log.info("Parser do objeto: {}", parse);

        // TODO: Chamar servico que vai persistir esse usuario

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<UserResource> findById(String email) {
        log.info("Recebendo infos: {}", email);

        return ResponseEntity.ok(UserResource.builder().phoneNumber("11 233455")
                                                       .name("name")
                                                       .email(email)
                                                       .build());
    }

    public ResponseEntity<Void> update(UserResource resource) {
        log.info("Atualizar infos: {}", resource);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> delete(UserResource resource) {
        log.info("Apagando infos: {}", resource);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<UserResource>> find(UserResource filter) {
        log.info("Recebendo infos: {}", filter);
        return ResponseEntity.ok().build();
    }
}
