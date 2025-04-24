package com.financetracker.servlet;

import com.financetracker.model.Transaction;
import com.financetracker.util.XMLHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddTransactionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String type = req.getParameter("type");
        String category = req.getParameter("category");
        double amount = Double.parseDouble(req.getParameter("amount"));
        String date = req.getParameter("date");

        Transaction txn = new Transaction(type, category, amount, date);
        XMLHandler.addTransaction(txn);

        res.sendRedirect("/Simple_Finance_Application/view");
    }
}
