package co.micol.prj;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// root-context.xml대신에 사용하는 클래스 
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// servlet-context.xml
		return new Class[] {ServletConfig.class};  //내가만든 ServletConfig클래스를 넣어줘야함!
	}

	@Override
	protected String[] getServletMappings() {
		//controller안에 있는 mapping하는 클래스들 
		//내가 controller에 직접 넣을거면 안적어줘도됨
		return new String[] {"/"};  //이 형식으로 들어오는것을 읽어라  //mapper가 String으로 들어오면 컨트롤러로 가서 읽어라
	}
	
	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}

}
