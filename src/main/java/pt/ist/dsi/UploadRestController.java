package pt.ist.dsi;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */

@RestController
@RequestMapping("/upload")
public class UploadRestController {

    Logger logger = LoggerFactory.getLogger(UploadRestController.class);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file, @RequestPart("data") DataBean dataBean) {
        try {
            logger.info("upload file {} with content {}", file.getOriginalFilename(), Streams.asString(file.getInputStream()));
            logger.info("data bean {}", dataBean.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    public static class DataBean {

        private String title;
        private String name;

        public DataBean() {
        }

        public DataBean(String title, String name) {
            this.title = title;
            this.name = name;
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
                    "title='" + title + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
