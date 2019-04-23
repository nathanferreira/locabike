package controller;

import model.Cliente;
import dao.ClienteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cliente/*")
public class ClienteController extends HttpServlet {

    private ClienteDAO dao;

    @Override
    public void init() {
        dao = new ClienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/"));
        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/lista":
                    lista(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/novoCliente.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String CPF = request.getParameter("CPF");
        Cliente cliente = dao.get(CPF);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/novoCliente.jsp");
        request.setAttribute("cliente", cliente);
        dispatcher.forward(request, response);
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaClientes = dao.getAll();
        request.setAttribute("listaClientes", listaClientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCliente.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
          
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String CPF = request.getParameter("CPF");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthDate = request.getParameter("birthDate");
        
        Cliente cliente = new Cliente(email, password, CPF, name, gender, phone, birthDate);
        dao.insert(cliente);
        response.sendRedirect("lista");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String CPF = request.getParameter("CPF");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthDate = request.getParameter("birthDate");
        
        Cliente cliente = new Cliente(email, password, CPF, name, gender, phone, birthDate);
        dao.update(cliente);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String CPF = request.getParameter("CPF");
        dao.delete(CPF);
        response.sendRedirect("lista");
    }

}
