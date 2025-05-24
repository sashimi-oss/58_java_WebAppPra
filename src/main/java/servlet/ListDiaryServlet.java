package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.DiaryDAO;
import model.entity.DiaryBean;

/**
 * Servlet implementation class ListDiaryServlet
 */
@WebServlet("/list-diary-servlet")
public class ListDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		List<DiaryBean> diaryList = null;
		DiaryDAO dao = new DiaryDAO();
		
		try {
			diaryList = dao.selectAll();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("diaryList", diaryList);
		
		RequestDispatcher rd = request.getRequestDispatcher("list-diary.jsp");
		rd.forward(request, response);
		
	}

}
