package br.com.alexandre.springmvcwebapp.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandre.springmvcwebapp.interceptors.InterceptadorDeAcessos;
import br.com.alexandre.springmvcwebapp.interceptors.InterceptadorDeAcessos.Acesso;

@RestController
@RequestMapping("/api/acessos")
public class AcessosRest {
	
	@GetMapping
	public List<Acesso> getAcessos(){
		return InterceptadorDeAcessos.acessos;
	}

}
