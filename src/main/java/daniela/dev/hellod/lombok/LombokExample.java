package daniela.dev.hellod.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter // pode usar @Data
@Builder
@ToString //(exclude = "lastname")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class LombokExample {
    @NonNull
    private String name;
    private String lastname;
}
