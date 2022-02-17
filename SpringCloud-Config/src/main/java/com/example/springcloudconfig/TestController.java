package com.example.springcloudconfig;

import io.swagger.models.License;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class TestController {
    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public String getID(@PathVariable("id") String id,
                        @PathVariable("name") String name){
        return id+" "+name;
    }
}
