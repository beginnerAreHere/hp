package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Controller
@Api("跳转接口")
public class JumpController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ApiOperation("跳转到首页")
	public String home() {
		return "index";
	}
}
