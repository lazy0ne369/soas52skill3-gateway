package soa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.service.GatewayService;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    GatewayService GS;

    public GatewayController(GatewayService GS) {
        this.GS = GS;
    }

    // Signup through Gateway + Eureka
    @PostMapping("/signup")
    public Object signup(@RequestBody Object signup) {
        return GS.invokePostService(
                "signupmodule",
                "signup",
                signup
        );
    }

    // Get user through Gateway + Eureka
    @GetMapping("/signup/{username}")
    public Object getUser(@PathVariable String username) {

        return GS.invokeService(
                "signupmodule",
                "signup/" + username
        );
    }

    // Login through Gateway + Eureka + JWT
    @PostMapping("/login")
    public Object login(@RequestBody Object login) {

        return GS.invokePostService(
                "loginmodule",
                "login",
                login
        );
    }
}