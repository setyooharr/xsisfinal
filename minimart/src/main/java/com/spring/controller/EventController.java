package com.spring.marcom174.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.service.SequenceService;

@Controller
public class EventController {	
	
	@Autowired
	private SequenceService sequenceService;
	
	@RequestMapping(value="event_request")
	public String event() {
		String jsp = "event_request/event_request";
		return jsp;
	}
	
	@RequestMapping(value="event_request/add")
	public String eventAdd(Model model) {
		
		String codeAuto ="l";
		codeAuto  = this.codeEventGenerator();
		model.addAttribute("codeAuto", codeAuto);
		
		String jsp = "event_request/add";
		return jsp;
	}
	
	public String codeEventGenerator() {
		Integer idEvent = 0;
		idEvent = this.sequenceService.nextIdEvent();
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		String tgl = sdf.format(new Date());
		
		String codeAuto ="";
		if (idEvent < 10) {
			codeAuto = "TRWOEV" +tgl +"0000"+ idEvent;
		}else if (idEvent >= 10 && idEvent < 100) {
			codeAuto = "TRWOEV" +tgl +"000"+ idEvent;
		}else if (idEvent >= 100 && idEvent < 1000) {
			codeAuto = "TRWOEV" +tgl +"00"+ idEvent;
		}else if (idEvent >=1000 && idEvent < 10000) {
			codeAuto = "TRWOEV" +tgl +"0"+ idEvent;
		}else if(idEvent >=10000) {
			codeAuto = "TRWOEV" +tgl+ idEvent;
		}else {
			
		}
		
		return codeAuto;
	}
}
