package com.gb.oembed.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gb.oembed.model.OembedResponse;
import com.gb.oembed.service.OEmbedService;

@RestController
public class OEmbedController {

	
      @Autowired
      OEmbedService service;
      
	  @GetMapping(value = "/url_search")	  
	  @ResponseBody
	  public ModelAndView oembed_url(String url) throws ParseException{
		  
		  ModelAndView mv = null;
		  ModelMap modelMap = new ModelMap();
	  
		  String tempUrl = url;
		  
		  if(tempUrl.contains("www.youtube.com")) {
			  List<OembedResponse> oembedResponse = service.getOembedResponses(tempUrl);
			  modelMap.addAttribute(oembedResponse);
			  modelMap.addAttribute("url",tempUrl);
			  mv = new ModelAndView("home",modelMap);
		  }

		  
		  return mv;
	  }
	 

}
