package login;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyle.bookstore.web.HttpFilter;
public class LoginFilter extends  HttpFilter{
	
    private String sessionKey;
    private String rediretUrl;
    private String uncheckedUrls;
	
    @Override
    protected void init() {
    sessionKey = getFilterConfig().getInitParameter("userSessionKey");
    rediretUrl = getFilterConfig().getInitParameter("rediretPage");
    uncheckedUrls = getFilterConfig().getInitParameter("uncheckedUrls");
      }
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
        //1，获取请求的servletPath
		String servletPath = request.getServletPath();
		//2,检查1获取的servletPath是否为不需要检查的URL 中的一个,若是,则直接放行,方法结束
		List<String> urls = Arrays.asList(uncheckedUrls.split(","));
		//如果每次访问doFilter的servletPath包含在urls则直接可放行
		if(urls.contains(servletPath)){
			filterChain.doFilter(request, response);
			return;
		}
		//3，从session中获取seesionKey对应的值,若值不存在,则重定向到redirectUrl
		Object user = request.getSession().getAttribute("sessionKey");
		if(user == null){
			response.sendRedirect(request.getContextPath()+rediretUrl);
			return;
		}
		//4，表示文本框里不为空,则放行 ,允许访问
		filterChain.doFilter(request, response);
	}

}
