package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentWebController {
    @Autowired
    private StudentService Service;

    // Danh sách sinh viên (có tìm kiếm theo tên)
    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
        List<Student> students;
        if (keyword != null && !keyword.isEmpty()) {
            students = Service.searchByName(keyword);
        } else {
            students = Service.getAll();
        }
        model.addAttribute("dsSinhVien", students);
        model.addAttribute("keyword", keyword);
        return "students";
    }

    // Xem chi tiết sinh viên
    @GetMapping("/{id}")
    public String getStudentDetail(@PathVariable String id, Model model) {
        Student student = Service.getById(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "student-detail";
    }

    // Hiển thị form tạo sinh viên mới
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // Xử lý submit form tạo sinh viên mới
    @PostMapping
    public String createStudent(@ModelAttribute Student student) {
        Service.save(student);
        return "redirect:/students";
    }

    // Hiển thị form chỉnh sửa sinh viên
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Student student = Service.getById(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "student-edit";
    }

    // Xử lý submit form cập nhật sinh viên
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable String id, @ModelAttribute Student student) {
        student.setId(id);
        Service.save(student);
        return "redirect:/students/" + id;
    }

    // Xử lý xóa sinh viên
    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable String id) {
        Service.deleteById(id);
        return "redirect:/students";
    }
}
