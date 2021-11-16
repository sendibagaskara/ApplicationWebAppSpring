package com.springboot.webapplication.controller;

import com.springboot.webapplication.model.Fakultas;
import com.springboot.webapplication.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FakultasController {
    @Autowired
    private FakultasService fakultasService;
    //Display list fakultas
    @GetMapping("fakultas")
    public String viewHomePageFakultas(Model model){
        model.addAttribute("listFakultas", fakultasService.getAllFakultas());
        return "fakultas";
    }

    @GetMapping("/tambahFakultasForm")
    public String tambahFakultasForm(Model model){
        //Tambah Fakultas
        Fakultas fakultas = new Fakultas();
        model.addAttribute("fakultas", fakultas);
        return "add_fakultas";
    }

    @PostMapping("/saveFakultas")
    public String saveFakultas(@ModelAttribute("fakultas") Fakultas fakultas){
        // Save Fakultas
        fakultasService.saveFakultas(fakultas);
        return "redirect:fakultas";
    }

    @GetMapping("/updateFakultasForm/{id}")
    public String updateFakultasForm(@PathVariable( value = "id") long id, Model model){

        //Get fakultas from service
        Fakultas fakultas = fakultasService.getFakultasById(id);

        //Set fakultas as a model
        model.addAttribute("fakultas", fakultas);
        return "update_fakultas";
    }

    @GetMapping("/deleteFakultas/{id}")
    public String deleteFakultas(@PathVariable (value = "id") long id){

        //Panggil Delete method
        this.fakultasService.deleteFakultasByID(id);
        return "redirect:../fakultas";
    }
}
