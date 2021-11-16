package com.springboot.webapplication.controller;


import com.springboot.webapplication.model.Mahasiswa;
import com.springboot.webapplication.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    //Display list mahasiswa
    @GetMapping("mahasiswa")
    public String viewHomePage(Model model){
        model.addAttribute("listMahasiswa", mahasiswaService.getAllMahasiswa());
        return "mahasiswa";
    }

    @GetMapping("/tambahMahasiswaForm")
    public String tambahMahasiswaForm(Model model){
        //Tambah Mahasiswa
        Mahasiswa mahasiswa = new Mahasiswa();
        model.addAttribute("mahasiswa", mahasiswa);
        return "add_mahasiswa";
    }

    @PostMapping("/saveMahasiswa")
    public String saveMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa){
        // Save Mahasiswa
        mahasiswaService.saveMahasiswa(mahasiswa);
        return "redirect:mahasiswa";
    }

    @GetMapping("/updateMahasiswaForm/{id}")
    public String updateMahasiswaForm(@PathVariable ( value = "id") long id, Model model){

        //Get mahasiswa from service
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaById(id);

        //Set mahasiswa as a model
        model.addAttribute("mahasiswa", mahasiswa);
        return "update_mahasiswa";
    }

    @GetMapping("/deleteMahasiswa/{id}")
    public String deleteMahasiswa(@PathVariable (value = "id") long id){

        //Panggil Delete method
        this.mahasiswaService.deleteMahasiswaById(id);
        return "redirect:../mahasiswa";
    }
}
