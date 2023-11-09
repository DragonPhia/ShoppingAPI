package com.f23.shoppeasy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author samue
 */
@Controller
public class AppController {
    @GetMapping(value = {"", "/", "/login"})
    public String landing(Model model) {
        return "index";
    }
}
