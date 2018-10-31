package pt.ist.dsi;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */

@RestController
@RequestMapping("/upload")
public class UploadRestController {

    Logger logger = LoggerFactory.getLogger(UploadRestController.class);

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }

    @GetMapping("/gitlab")
    public String goodbye() {
        return "hello gitlab";
    }



    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file, @RequestPart("data") DataBean dataBean) {
        try {
            logger.info("upload file {} with content {}", file.getOriginalFilename(), Streams.asString(file.getInputStream()));
            logger.info("data bean {}", dataBean.toString());
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String onlyJson(@RequestBody DataBean bean) {
        return bean.toString();
    }

    public static class DataBean {

        private enum Type {
            READ, WRITE;
        }

        private Set<Type> types;
        private String title;
        private String name;

        public DataBean() {
        }

        public DataBean(String title, String name) {
            this.title = title;
            this.name = name;
        }

        public Set<Type> getTypes() {
            return types;
        }

        public void setTypes(Set<Type> types) {
            this.types = types;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "types=" + types +
                    ", title='" + title + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
