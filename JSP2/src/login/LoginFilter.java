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
        //1����ȡ�����servletPath
		String servletPath = request.getServletPath();
		//2,���1��ȡ��servletPath�Ƿ�Ϊ����Ҫ����URL �е�һ��,����,��ֱ�ӷ���,��������
		List<String> urls = Arrays.asList(uncheckedUrls.split(","));
		//���ÿ�η���doFilter��servletPath������urls��ֱ�ӿɷ���
		if(urls.contains(servletPath)){
			filterChain.doFilter(request, response);
			return;
		}
		//3����session�л�ȡseesionKey��Ӧ��ֵ,��ֵ������,���ض���redirectUrl
		Object user = request.getSession().getAttribute("sessionKey");
		if(user == null){
			response.sendRedirect(request.getContextPath()+rediretUrl);
			return;
		}
		//4����ʾ�ı����ﲻΪ��,����� ,�������
		filterChain.doFilter(request, response);
	}

}
