package servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.DiaryDAO;
import model.entity.DiaryBean;

/**
 * Servlet implementation class UpdateDecisionServlet
 */
@WebServlet("/update-decision-servlet")
public class UpdateDecisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDecisionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		DiaryBean diary = new DiaryBean();
		DiaryDAO dao = new DiaryDAO();
		HttpSession session = request.getSession();
		diary = (DiaryBean) session.getAttribute("diary");
//		System.out.println(diary.getContent());
		
		int count = 0;
		
		try {
			count = dao.update(diary);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(count + "件のレコードを更新しました");
		
		//diary sessionの破棄
		session.removeAttribute("diary");
		
		RequestDispatcher rd = request.getRequestDispatcher("update-decision.jsp");
		rd.forward(request, response);
		
		
	}

}
