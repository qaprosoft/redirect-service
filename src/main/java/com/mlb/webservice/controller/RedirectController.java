package com.mlb.webservice.controller;

import com.mlb.webservice.utils.VelocityUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class RedirectController {

	private static final String REDIRECT_VM = "templates/redirect.vm";

	private static final String URL_KEY = "url";

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	@ResponseBody
	public String redirect(@RequestParam("url") String url) {

		return VelocityUtils.mergeTemplate(URL_KEY, url, REDIRECT_VM);

	}

}
