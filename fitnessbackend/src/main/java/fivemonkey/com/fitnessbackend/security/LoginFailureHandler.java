package fivemonkey.com.fitnessbackend.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String redirect = "/login?errorMsg=";
		if(username.isEmpty() || password.isEmpty()) {
			redirect += "Email and password is required!";
		}else if(exception instanceof DisabledException) {
			redirect += "Email is not active";
		}
		else if(exception instanceof BadCredentialsException) {
			redirect += "Email Or Password is invalid!!";
		}
		super.setDefaultFailureUrl(redirect);
		//super.setUseForward(true);
		super.onAuthenticationFailure(request, response, exception);
	}
}
