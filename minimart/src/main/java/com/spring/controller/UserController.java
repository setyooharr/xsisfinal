package com.spring.marcom174.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.model.CompanyModel;
import com.spring.marcom174.model.EmployeeModel;
import com.spring.marcom174.model.MenuModel;
import com.spring.marcom174.model.RoleModel;
import com.spring.marcom174.model.UserModel;
import com.spring.marcom174.service.CompanyService;
import com.spring.marcom174.service.EmployeeService;
import com.spring.marcom174.service.MenuService;
import com.spring.marcom174.service.RoleService;
import com.spring.marcom174.service.UserService;

@Controller
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompanyService companyService;
	
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
	
	@RequestMapping(value="user")
	public String user(Model model) {
		this.listDataRole(model);
		this.listDataEmployee(model);
		this.listDataCompany(model);
		String jsp = "user/user";
		return jsp;
	}
	
	@RequestMapping(value="user/add")
	public String userAdd(Model model) {
		this.listDataRole(model);
		this.listDataEmployee(model);
		this.listDataCompany(model);
		
		String jsp = "user/add";
		return jsp;
	}
	
	@RequestMapping(value="user/add/save")
	public String userAddSave(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserModel userModel = new UserModel();
		
		//join table rolemodel
		Integer idRole = Integer.valueOf(request.getParameter("idRole"));
		
		//join table employeeModel
		Integer idEmployee = Integer.valueOf(request.getParameter("idEmployee"));
		
		userModel.setUsername(username);
		userModel.setPassword(password);
		
		//join table role
		userModel.setIdRole(idRole);
			
		//join table employee
		userModel.setIdEmployee(idEmployee);
		
		// ================= set audittrail created==========
		userModel.setIsDelete(0); //artinya blm dihapus
		String CreatedBy = this.getUserModel().getUsername();
		userModel.setCreatedBy(CreatedBy);
		userModel.setCreatedDate(new Date());
		// ================= set audittrail created =========	
		
		this.userService.create(userModel);
		model.addAttribute("userModel", userModel);
		
		String jsp = "user/user";
		return jsp;
	}
	
	@RequestMapping(value="user/list")
	public String userList(Model model) {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		userModelList = this.userService.select();
		model.addAttribute("userModelList", userModelList);
		
		String jsp = "user/list";
		return jsp;
	}
	
	@RequestMapping(value="user/detail")
	public String userDetail(HttpServletRequest request,Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		UserModel userModel = new UserModel();
		userModel = this.userService.searchById(id);
		
		this.listDataRole(model);
		this.listDataEmployee(model);
		this.listDataCompany(model);

		model.addAttribute("userModel", userModel);
		
		String jsp = "user/detail";
		return jsp;
	}
	
	@RequestMapping(value="user/delete")
	public String userDelete(HttpServletRequest request,Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		UserModel userModel = new UserModel();
		userModel = this.userService.searchById(id);
		model.addAttribute("userModel", userModel);
		
		this.listDataRole(model);
		this.listDataEmployee(model);
		this.listDataCompany(model);

		String jsp = "user/delete";
		return jsp;
	}
	
	@RequestMapping(value="user/delete/save")
	public String userDeleteSave(HttpServletRequest request,Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		UserModel userModel = new UserModel();
		userModel = this.userService.searchById(id);
		this.userService.delete(userModel);
		
		String jsp = "user/user";
		return jsp;
	}
	
	@RequestMapping(value="user/edit")
	public String userEdit(HttpServletRequest request,Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		UserModel userModel = new UserModel();
		userModel = this.userService.searchById(id);
		model.addAttribute("userModel", userModel);
		
		this.listDataRole(model);
		this.listDataEmployee(model);
		this.listDataCompany(model);

		String jsp = "user/edit";
		return jsp;
	}
	
	@RequestMapping(value="user/edit/save")
	public String userEditSave(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//join table ke role
		Integer idRole = Integer.valueOf(request.getParameter("idRole"));
		
		//join table ke employee
		Integer idEmployee = Integer.valueOf(request.getParameter("idEmployee"));
		
		UserModel userModelDB = new UserModel();
		userModelDB = this.userService.searchById(id);
		
		userModelDB.setUsername(username);
		userModelDB.setPassword(password);
		//join ke role
		userModelDB.setIdRole(idRole);
		
		//join ke employee
		userModelDB.setIdEmployee(idEmployee);
		
		// ================= set audittrail created==========
		userModelDB.setIsDelete(0); //artinya blm dihapus
		String CreatedBy = this.getUserModel().getUsername();
		userModelDB.setCreatedBy(CreatedBy);
		userModelDB.setUpdatedDate(new Date());
		// ================= set audittrail created =========	
					
		this.userService.update(userModelDB);
		model.addAttribute("userModelDB", userModelDB);
		
		String jsp = "user/user";
		return jsp;
	}
	
	private void listDataRole(Model model) {
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = this.roleService.select();
		model.addAttribute("roleModelList", roleModelList);
	}
	
	private void listDataEmployee(Model model) {
		List<EmployeeModel> employeeModelList = new ArrayList<EmployeeModel>();
		employeeModelList = this.employeeService.select();
		model.addAttribute("employeeModelList", employeeModelList);
	}
	
	private void listDataCompany(Model model) {
		List<CompanyModel> companyModelList = new ArrayList<CompanyModel>();
		companyModelList = this.companyService.select();
		model.addAttribute("companyModelList", companyModelList);
	}
	
	/*--- Dropdown List ---*/
	@SuppressWarnings("unused")
	private void listDataUser(Model model) {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		userModelList = this.userService.select();
		model.addAttribute("userMenuList", userModelList);
	}
}
