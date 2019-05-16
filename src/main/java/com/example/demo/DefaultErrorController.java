package com.example.demo;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class DefaultErrorController implements ErrorController {

	private static final String PATH = "/error";
	
	@Autowired
    private ErrorAttributes errorAttributes;
	
	@Override
	public String getErrorPath() {
		return PATH;
	}

	@RequestMapping(PATH)
	String error(HttpServletRequest request, WebRequest webRequest) {
		
		Map<String, Object> attributes = getErrorAttributes(webRequest, false);
		String exception = (String) attributes.get(RequestDispatcher.ERROR_EXCEPTION);
		
		return "test";
    }
	
	private Map<String, Object> getErrorAttributes(WebRequest request, boolean includeStackTrace) {
        return errorAttributes.getErrorAttributes(request, includeStackTrace);
    }
	
}
