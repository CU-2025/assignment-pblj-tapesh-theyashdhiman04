package com.financetracker.util;

import com.financetracker.model.Transaction;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

public class XMLHandler {
    private static final String FILE_PATH = "transactions.xml";

    public static void addTransaction(Transaction txn) {
        try {
            File xmlFile = new File(FILE_PATH);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc;

            if (!xmlFile.exists()) {
                doc = db.newDocument();
                Element root = doc.createElement("transactions");
                doc.appendChild(root);
            } else {
                doc = db.parse(xmlFile);
            }

            Element root = doc.getDocumentElement();
            Element transaction = doc.createElement("transaction");

            transaction.setAttribute("type", txn.getType());
            transaction.setAttribute("category", txn.getCategory());
            transaction.setAttribute("amount", String.valueOf(txn.getAmount()));
            transaction.setAttribute("date", txn.getDate());

            root.appendChild(transaction);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource ds = new DOMSource(doc);
            StreamResult sr = new StreamResult(xmlFile);
            t.transform(ds, sr);
            System.out.println("XML Path: " + new File(FILE_PATH).getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        try {
            File xmlFile = new File(FILE_PATH);
            if (!xmlFile.exists()) return list;

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            NodeList nList = doc.getElementsByTagName("transaction");

            for (int i = 0; i < nList.getLength(); i++) {
                Element e = (Element) nList.item(i);
                Transaction txn = new Transaction(
                        e.getAttribute("type"),
                        e.getAttribute("category"),
                        Double.parseDouble(e.getAttribute("amount")),
                        e.getAttribute("date")
                );
                list.add(txn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
