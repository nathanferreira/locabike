package controller;

import model.Locadora;
import model.Usuario;
import dao.LocadoraDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/locadora/*")
public class LocadoraController extends HttpServlet {

    String role = "locadora";
    private LocadoraDAO dao;
    private UsuarioDAO userDao;

    @Override
    public void init() {
        dao = new LocadoraDAO();
        userDao = new UsuarioDAO();
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
        
        String sessionRole = sessionRole = request.getSession().getAttribute("role").toString();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/erro.jsp");
        
        if (sessionRole.equals("admin")) {
            dispatcher = request.getRequestDispatcher("/novaLocadora.jsp");
        }
        
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        Locadora locadora = dao.get(email);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/novaLocadora.jsp");
        request.setAttribute("locadora", locadora);
        dispatcher.forward(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Locadora> listaLocadoras = dao.getAll();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaLocadora.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String CNPJ = request.getParameter("CNPJ");
        String name = request.getParameter("name");
        String city = request.getParameter("city");

        Locadora locadora = new Locadora(email, password, CNPJ, name, city);
        Usuario usuario = new Usuario(email, password, role);
        userDao.insert(usuario);
        dao.insert(locadora);
        
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String CNPJ = request.getParameter("CNPJ");
        String name = request.getParameter("name");
        String city = request.getParameter("city");

        Locadora locadora = new Locadora(email, password, CNPJ, name, city);
        Usuario usuario = new Usuario(email, password, role);
        dao.update(locadora);
        userDao.update(usuario);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String email = request.getParameter("email");
        dao.delete(email);
        userDao.delete(email);
        response.sendRedirect("lista");
    }
}