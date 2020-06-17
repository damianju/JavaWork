package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CategoryListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		CategoryDAO dao = new CategoryDAO();
		CategoryDTO[] arr = null;

		StringBuffer message = new StringBuffer();
		String status = "FAIL";

		// 세팅값들
		int uid = 0;
		String name = null;
		int depth = 1;
		int parent = 0;
		int order = 0;

		String param1;
		String param2;

		param1 = request.getParameter("depth");
		param2 = request.getParameter("parent");

		if (param1 == null && param2 == null) {
			try {

				arr = dao.selectByCategory(depth, parent);

				if (arr == null) {
					message.append("0개의 데이터");
				} else {
					status = "OK";
				}

			} catch (SQLException e) {
				message.append("[트렌잭션 에러:" + e.getMessage() + "]");
			} catch (Exception e) {
				message.append("[유효하지 않은 parameter]" + param2);
			}

		} else {

			if (param1 != null && param1.trim().length() != 0) {

				try {
					depth = Integer.parseInt(param1);
				} catch (NumberFormatException e) {
					message.append("[" + e.getMessage() + "]");

				} catch (Exception e) {
					message.append("[유효하지 않은 parameter]" + param1);

				}
			} else {
				message.append("[유효하지 않은 parameter 0 or null]");

			} // end if

			if (depth != 1) {
				if (param2 != null && param2.trim().length() != 0) {

					try {
						parent = Integer.parseInt(param2);

						arr = dao.selectByCategory(depth, parent);

						if (arr == null) {
							message.append("0개의 데이터");
						} else {
							status = "OK";
						}

					} catch (SQLException e) {
						message.append("[트렌잭션 에러:" + e.getMessage() + "]");
					} catch (Exception e) {
						message.append("[유효하지 않은 parameter]" + param2);
					}

				} else {
					message.append("0개의 데이터");
				} // end if
			} else {
				if (param2 != null && param2.trim().length() != 0) {

					try {
						parent = Integer.parseInt(param2);

						arr = dao.selectByCategory(depth, parent);

						if (arr == null) {
							parent = 0;
							arr = dao.selectByCategory(depth, parent);
							status = "OK";
							//message.append("0개의 데이터");
						} else {
							status = "OK";
						}

					} catch (SQLException e) {
						message.append("[트렌잭션 에러:" + e.getMessage() + "]");
					} catch (Exception e) {
						message.append("[유효하지 않은 parameter]" + param2);

					}

				} else {
 
					try {
						arr = dao.selectByCategory(depth, parent);
						if (arr == null) {
							message.append("0개의 데이터");
						} else {
							status = "OK";
						}
					} catch (SQLException e) {
						message.append("[트렌잭션 에러:" + e.getMessage() + "]");
					}

				} // end if
			}
		} // end if

		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);

		request.setAttribute("uid", uid);
		request.setAttribute("name", name);
		request.setAttribute("depth", depth);
		request.setAttribute("parent", parent);
		request.setAttribute("order", order);

	} // end execute

}
