package com.spring.marcom174.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.model.MenuModel;
import com.spring.marcom174.model.RoleModel;
import com.spring.marcom174.model.UserAccessModel;
import com.spring.marcom174.service.MenuService;
import com.spring.marcom174.service.RoleService;
import com.spring.marcom174.service.UserAccessService;


@Controller
public class UserAccessController {

	@Autowired
	private UserAccessService userAccessService;
	
//	@Autowired
//	private SequenceService sequenceService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="userAccess")
	public String userAccess() {
		String jsp = "userAccess/userAccess";
		
		return jsp;
	}
	
	@RequestMapping(value="userAccess/add")
	public String userAccessAdd(Model model) {	
		
		this.listDataRole(model);
		this.listDataMenu(model);
		
		String jsp = "userAccess/add";
		return jsp;
	}
	
	
	@RequestMapping(value="userAccess/add/save")
	public String userAccessAddSave(HttpServletRequest request, Model model) throws Exception {
		Integer idRoleTerima = Integer.valueOf(request.getParameter("idRole")); //variable name, untuk controller
		Integer idMenuTerima = Integer.valueOf(request.getParameter("idMenu"));
		
		UserAccessModel userAccessModel = new UserAccessModel();
		
		userAccessModel.setIdRole(idRoleTerima);
		userAccessModel.setIdMenu(idMenuTerima);
		
		this.userAccessService.create(userAccessModel);
		model.addAttribute("userAccessModel", userAccessModel);
		
		String jsp = "userAccess/userAccess";
		
		return jsp;
	}
	
	@RequestMapping(value="userAccess/list")
	public String userAccessList(Model model) {
		List<UserAccessModel> userAccessModelList = new ArrayList<UserAccessModel>();
		userAccessModelList = this.userAccessService.select();
		model.addAttribute("userAccessModelList", userAccessModelList);
		
		
		String jsp = "userAccess/list";
		return jsp;
	}
	
	@RequestMapping(value="userAccess/detail")
	public String userAccessDetail(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		UserAccessModel userAccessModel = new UserAccessModel();
		userAccessModel = this.userAccessService.searchbyId(id);
		model.addAttribute("userAccessModel", userAccessModel);
		
		this.listDataRole(model);
		this.listDataMenu(model);
		
		String jsp = "userAccess/detail";
		return jsp;
	}
	
	 @RequestMapping(value="userAccess/delete")
	public String userAccessDelete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		UserAccessModel userAccessModel = new UserAccessModel();
		userAccessModel = this.userAccessService.searchbyId(id);
		model.addAttribute("userAccessModel", userAccessModel);
		
		this.listDataRole(model);
		this.listDataMenu(model);
		
		String jsp = "userAccess/delete";
		return jsp;
	}
	
	 @RequestMapping(value="userAccess/delete/save")
	public String userAccessDeleteSave(HttpServletRequest request, Model model) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		UserAccessModel userAccessModel = new UserAccessModel();
		userAccessModel = this.userAccessService.searchbyId(id);
		this.userAccessService.delete(userAccessModel);
		
		
		String jsp = "userAccess/userAccess";
		
		return jsp;
	}
	
	@RequestMapping(value="userAccess/edit")
	public String userAccessEdit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		UserAccessModel userAccessModel = new UserAccessModel();
		userAccessModel = this.userAccessService.searchbyId(id);
		model.addAttribute("userAccessModel", userAccessModel);
		
		this.listDataRole(model);
		this.listDataMenu(model);
		
		String jsp = "userAccess/edit";
		return jsp;
	}
	
	@RequestMapping(value="userAccess/edit/save")
	public String userEditSave(HttpServletRequest request, Model model) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Integer idRoleTerima = Integer.valueOf(request.getParameter("idRole")); //variable name, untuk controller
		Integer idMenuTerima = Integer.valueOf(request.getParameter("idMenu"));
		
		UserAccessModel userAccessModelDB = new UserAccessModel();
		
		userAccessModelDB = this.userAccessService.searchbyId(id);
		
		userAccessModelDB.setIdRole(idRoleTerima);
		userAccessModelDB.setIdMenu(idMenuTerima);
		
		this.userAccessService.update(userAccessModelDB);
		model.addAttribute("userAccessModel", userAccessModelDB);
		
		String jsp = "userAccess/userAccess";
		
		return jsp;
	}
	
	@SuppressWarnings("unused")
	private void listDataRole(Model model){
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = this.roleService.select();
		model.addAttribute("roleModelList", roleModelList);
	}
	
	@SuppressWarnings("unused")
	private void listDataMenu(Model model){
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = this.menuService.select();
		model.addAttribute("menuModelList", menuModelList);
	}
	
}
