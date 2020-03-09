package com.spring.marcom174.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.model.UnitModel;
import com.spring.marcom174.service.SequenceService;
import com.spring.marcom174.service.UnitService;

@Controller
public class UnitController {
	
	@Autowired
	private UnitService unitService; 
	@Autowired
	private SequenceService sequenceService;
	
	@RequestMapping(value="unit")
	public String unit() {
		String jsp = "unit/unit";
		return jsp;
	}
	
	@RequestMapping(value="unit/add")
	public String unitAdd(Model model) {
		String kodeAuto ="";
		kodeAuto = this.kodeGenerator();
		model.addAttribute("kodeAuto", kodeAuto);
		String jsp = "unit/add";
		return jsp;
	}
	public String kodeGenerator() {
		Integer idUnit = 0;
		idUnit = this.sequenceService.nextIdUnit();
		
		String kodeAuto ="";
		if (idUnit < 10) {
			kodeAuto = "UN000" + idUnit;
		}else if (idUnit >= 10 && idUnit < 100) {
			kodeAuto = "UN00" + idUnit;
		}else if (idUnit >= 100 && idUnit < 1000) {
			kodeAuto = "UN0" + idUnit;
		}else if (idUnit >=1000) {
			kodeAuto = "UN" + idUnit;
		}else {
			
		}
		
		return kodeAuto;
	}
	
	@RequestMapping(value="unit/add/save")
	public String roleAddSave(HttpServletRequest request, Model model) throws Exception {
		String codeTerima = request.getParameter("kode"); //variable name, untuk controller
		String namaTerima = request.getParameter("nama");
		String descTerima = request.getParameter("desc");

		
		UnitModel unitModel = new UnitModel();
		
		unitModel.setCode(codeTerima);
		unitModel.setNama(namaTerima);
		unitModel.setDesc(descTerima);
		this.unitService.create(unitModel);
		model.addAttribute("unitModel", unitModel);
		
		String jsp = "unit/unit";
		
		return jsp;
	}
	
	@RequestMapping(value="unit/list")
	public String unitList(Model model) {
		List<UnitModel> unitModelList = new ArrayList<UnitModel>();
		unitModelList = this.unitService.select();
		model.addAttribute("unitModelList", unitModelList);
		
		
		String jsp = "unit/list";
		return jsp;
	}

}
