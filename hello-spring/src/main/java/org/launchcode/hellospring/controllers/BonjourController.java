package org.launchcode.hellospring.controllers;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class BonjourController {

    @RequestMapping(value = "bonjourSpring", method = RequestMethod.GET)
    @ResponseBody
    public String createMessage() {
        String html = "<form method='post'>" +
                "<input type='submit' value='Say Hello to' />" +
                "<input type='text' name='name' value='Your Name Here' />" +
                " in " +
                "<select name='langselect'>"+
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Latin'>Latin</option>" +
                "<option value='Turkish'>Turkish</option>" +
                "</select>" +
                "</form>";
        return html;
    }
    @RequestMapping(value = "bonjourSpring", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest nameRequest, HttpServletRequest languageRequest) {
        String name = nameRequest.getParameter("name");
        String language = nameRequest.getParameter("langselect");

        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("English", "Hello");
        hmap.put("Turkish", "Merhaba");
        hmap.put("French", "Bonjour");
        hmap.put("Latin", "Salve");
        hmap.put("Spanish", "Hola");

        String hello = hmap.get(language);
        return hello + " " + name;
    }
}
