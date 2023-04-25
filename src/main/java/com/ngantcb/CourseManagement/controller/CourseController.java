package com.ngantcb.CourseManagement.controller;

import com.ngantcb.CourseManagement.entity.Course;
import com.ngantcb.CourseManagement.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService service;

    @GetMapping(value = {"/", "/index", "/home"})
    public String index(Model model) {
        model.addAttribute("courses", service.getAll());

        model.addAttribute("course", new Course());
        return "index";
    }

    @PostMapping("/")
    public String addCourse(@ModelAttribute("course") @Valid Course course,
                            Model model) {
        try {
            Course itemDb = service.save(course);
            // check if subject code existed in database
            if (itemDb == null) {
                model.addAttribute("msg", "existed");
            } else model.addAttribute("msg", "createSuccess");
            model.addAttribute("courses", service.getAll());
            model.addAttribute("course", new Course());
        } catch (Exception ex) {
            model.addAttribute("msg", "createFailed");
            return "index";
        }
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(value = "id") Long id, Model model) {
        try {
            service.delete(id);

            model.addAttribute("msg", "deleteSuccess");

            model.addAttribute("courses", service.getAll());
            model.addAttribute("course", new Course());
        } catch (Exception ex) {
            model.addAttribute("msg", "deleteFailed");
            model.addAttribute("courses", service.getAll());
            return "index";
        }
        return "index";
    }

    @GetMapping("/details/{id}")
    public String getCourseById(@PathVariable(value = "id") Long id, Model model) {
        Course course = service.get(id);
        model.addAttribute("course", course);
        return "details";
    }
}
