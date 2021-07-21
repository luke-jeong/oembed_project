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
	  public ModelAndView oembed_url(String url){
		  
		  ModelAndView mv = null;
		  ModelMap modelMap = new ModelMap();
	  
			
			/*
			 * String tUrl = url;
			 * 
			 * if(tUrl.contains("www.youtube.com")) { List<OembedResponse> oembedResponse =
			 * service.getOembedResponses(tUrl);
			 * 
			 * String type = ""; String version;
			 * 
			 * for(OembedResponse o : oembedResponse) { type = o.getType(); }
			 * 
			 * modelMap.addAttribute("type",type); modelMap.addAttribute("url",tUrl); mv =
			 * new ModelAndView("result",modelMap); }
			 * 
			 */
		  String tUrl = "";
			if(url.contains("www.youtube.com")) {
				tUrl = "https://www.youtube.com/oembed?url="+url+ "&format=json";
			}else if(url.contains("www.instagram.com")){
				tUrl = "https://api.instagram.com/oembed?url="+url+ "&format=json";
			}else if(url.contains("twitter.com")){
				tUrl = "https://publish.twitter.com/oembed?url="+url+ "&format=json";
			}else if(url.contains("vimeo.com")){
				tUrl = "https://vimeo.com/api/oembed.json?url="+url+ "&format=json";
			}

			  modelMap.addAttribute("url",url);
			  
			  mv = new ModelAndView("result",modelMap);
		  
		  return mv;
	  }
	 

}
