package com.gb.oembed.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gb.oembed.model.OembedResponse;
import com.gb.oembed.model.Ores;

@Service
public class OEmbedService {
	public List<OembedResponse> getOembedResponses(String url){
		String json = "";
		Ores root = null;
		try {
			URL url_result = new URL(url);
			
			 BufferedReader bf;
	         String r = "";
	         // url 로 지정한 요청으로부터 받은 json 데이터를 1줄씩 읽어서 string으로 연결하기
	         bf = new BufferedReader(new InputStreamReader(url_result.openStream(), "UTF-8"));
	         while ((r = bf.readLine()) != null) {

	            json = json.concat(r);
	         }
	         System.out.println(json);
	         
	         
	         ObjectMapper mapper = new ObjectMapper();
	         mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // java 오브젝트에 없는 프로퍼티로 생기는 오류 발생하지 않도록 설정
	     	  
	         root = mapper.readValue(json, Ores.class); 
	         
	         System.out.println(root);
	     
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return root.getOres();
		
	
	}
	
}
