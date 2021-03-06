package daniela.dev.hellod.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import daniela.dev.hellod.user.api.UserApi;
import daniela.dev.hellod.user.api.mapper.UserMapper;
import daniela.dev.hellod.user.api.resource.UserResource;
import daniela.dev.hellod.user.domain.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController implements UserApi {

    @Override
    public ResponseEntity<Void> create(UserResource resource) {
        log.info("Recebendo informações: {}", resource);

        // TODO: Converter para um objeto de dominio do usuario

        User parse = UserMapper.INSTANCE.parse(resource);
        log.info("Parser do objeto: {}", parse);

        // TODO: Chamar servico que vai persistir esse usuario

        // Tratando os erros de validação
        // Javax Validation - JSR 303 Bean Validation
        // é um padrão adotado pelo Java para validação de dados de um determinado bean

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<UserResource> findById(String email) {
        log.info("Recebendo infos: {}", email);

        //throw new NotFoundException("usuario nao encontrado");
        //Optional.empty().orElse... VERIFICAR

        return ResponseEntity.ok(UserResource.builder().phoneNumber("11 233455")
                                                       .name("name")
                                                       .email(email)
                                                       .build());
    }

    @Override
    public ResponseEntity<List<UserResource>> find(UserResource filter) {
        log.info("Recebendo infos: {}", filter);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> update(UserResource resource) {
        log.info("Atualizar infos: {}", resource);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserResource> delete(String email) {
        log.info("Apagando infos: {}", email);
        return ResponseEntity.ok().build();
    }
}
