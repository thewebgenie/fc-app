
package org.launchcode.hellospring.controllers;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody()
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");

        if (name == null) {
            name = "";
        }
        return "Hello "+ name;
    }
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Say Hello to Me!' />" +
                "</form>";
        return html;
    }
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest nameRequest, HttpServletRequest languageRequest) {
        String name = nameRequest.getParameter("name");
        String language = nameRequest.getParameter("langselect");

        return "Hello " + name;
    }
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "Goodbye")
    @ResponseBody()
    public String goodbye() {
        return "redirect:/";
    }
}
