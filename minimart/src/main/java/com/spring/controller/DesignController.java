package com.spring.marcom174.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.model.DesignDetailModel;
import com.spring.marcom174.model.DesignModel;
import com.spring.marcom174.model.EventModel;
import com.spring.marcom174.model.MenuModel;
import com.spring.marcom174.model.ProductModel;
import com.spring.marcom174.model.UserModel;
import com.spring.marcom174.service.DesignDetailService;
import com.spring.marcom174.service.DesignService;
import com.spring.marcom174.service.EventService;
import com.spring.marcom174.service.MenuService;
import com.spring.marcom174.service.ProductService;
import com.spring.marcom174.service.SequenceService;
import com.spring.marcom174.service.UserService;

@Controller
public class DesignController extends BaseController {
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private DesignService DesignService;
	
	@Autowired
	private DesignDetailService designDetailService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	public void aksesLogin(Model model) {
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		Integer idRole = this.getUserModel().getIdRole();
		menuModelList = this.menuService.searchByRole(idRole);
		
		model.addAttribute("menuModelList", menuModelList);
		model.addAttribute("username", this.getUserModel().getUsername());
		model.addAttribute("password", this.getUserModel().getPassword());
	}
	
	@RequestMapping(value="designRequest")
	public String design(Model model) {
		this.aksesLogin(model);
		String jsp = "designRequest/designRequest";
		return jsp;
	}
	
	@RequestMapping(value="designRequest/add")
	public String designAdd(Model model) {
		
		String codeAuto ="";
		codeAuto  = this.codeDesignGenerator();
		model.addAttribute("codeAuto", codeAuto);
		
		UserModel requestByUser = this.getUserModel();
		model.addAttribute("requestByUser", requestByUser);
		
		Integer requestBy = this.getUserModel().getId();
		model.addAttribute("requestBy", requestBy);
		
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		String requestDate = sdf.format(new Date());
		model.addAttribute("requestDate", requestDate);
		
		this.listEventModel(model);
		this.listProductModel(model);
		
		String jsp = "designRequest/add";
		return jsp;
	}
	
