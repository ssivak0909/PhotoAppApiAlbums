package com.appsdeveloperblog.photoapp.api.albums;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCosmosRepositories({"com.appsdeveloperblog.photoapp.api.albums.cosmos.repository"})
//@EnableDiscoveryClient
public class PhotoAppApiAlbumsApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(PhotoAppApiAlbumsApplication.class, args);
    }

}

