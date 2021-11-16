package com.springboot.webapplication.controller;

import com.springboot.webapplication.model.MataKuliah;
import com.springboot.webapplication.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MataKuliahController {

    @Autowired
    private MataKuliahService mataKuliahService;

    //Display list matakuliah
    @GetMapping("matakuliah")
    public String viewHomePageMataKuliah(Model model){
        model.addAttribute("listMataKuliah", mataKuliahService .getAllMataKuliah());
        return "matakuliah";
    }

    @GetMapping("/tambahMataKuliahForm")
    public String tambahMataKuliahForm(Model model){
        //Tambah matakuliah
        MataKuliah mataKuliah = new MataKuliah();
        model.addAttribute("matakuliah", mataKuliah);
        return "add_matakuliah";
    }

    @PostMapping("/saveMataKuliah")
    public String saveMataKuliah(@ModelAttribute("matakuliah") MataKuliah mataKuliah){
        // Save matakuliah
        mataKuliahService.saveMataKuliah(mataKuliah);
        return "redirect:matakuliah";
    }

    @GetMapping("/updateMataKuliahForm/{id}")
    public String updateMataKuliahForm(@PathVariable( value = "id") long id, Model model){

        //Get matakuliah from service
        MataKuliah mataKuliah = mataKuliahService.getMataKUliahById(id);

        //Set mahasiswa as a model
        model.addAttribute("matakuliah", mataKuliah);
        return "update_matakuliah";
    }

    @GetMapping("/deleteMataKuliah/{id}")
    public String deleteMataKuliah(@PathVariable (value = "id") long id){

        //Panggil Delete method
        this.mataKuliahService.deleteMataKuliahByID(id);
        return "redirect:../matakuliah";
    }



}
