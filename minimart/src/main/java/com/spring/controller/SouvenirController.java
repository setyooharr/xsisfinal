package com.spring.marcom174.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.model.MenuModel;
import com.spring.marcom174.model.SouvenirModel;
import com.spring.marcom174.model.UnitModel;
import com.spring.marcom174.service.MenuService;
import com.spring.marcom174.service.SequenceService;
import com.spring.marcom174.service.SouvenirService;
import com.spring.marcom174.service.UnitService;

@Controller
public class SouvenirController extends BaseController{

	@Autowired
	private SouvenirService souvenirService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired 
	private UnitService unitService;
	
	@Autowired
	private MenuService menuService;
	
	public void aksesLogin(Model model) {	
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		Integer idRole = this.getUserModel().getIdRole();
		menuModelList = this.menuService.searchByRole(idRole);
		
		model.addAttribute("menuModelList",  menuModelList);
		model.addAttribute("username", this.getUserModel().getUsername());
		model.addAttribute("password", this.getUserModel().getPassword());
		
	}
	
	@RequestMapping(value="souvenir")
	public String souvenir(Model model) {
		this.aksesLogin(model);
		this.listDataUnit(model);
		String jsp = "souvenir/souvenir";
		return jsp;	
	}
	
	@RequestMapping(value="souvenir/add")
	public String souvenirAdd(Model model) {
		String kodeAuto ="";
		kodeAuto = this.kodeGenerator();
		model.addAttribute("kodeAuto", kodeAuto);
		
		this.listDataUnit(model);
		
		String jsp = "souvenir/add";
		return jsp;
	}
	
	public String kodeGenerator() {
		Integer idSouvenir = 0;
		idSouvenir = this.sequenceService.nextIdSouvenir();
		
		String kodeAuto ="";
		if (idSouvenir < 10) {
			kodeAuto = "SV000" + idSouvenir;
		}else if (idSouvenir >= 10 && idSouvenir < 100) {
			kodeAuto = "SV00" + idSouvenir;
		}else if (idSouvenir >= 100 && idSouvenir < 1000) {
			kodeAuto = "SV0" + idSouvenir;
		}else if (idSouvenir >=1000) {
			kodeAuto = "SV" + idSouvenir;
		}else {
			
		}
		
		return kodeAuto;
	}
	@SuppressWarnings("unused")
	private void listDataUnit(Model model) {
		List<UnitModel> unitModelList = new ArrayList<UnitModel>();
		unitModelList = this.unitService.select();
		model.addAttribute("unitModelList", unitModelList);
	}
	
	@RequestMapping(value="souvenir/add/save")
	public String souvenirAddSave(HttpServletRequest request,Model model) throws Exception {
		String souvenircodeTerima = request.getParameter("kode");
		String souvenirnameTerima = request.getParameter("nama");
		Integer idUnitTerima = Integer.valueOf(request.getParameter("idUnit"));
		String deskripsiTerima = request.getParameter("desc");
		
		SouvenirModel souvenirModel = new SouvenirModel();
		
		souvenirModel.setCode(souvenircodeTerima);
		souvenirModel.setName(souvenirnameTerima);
		souvenirModel.setIdUnit(idUnitTerima);
		souvenirModel.setDesc(deskripsiTerima);
		
		souvenirModel.setxIsDelete(0);
		String xCreatedBy = this.getUserModel().getUsername();
		souvenirModel.setxCreatedBy(xCreatedBy);
		souvenirModel.setxCreatedDate(new Date());
		
		this.souvenirService.create(souvenirModel);
		model.addAttribute("souvenirModel", souvenirModel);
		
		String jsp = "souvenir/souvenir";
		return jsp;
	}
	@RequestMapping(value="souvenir/list")
	public String souvenirList(Model model) {
		List<SouvenirModel> souvenirModelList = new ArrayList<SouvenirModel>();
		souvenirModelList = this.souvenirService.selectNotDelete();
		model.addAttribute("souvenirModelList", souvenirModelList);
		
		this.listDataUnit(model);
		
		String jsp = "souvenir/list";
		return jsp;
	}
	
	@RequestMapping(value="souvenir/detail")
	public String userDetail(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		SouvenirModel souvenirModel = new SouvenirModel();
		souvenirModel = this.souvenirService.searchbyId(id);
		model.addAttribute("souvenirModel", souvenirModel);
		
		this.listDataUnit(model);
		
		String jsp = "souvenir/detail";
		return jsp;
	}
	@RequestMapping(value="souvenir/edit")
	public String userEdit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		SouvenirModel souvenirModel = new SouvenirModel();
		souvenirModel = this.souvenirService.searchbyId(id);
		model.addAttribute("souvenirModel", souvenirModel);
		
		this.listDataUnit(model);
		
		String jsp = "souvenir/edit";
		return jsp;
	}
	@RequestMapping(value="souvenir/edit/save")
	public String souvenirEditSave(HttpServletRequest request,Model model) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		String souvenircodeTerima = request.getParameter("code");
		String souvenirnameTerima = request.getParameter("nama");
		Integer idUnitTerima = Integer.valueOf(request.getParameter("idUnit"));
		String deskripsiTerima = request.getParameter("desc");
		
		SouvenirModel souvenirModelDB = new SouvenirModel();
		souvenirModelDB = this.souvenirService.searchbyId(id);
		
		
		souvenirModelDB.setCode(souvenircodeTerima);
		souvenirModelDB.setName(souvenirnameTerima);
		souvenirModelDB.setIdUnit(idUnitTerima);
		souvenirModelDB.setDesc(deskripsiTerima);
		
		souvenirModelDB.setxIsDelete(0);
		String xUpdateBy = this.getUserModel().getUsername();
		souvenirModelDB.setxUpdatedBy(xUpdateBy);
		souvenirModelDB.setxUpdatedDate(new Date());
		
		this.souvenirService.update(souvenirModelDB);
		model.addAttribute("souvenirModel", souvenirModelDB);
		
		String jsp = "souvenir/souvenir";
		return jsp;
	}
	
	@RequestMapping(value="souvenir/delete")
	public String souvenirDelete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		SouvenirModel souvenirModel = new SouvenirModel();
		souvenirModel = this.souvenirService.searchbyId(id);
		model.addAttribute("souvenirModel", souvenirModel);
		
		this.listDataUnit(model);
		
		String jsp = "souvenir/delete";
		return jsp;
	}
	@RequestMapping(value="souvenir/delete/save")
	public String souvenirDeleteSave(HttpServletRequest request, Model model) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		SouvenirModel souvenirModel = new SouvenirModel();
		souvenirModel = this.souvenirService.searchbyId(id);
		
		souvenirModel.setxIsDelete(1);
		
		this.souvenirService.update(souvenirModel);
		
		
		
		String jsp = "souvenir/souvenir";
		
		return jsp;
	}
	
	
}
