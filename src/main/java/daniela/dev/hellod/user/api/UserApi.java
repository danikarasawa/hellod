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

@RequestMapping("/user")
public interface UserApi {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> create(@RequestBody UserResource resource);

    @GetMapping("/{email}")
    ResponseEntity<UserResource> findById(@PathVariable("email") String email);

    @GetMapping
    ResponseEntity<List<UserResource>> find(UserResource filter);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> update(@RequestBody UserResource resource);

    @DeleteMapping("/{email}")
    ResponseEntity<Void> delete(@RequestBody UserResource resource);

}

// @PatchMapping - ver detalhe
