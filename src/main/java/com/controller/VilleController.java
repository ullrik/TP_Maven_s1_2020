package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	
	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String monParam) {
		System.out.println("Appel GET");

		System.out.println("monParam : " + monParam);

		ArrayList<Ville> listeVille = villeBLOService.getInfoVille(monParam);

		return listeVille;
	}
	
	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<Ville> appelPost(@RequestBody Ville ville) {
		System.out.println("Appel GET");

		ArrayList<Ville> listeVille = null ;//villeBLOService.getInfoVille();

		return listeVille;
	}
}
