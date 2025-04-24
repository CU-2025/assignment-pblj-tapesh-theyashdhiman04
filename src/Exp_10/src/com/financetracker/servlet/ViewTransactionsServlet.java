
package com.financetracker.servlet;

import com.financetracker.model.Transaction;
import com.financetracker.util.XMLHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ViewTransactionsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Transaction> transactions = XMLHandler.getAllTransactions(); // ✅ Your XMLHandler method
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
    }
}

