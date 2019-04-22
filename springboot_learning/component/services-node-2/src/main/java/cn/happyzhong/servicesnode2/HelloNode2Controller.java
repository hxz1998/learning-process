package cn.happyzhong.servicesnode2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/node2")
@RestController
public class HelloNode2Controller {

    @RequestMapping("/hey")
    public String hello() {
        return "HHH， 这里是node2";
    }
}
