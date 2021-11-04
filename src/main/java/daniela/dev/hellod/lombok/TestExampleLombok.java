package daniela.dev.hellod.lombok;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestExampleLombok {
    public static void main(String[] args) {
        
        LombokExample example = new LombokExample();
        example.setName("dani");
        example.setLastname("beleze");

        System.out.println("Lombok example: " + example);
    
        LombokExample example2 = new LombokExample("usagi", "tsukino");
        System.out.println(example2);


        System.out.println(LombokExample.builder().name("abc").lastname("def").build());

        LombokExample example3 = new LombokExample("dani");
        System.out.println(example3);

        System.out.println("data: " + Util.today());
        System.out.println("texto: " + Util.text);

        log.info("Uso de log...");
    }
}
