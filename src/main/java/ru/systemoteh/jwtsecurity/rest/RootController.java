package ru.systemoteh.jwtsecurity.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jwtsecurity")
public class RootController {

    /*
        curl --location --request GET 'http://localhost:8080/jwtsecurity/index' \
        --header 'Authorization: Bearer_{token}' \
        --data-raw ''
     */
    @GetMapping(value = "/index")
    public String index() {
        return "Hello index";
    }
}
