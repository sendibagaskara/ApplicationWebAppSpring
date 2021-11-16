package com.springboot.webapplication.controller;

import com.springboot.webapplication.model.Jurusan;
import com.springboot.webapplication.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JurusanController {

    @Autowired
    private JurusanService jurusanService;

    //Display list jurusan
    @GetMapping("jurusan")
    public String viewHomePageJurusan(Model model){
        model.addAttribute("listJurusan", jurusanService.getAllJurusan());
        return "jurusan";
    }

    @GetMapping("/tambahJurusanForm")
    public String tambahJurusanForm(Model model){
        //Tambah Jurusan
        Jurusan jurusan = new Jurusan();
        model.addAttribute("jurusan", jurusan);
        return "add_jurusan";
    }

    @PostMapping("/saveJurusan")
    public String saveJurusan(@ModelAttribute("jurusan") Jurusan jurusan){
        // Save Jurusan
        jurusanService.saveJurusan(jurusan);
        return "redirect:jurusan";
    }

    @GetMapping("/updateJurusanForm/{id}")
    public String updateJurusanForm(@PathVariable( value = "id") long id, Model model){

        //Get jurusan from service
        Jurusan jurusan = jurusanService.getJurusanById(id);

        //Set jurusan as a model
        model.addAttribute("jurusan", jurusan);
        return "update_jurusan";
    }

    @GetMapping("/deleteJurusan/{id}")
    public String deleteJurusan(@PathVariable (value = "id") long id){

        //Panggil Delete method
        this.jurusanService.deleteJurusanByID(id);
        return "redirect:../jurusan";
    }
}
