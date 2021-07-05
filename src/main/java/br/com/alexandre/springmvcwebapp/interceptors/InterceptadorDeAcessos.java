package br.com.alexandre.springmvcwebapp.interceptors;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class InterceptadorDeAcessos implements HandlerInterceptor {
	
	public static List<Acesso> acessos = new ArrayList<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Acesso acesso = new Acesso();
		acesso.setMomentoExato(LocalDateTime.now());
		acesso.setPath(request.getRequestURI());
		
		request.setAttribute("acesso", acesso);
		
		return true;
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.setDuracao(Duration.between(acesso.getMomentoExato(), LocalDateTime.now()));
		acessos.add(acesso);
	}

	public class Acesso {
		private Duration duracao;
		private LocalDateTime momentoExato;
		private String path;

		public Duration getDuracao() {
			return duracao;
		}

		public void setDuracao(Duration duracao) {
			this.duracao = duracao;
		}

		public LocalDateTime getMomentoExato() {
			return momentoExato;
		}

		public void setMomentoExato(LocalDateTime momentoExato) {
			this.momentoExato = momentoExato;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

	}

}
