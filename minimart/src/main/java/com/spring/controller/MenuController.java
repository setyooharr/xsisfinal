package com.spring.marcom174.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.model.MenuModel;
import com.spring.marcom174.service.MenuService;
import com.spring.marcom174.service.SequenceService;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@RequestMapping(value="menu")
	public String menu() {
		String jsp = "menu/menu";
		
		return jsp;
	}
	
	@RequestMapping(value="menu/add")
	public String menuAdd(Model model) {
		String kodeAuto ="";
		kodeAuto = this.kodeGenerator();
		model.addAttribute("kodeAuto", kodeAuto);
		
		String jsp = "menu/add";
		return jsp;
	}
	
	
	@RequestMapping(value="menu/add/save")
	public String menuAddSave(HttpServletRequest request, Model model) throws Exception {
		String kodeTerima = request.getParameter("kode"); //variable name, untuk controller
		String namaTerima = request.getParameter("nama");
		String controllerTerima = request.getParameter("controller");
		
		
		MenuModel menuModel = new MenuModel();
		
		menuModel.setKode(kodeTerima);
		menuModel.setNama(namaTerima);
		menuModel.setController(controllerTerima);
		
		this.menuService.create(menuModel);
		model.addAttribute("menuModel", menuModel);
		
		String jsp = "menu/menu";
		
		return jsp;
	}
	
	@RequestMapping(value="menu/list")
	public String menuList(Model model) {
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = this.menuService.select();
		model.addAttribute("menuModelList", menuModelList);
		
		
		String jsp = "menu/list";
		return jsp;
	}
	
	@RequestMapping(value="menu/detail")
	public String menuDetail(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchbyId(id);
		model.addAttribute("menuModel", menuModel);
		
		String jsp = "menu/detail";
		return jsp;
	}
	
	@RequestMapping(value="menu/delete")
	public String menuDelete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchbyId(id);
		model.addAttribute("menuModel", menuModel);
		
		String jsp = "menu/delete";
		return jsp;
	}
	
	@RequestMapping(value="menu/delete/save")
	public String menuDeleteSave(HttpServletRequest request, Model model) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchbyId(id);
		this.menuService.delete(menuModel);
		
		
		String jsp = "menu/menu";
		
		return jsp;
	}
	
	@RequestMapping(value="menu/edit")
	public String menuEdit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchbyId(id);
		model.addAttribute("menuModel", menuModel);
		
		String jsp = "menu/edit";
		return jsp;
	}
	
	@RequestMapping(value="menu/edit/save")
	public String menuEditSave(HttpServletRequest request, Model model) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		String kodeTerima = request.getParameter("kode"); //variable name, untuk controller
		String namaTerima = request.getParameter("nama");
		String controllerTerima = request.getParameter("controller");
		
		
		MenuModel menuModelDB = new MenuModel();
		menuModelDB = this.menuService.searchbyId(id);
		
		menuModelDB.setKode(kodeTerima);
		menuModelDB.setNama(namaTerima);
		menuModelDB.setController(controllerTerima);
	
		
		this.menuService.update(menuModelDB);
		model.addAttribute("menuModel", menuModelDB);
		
		String jsp = "menu/menu";
		
		return jsp;
	}
	
	public String kodeGenerator() {
		Integer idMenu = 0;
		idMenu = this.sequenceService.nextIdMenu();
		
		String kodeAuto ="";
		if (idMenu < 10) {
			kodeAuto = "MEN000" + idMenu;
		}else if (idMenu >= 10 && idMenu < 100) {
			kodeAuto = "MEN00" + idMenu;
		}else if (idMenu >= 100 && idMenu < 1000) {
			kodeAuto = "MEN0" + idMenu;
		}else if (idMenu >=1000) {
			kodeAuto = "MEN" + idMenu;
		}else {
			
		}
		
		return kodeAuto;
	}
}
