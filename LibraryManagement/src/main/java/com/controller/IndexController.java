package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/thongtincanhan")
public class IndexController {
	@ModelAttribute("perInfor")
	public PersionalInformationBean perInfor(){
		return new PersionalInformationBean();
	}
	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {

		return "personalinformation";
	}
}
