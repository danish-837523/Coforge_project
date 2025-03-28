package org.macquarie.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.macquarie.constants.MacquarieConstants;
import org.macquarie.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class AuthenticationFilter extends OncePerRequestFilter {

    @Value("${macquarie.security.enabled}")
    private boolean isSecurityEnabled;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(isSecurityEnabled){
            String keyvalue = request.getHeader(MacquarieConstants.HEADER);
            if (null==keyvalue || !MacquarieConstants.SAN_VALUE.equals(keyvalue)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setCode("INVALID_SAN_KEY");
                errorResponse.setMessage("Invalid SAN Key");
                errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
                errorResponse.setTraceId(request.getHeader("Trace-Id"));
                response.setContentType(MacquarieConstants.CONTENT_TYPE_APP_JSON);
                response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
                return;
            }
        }
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken("apiKeyUser", null, null));
        filterChain.doFilter(request, response);
    }
}
