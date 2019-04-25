package controller;

import model.Locacao;
import dao.LocacaoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Locacao;

@WebServlet(urlPatterns = "/locacao/*")
public class LocacaoController extends HttpServlet {

    private LocacaoDAO dao;

    @Override
    public void init() {
        dao = new LocacaoDAO();
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/novaLocacao.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String CNPJ = request.getParameter("CNPJ");
        Locacao locacao = dao.get(CNPJ);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/novaLocacao.jsp");
        request.setAttribute("locacao", locacao);
        dispatcher.forward(request, response);
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Locacao> listaLocacaos = dao.getAll();
        request.setAttribute("listaLocacaos", listaLocacaos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaLocacao.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String CNPJ = request.getParameter("CNPJ");
        String CPF = request.getParameter("CPF");
        String rentDate = request.getParameter("rentDate");

        Locacao locacao = new Locacao("", CNPJ, CPF, rentDate);
        dao.insert(locacao);
        response.sendRedirect("lista");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String ID = request.getParameter("ID");
        String CNPJ = request.getParameter("CNPJ");
        String CPF = request.getParameter("CPF");
        String rentDate = request.getParameter("rentDate");

        Locacao locacao = new Locacao(ID, CNPJ, CPF, rentDate);
        dao.update(locacao);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String ID = request.getParameter("ID");
        dao.delete(ID);
        response.sendRedirect("lista");
    }
}