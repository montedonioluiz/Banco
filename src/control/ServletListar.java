package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import dao.Conexao;
import dao.ContaDao;
import model.Cliente;

/**
 * Servlet implementation class ServletListar
 */
@WebServlet("/listarContas")
public class ServletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			Connection conexao = Conexao.getConexao();
			
			ContaDao cd = new ContaDao(conexao);
			request.setAttribute("contas",cd.getContas( (Cliente) request.getAttribute("cliente")));
			request.setAttribute("cliente", request.getAttribute("cliente"));
			
			RequestDispatcher rd = request.getRequestDispatcher("listarContas.jsp");
			
			rd.forward(request, response);
			
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
