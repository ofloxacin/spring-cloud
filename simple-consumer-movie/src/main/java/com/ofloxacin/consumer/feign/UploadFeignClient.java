package com.ofloxacin.consumer.feign;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chens
 **/
@FeignClient(value = "file-upload", configuration = UploadFeignClient.MultipartSupportConfig.class)
public interface UploadFeignClient {

    @ResponseBody
    @PostMapping(value = "/upload", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    String handleFileUpload(@RequestPart("file") MultipartFile file);

    class MultipartSupportConfig {

        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
