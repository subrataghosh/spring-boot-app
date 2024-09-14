package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getEmployee(ModelMap model) {
        model.put("allEmployees", employeeService.getAllEmployees());
        return "employee";
    }

    @RequestMapping(value = "/addEmployee" , method = RequestMethod.GET)
    public String addEmployee(){
        return "addEmployee";

    }

    @RequestMapping(value="/addEmployee", method = RequestMethod.POST)
    public String saveEmployeeData(HttpSession session, @ModelAttribute("Employee") Employee employee, ModelMap model){

        employeeService.addEmployee(employee);

        return "redirect:/employee";
    }

    @RequestMapping(value = "/viewEmployee" , method = RequestMethod.GET)
    public String viewEmployee(){
        return "viewEmployee";

    }
}
