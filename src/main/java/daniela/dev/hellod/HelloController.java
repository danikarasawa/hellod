package daniela.dev.hellod;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    @GetMapping
    public ResponseEntity<Hello> hello() {
        log.info("Hello D ;)");
        return ResponseEntity.ok(Hello.builder().message("testando").build());
    }
}
