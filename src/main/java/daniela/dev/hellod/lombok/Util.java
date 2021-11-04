package daniela.dev.hellod.lombok;

import java.time.LocalDate;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

    public String text = "text for example";

    public LocalDate today() {
        return LocalDate.now();
    }
}
