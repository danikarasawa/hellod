package daniela.dev.hellod.user.api.resource;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {

    @Email(message = "E-mail é um campo obrigatório")
    @Schema(description = "Email do usuário, este campo deve ser único")
    private String email;

    @Size(max = 8, min = 3, message = "O campo nome deve entre 3 e 8 caracteres")
    @NotEmpty(message = "O campo nome não pode ficar vazio")
    @NotNull(message = "O campo nome não pode ficar em branco")
    @Schema(description = "Nome do usuário, esse campo deve ser preenchido")
    private String name;

    @Schema(description = "Telefone do usuário, esse campo deve ser preenchido")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Min(message = "Valor mínimo deve ser 5", value = 5)
    @Max(message = "Valor máximo deve ser 10", value = 10)
    private Integer number;

    @DecimalMin(value = "0.15", message = "Valor mínimo deve ser 0.15")
    @DecimalMax(value = "1.15", message = "Valor máximo deve ser 1.15")
    private BigDecimal amount;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
}
