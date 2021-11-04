package daniela.dev.hellod.user.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import daniela.dev.hellod.user.api.resource.UserResource;

//@Tag(name = "Usuário", description = "Informações gerais sobre a API")
@RequestMapping("/user")
public interface UserApi {

    //@Operation(summary = "título", description = "conteúdo")
    // @ApiResponses({
    //     @ApiResponses(responseCode = "201", "mensagem", content = @Content),
    //     @ApiResponses(responseCode = "500", "mensagem", content = @Content(schema(implementation = UserResource.class)))
    // })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> create(@RequestBody UserResource resource);

    @GetMapping("/{email}")
    ResponseEntity<UserResource> findById(@PathVariable("email") String email);

    @GetMapping
    ResponseEntity<List<UserResource>> find(UserResource filter);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> update(@RequestBody UserResource resource);

    @DeleteMapping("/{email}")
    ResponseEntity<UserResource> delete(@PathVariable("email") String email);

}
