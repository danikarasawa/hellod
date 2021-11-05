package daniela.dev.hellod.user.api;

import java.util.List;

import javax.validation.Valid;

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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuário", description = "Informações gerais sobre a API")
@RequestMapping("/user")
public interface UserApi {

    @Operation(summary = "título", description = "conteúdo")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso", content = @Content), 
        @ApiResponse(responseCode = "500", description = "Ocorreu um erro ao criar o usuário")
    })

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> create(@RequestBody @Valid UserResource resource);

    @Operation(summary = "Consulta de usuário por e-mail", description = "Realizar consulta utilizando o e-mail do usuário")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso", content = @Content(schema = @Schema(implementation = UserResource.class))),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro ao consultar o usuario")
    })
    @GetMapping("/{email}")
    ResponseEntity<UserResource> findById(@PathVariable("email") String email);

    @Operation(summary = "Consulta de usuário", description = "Consulta de usuário de acordo com os filtros aplicados")
    @Parameter(in = ParameterIn.QUERY, description = "Filtro", content = @Content(schema = @Schema(implementation = UserResource.class)))
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso", content = @Content(schema = @Schema(implementation = UserResource.class))),
        @ApiResponse(responseCode = "500", description = "Ocorreu um erro ao consultar o usuário")
    })
    @GetMapping
    ResponseEntity<List<UserResource>> find(UserResource filter);

    @Operation(summary = "Atualizacao de usuario", description = "API resposanvel por atualizar as informacoes de um usuario")
    @Parameter(description = "Dados a serem atualizados", content = @Content(schema = @Schema(implementation = UserResource.class)))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso", content = @Content),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro ao atualizar o usuario")
    })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> update(@RequestBody UserResource resource);

    @Operation(summary = "Remocao de usuario", description = "API remover um determinado usuario")
    @Parameter(in = ParameterIn.PATH, description = "Email")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario removido com sucesso", content = @Content),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro ao remover o usuario")
    })
    @DeleteMapping("/{email}")
    ResponseEntity<UserResource> delete(@PathVariable("email") String email);

}
