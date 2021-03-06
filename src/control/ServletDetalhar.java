package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ContaDao;
import dao.TransacaoDao;
import model.Conta;
import model.Transacao;

/**
 * Servlet implementation class ServletDetalhar
 */
@WebServlet("/detalharConta")
public class ServletDetalhar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhar() {
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
			TransacaoDao td = new TransacaoDao(conexao);
			
			Conta c = cd.getConta(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("conta", c);
			
			ArrayList<Transacao> transacoes = td.getTransacoes(c.getIdConta());
			request.setAttribute("transacoes", transacoes);
			
			double saldo = cd.getSaldo(c.getIdConta());
			request.setAttribute("saldo", saldo);
			
			RequestDispatcher rd = request.getRequestDispatcher("detalharConta.jsp");
			
			rd.forward(request, response);
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
