package practice.springmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sample")
public class SampleController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "hello ";
    }

    @GetMapping(value = "/mediaType",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String hello2() {
        return "hello";
    }

    @GetMapping("/hi")
    @ResponseBody
    public String hi() {
        return "hi";
    }

    @PostMapping("/hi")
    @ResponseBody
    public String hiPost(){
        return "hi";
    }
}