	@RequestMapping(value="designRequest/add/save")
	public String designRequestAddSave(HttpServletRequest request, Model model) throws Exception {
		String designCodeTerima = request.getParameter("trCode");
		Integer eventCodeTerima = Integer.valueOf(request.getParameter("eventCode"));
		Integer requestByTerima = Integer.valueOf(request.getParameter("requestBy"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date requestDateTerima = sdf.parse(request.getParameter("requestDate"));
		
		String designTitleTerima = request.getParameter("designTitle");
		String noteTerima = request.getParameter("note");
		
		DesignModel designModel = new DesignModel();
		
		designModel.setCode(designCodeTerima);
		designModel.settEventId(eventCodeTerima);
		designModel.setRequestBy(requestByTerima);
		designModel.setRequestdate(requestDateTerima);
		designModel.setTitleHeader(designTitleTerima);
		designModel.setNote(noteTerima);
		
		designModel.setStatus(1);
		
		designModel.setIsDelete(0);
		Integer createdBy = this.getUserModel().getId();
		designModel.setCreatedBy(createdBy);
		designModel.setCreatedDate(new Date());
		
		this.DesignService.create(designModel);
		model.addAttribute("designModel",designModel);
		
		String jumlahDetail = request.getParameter("nomorBaris");
		int jumlahDetailInteger = Integer.valueOf(jumlahDetail)+1;
		
		for (int i = 0; i < jumlahDetailInteger; i++) {
			if (request.getParameter("productName_"+i) != null) {
				String product = request.getParameter("productName_"+i);
				String[] result = product.split("-");
				
				Integer idProduct = Integer.valueOf(result[0]);
				// String productDescTerima = request.getParameter("productDesc_" + i);
				String titleDetailDiterima = request.getParameter("title_"+i);
				String picDetailTerima = request.getParameter("requestPic_" + i);
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
				Date dueDateTerima = sdf2.parse(request.getParameter("data3_" + i));
				/*Date starDateTerima = sdf2.parse(request.getParameter("starDate_" + i));
				Date endDateTerima = sdf2.parse(request.getParameter("endDate_" + i));*/
				String noteDetailTerima = request.getParameter("note_" + i);
				
				DesignDetailModel designDetailModel = new DesignDetailModel();
				
				designDetailModel.setId(designModel.getId());
				designDetailModel.setmProductId(idProduct);
				designDetailModel.setTitleItem(titleDetailDiterima);
				designDetailModel.setRequestPic(picDetailTerima);
				designDetailModel.setRequestDueDate(dueDateTerima);
//				designDetailModel.setStartDate(startDateTerima);
//				designDetailModel.setEndDate(endDateDiterima);
				designDetailModel.setNote(noteDetailTerima);
				
				designDetailModel.setIsDelete(0);
				Integer createdBy1 = this.getUserModel().getId();
				designDetailModel.setCreatedBy(createdBy1);
				designDetailModel.setCreatedDate(new Date());
				
				this.designDetailService.create(designDetailModel);
			}
		}
		
		String jsp = "designRequest/designRequest";
		return jsp;
	}
	
	@RequestMapping(value = "designRequest/list")
	private String designRequestList(Model model) {
		List<DesignModel> designModelList = new ArrayList<DesignModel>();
		designModelList = this.DesignService.selectNotDelete();
		model.addAttribute("designModelList", designModelList);
		
		String jsp = "designRequest/list";
		return jsp;
	}
	
	@RequestMapping(value="designRequest/detail")
	public String designDetail(HttpServletRequest request, Model model) {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		DesignModel designModel = new DesignModel();
		
		String codeAuto ="";
		codeAuto  = this.codeDesignGenerator();
		model.addAttribute("codeAuto", codeAuto);
		
		designModel = this.DesignService.searchById(id);
		model.addAttribute("designModel", designModel);
		
		UserModel requestByUser = this.getUserModel();
		model.addAttribute("requestByUser", requestByUser);
		
		Integer requestBy = this.getUserModel().getId();
		model.addAttribute("requestBy", requestBy);
		
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		String requestDate = sdf.format(new Date());
		model.addAttribute("requestDate", requestDate);
		
		this.listEventModel(model);
		this.listProductModel(model);
		
		String jsp = "designRequest/detail";
		return jsp;
	}

	public String codeDesignGenerator() {
		Integer idDesign = 0;
		idDesign = this.sequenceService.nextIdDesign();
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		String tgl = sdf.format(new Date());
		
		String codeAuto = "";
		if (idDesign < 10) {
			codeAuto = "TRWODS" +tgl +"0000"+ idDesign;
		}else if (idDesign >= 10 && idDesign < 100) {
			codeAuto = "TRWODS" +tgl +"000"+ idDesign;
		}else if (idDesign >= 100 && idDesign < 1000) {
			codeAuto = "TRWODS" +tgl +"00"+ idDesign;
		}else if (idDesign >=1000 && idDesign < 10000) {
			codeAuto = "TRWODS" +tgl +"0"+ idDesign;
		}else if(idDesign >=10000) {
			codeAuto = "TRWODS" +tgl+ idDesign;
		}else {
			
		}
		return codeAuto;
	}
	
	
	private void listProductModel(Model model) {
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		productModelList = this.productService.select();
		model.addAttribute("productModelList", productModelList);
	}
	
	private void listEventModel(Model model) {
		List<EventModel> eventModelList = new ArrayList<EventModel>();
		eventModelList = this.eventService.select();
		model.addAttribute("eventModelList", eventModelList);
		
	}
	
	@SuppressWarnings("unused")
	private void listDataUser(Model model) {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		userModelList = this.userService.select();
		model.addAttribute("userModelList", userModelList);
	}
	
	
}
