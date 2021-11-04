package daniela.dev.hellod.user.api.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    //@Schema(description = "Email do usuário, este campo deve ser único")
    private String email;
    //@Schema(description = "Xoxoxo")
    private String name;
    //@Schema(description = "Xoxoxo")
    @JsonProperty("phone_number")
    private String phoneNumber;
}
