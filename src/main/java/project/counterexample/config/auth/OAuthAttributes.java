package project.counterexample.config.auth;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.counterexample.domain.type.ProviderType;
import project.counterexample.domain.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes = new HashMap<>();

    public OAuthAttributes(String provider, Map<String, Object> attributes) {
        for (String key : attributes.keySet()) {
            this.attributes.put(key, attributes.get(key));
        }
        this.attributes.put("provider", ProviderType.fromStr(provider));
    }

    public User toEntity() {
        return User.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .provider((ProviderType) attributes.get("provider"))
                .subId((String) attributes.get("sub"))
                .build();
    }

    @WebFilter("/*")
    @Component
    public static class CORSFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "content-type");
            filterChain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void destroy() {

        }
    }
}