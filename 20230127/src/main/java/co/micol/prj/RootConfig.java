package co.micol.prj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //나는 configuration이다!-> 얘가 없으면 컨테이너 올라가지않음!!!
@ComponentScan(basePackages = {"co.micol.prj"})

public class RootConfig {

}
