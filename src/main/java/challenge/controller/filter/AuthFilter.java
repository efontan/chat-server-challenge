package challenge.controller.filter;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import challenge.service.SessionService;

@Component
public class AuthFilter
    extends GenericFilterBean {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);
    
    @Autowired
    private SessionService sessionService;
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
        throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String token = this.extractTokenFromHeader(httpRequest);
        LOGGER.debug("Auth token: {}", token);
        
        if (!this.sessionService.isValidSession(token)) {
            // reject
            LOGGER.error("Invalid token: {}", token);
            ((HttpServletResponse) servletResponse).sendError(SC_UNAUTHORIZED, "The token is not valid.");
            return;
        }
        
        chain.doFilter(servletRequest, servletResponse);
    }
    
    private String extractTokenFromHeader(HttpServletRequest httpRequest) {
        Optional<String> maybeAuthHeader = Optional.ofNullable(httpRequest.getHeader("Authorization"));
        
        if (maybeAuthHeader.isPresent()) {
            try {
                String[] splitedHeader = maybeAuthHeader.get().split(" ");
                return splitedHeader[1];
            } catch (Exception e) {
                LOGGER.error("Error extracting auth header from request {} {}", e.getMessage(), e);
            }
        }
        return Strings.EMPTY;
    }
    
}
