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
import model.Cliente;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String cpfCliente = request.getParameter("cpfcliente");
			String senhaCliente = request.getParameter("senhacliente");
			
			Connection conexao = Conexao.getConexao();
			
			ClienteDao cd = new ClienteDao(conexao);
			
			
			if(cd.isCliente(cpfCliente, senhaCliente)) {
				Cliente c = cd.getCliente(cpfCliente);
				
				request.setAttribute("cliente", c);
				
				RequestDispatcher rd = request.getRequestDispatcher("listarContas");
				
				rd.forward(request, response);
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("loginErro.jsp");
				
				rd.forward(request, response);
			}
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
