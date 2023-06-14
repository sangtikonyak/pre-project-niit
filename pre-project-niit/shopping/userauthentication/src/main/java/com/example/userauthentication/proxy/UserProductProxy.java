package com.example.userauthentication.proxy;

import com.example.userauthentication.entity.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "product-container",url = "http://product-container:8081")
public interface UserProductProxy {

        @PostMapping("/product/save-user")
        public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO);

}
