package com.arthur_dev21.tarefadiarias;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    
	@GetMapping(path = "/")
	public String index() {
		return "index";
	}
}
