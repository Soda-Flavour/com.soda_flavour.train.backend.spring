package oauth2.server;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationCorsFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    // @Override
    // public void destroy() {
    // }

    // @Override
    // public void init(FilterConfig config) throws ServletException {
    // }

//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Headers","content-type, x-gwt-module-base, x-gwt-permutation, clientid, longpush");
//
//        filterChain.doFilter(request, response);
//    }


  // @Bean
  // public CorsConfigurationSource corsConfigurationSource() {
  //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
  //     CommonOAuth2Provider d;
  //     CorsConfiguration configuration = new CorsConfiguration();
  //     configuration.setMaxAge(86400l);
  //     configuration.setAllowedOrigins(Arrays.asList("*"));
  //     configuration.setAllowCredentials(true);
  //     configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
  //     configuration.setAllowedHeaders(Arrays.asList("*"));
  //     configuration.setExposedHeaders(Arrays.asList("Authorization", "xsrf-token", "content-type", "content-Disposition", "content-transfer-encoding"));
  //     source.registerCorsConfiguration("/**", configuration);
  //     return source;
  // }  

    // @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// 	return new WebMvcConfigurer() {
	// 		@Override
	// 		public void addCorsMappings(CorsRegistry registry) {
	// 			registry.addMapping("/**")
	// 						.allowedOrigins("*")
	// 						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
	// 						.allowCredentials(true)
	// 						.allowedHeaders("*")
	// 						.exposedHeaders("Authorization", "xsrf-token", "content-type", "content-Disposition", "content-transfer-encoding");
	// 		}
	// 	};
	// }

}

