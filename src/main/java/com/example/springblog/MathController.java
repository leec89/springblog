package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String exTwoDashOne(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @RequestMapping(path = "/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String exTwoDashTwo(@PathVariable int num1, @PathVariable int num2) {
        return num2 + " - " + num1 + " = " + (num2 - num1);
    }

    @RequestMapping(path = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String exTwoDashThree(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @RequestMapping(path = "/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String exTwoDashFour(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " / " + num2 + " = " + (num1 / num2);
    }

    @RequestMapping(path = "/{op}/{num1}/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String chaseGenius(@PathVariable String op, @PathVariable int num1, @PathVariable int num2) {
        if (op.equals("add")) {
            return num1 + " + " + num2 + " = " + (num1 + num2);
        }
        if (op.equals("subtract")) {
            return num2 + " - " + num1 + " = " + (num2 - num1);
        }
        if (op.equals("multiply")) {
            return num1 + " * " + num2 + " = " + (num1 * num2);
        }
        if (op.equals("divide")) {
            return num1 + " / " + num2 + " = " + (num1 / num2);
        }
        return "hi";
    }
}
