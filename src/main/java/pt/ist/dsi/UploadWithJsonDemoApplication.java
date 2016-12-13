package pt.ist.dsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UploadWithJsonDemoApplication {

//    @Bean
//    public MultipartResolver multipartResolver() {
//        return new StandardServletMultipartResolver();
//    }

    public static void main(String[] args) {
        SpringApplication.run(UploadWithJsonDemoApplication.class, args);
    }
}
