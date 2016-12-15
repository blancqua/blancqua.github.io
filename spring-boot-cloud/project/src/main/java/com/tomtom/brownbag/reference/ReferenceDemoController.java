package com.tomtom.brownbag.reference;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController
public class ReferenceDemoController {

    @Value("${key}")
    private String key;

    @RequestMapping(value="/key", method= RequestMethod.GET)
    public String key() {
        return key;
    }

}
