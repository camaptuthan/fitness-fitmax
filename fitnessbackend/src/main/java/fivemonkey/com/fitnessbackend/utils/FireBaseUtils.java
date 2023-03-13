package fivemonkey.com.fitnessbackend.utils;

import com.google.cloud.storage.Bucket;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@AllArgsConstructor
@Slf4j
public class FireBaseUtils {


    @Autowired
    private Bucket bucket;


    public void uploadFile(MultipartFile file, String fileName) throws IOException {
        if (file == null) {
            log.info("[uploadFile] Cannot upload because file is not present");

        }
        assert file != null;
        log.info("[uploadFile] Start upload to Firebase with fileName : {},original fileName : {}",
                fileName,
                file.getOriginalFilename());
        if(!bucket.exists(Bucket.BucketSourceOption.userProject(fileName))){
            bucket.create(fileName, file.getBytes(), file.getContentType());
        }
    }

}
