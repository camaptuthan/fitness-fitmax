package fivemonkey.com.fitnessbackend.configuration;

import fivemonkey.com.fitnessbackend.configuration.FireBaseConstant;
import fivemonkey.com.fitnessbackend.configuration.FireBaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class ImageUploader {
    @Autowired
    private FireBaseUtils fireBaseUtils;

    public String upload(MultipartFile multipartFile) {
        String fileName = "";
        if (!multipartFile.isEmpty()) {
            try {
                fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
                fireBaseUtils.uploadFile(multipartFile, fileName);
                return String.format(FireBaseConstant.FILE_URL, fileName);
            } catch (IOException ignored) {

            }
        }
        return fileName;
    }

}
