package es.pildoras.conexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConectaCRUD
 */
@WebServlet("/ConectaCRUD")
public class ConectaCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConectaCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/gestionPedidosCRUD?useSSL=false";
		String usuario = "root";
		String contraseña = "";
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection miConexion = null;

		try {
			PrintWriter out = response.getWriter();
			out.println("Nombre de la BBDD: " +  jdbcUrl);
			Class.forName(driver);
			miConexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
			out.println("Conexión exitosa");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != miConexion) {
				try {
					miConexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
