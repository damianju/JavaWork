// 공통으로 implement 하는 interface
package old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface Command {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
