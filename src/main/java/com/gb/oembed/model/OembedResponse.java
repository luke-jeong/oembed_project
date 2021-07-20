package com.gb.oembed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OembedResponse {
	@JsonProperty
	private String type;
	@JsonProperty
	private String author_name;
	@JsonProperty
	private String provider_name;
	@JsonProperty
	private String provider_url;
	@JsonProperty
	private String width;
	@JsonProperty
	private String height;
	@JsonProperty
	private String html;
	@JsonProperty
	private String version;
	@JsonProperty
	private String title;
	@JsonProperty
	private String thumbnail_url;
	@JsonProperty
	private String thumbnail_height;
	@JsonProperty
	private String thumbnail_width;
	
}