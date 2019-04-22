package cn.happyzhong.servicesnode1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/node1")
public class HelloNode1Controller {


    @RequestMapping("/hello")
    public String helloNode1() {
        return "HHH, 这里是node1";
    }

}
