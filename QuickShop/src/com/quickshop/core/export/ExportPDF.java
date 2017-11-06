 package com.quickshop.core.export;
 
 import com.lowagie.text.Document;
 import com.lowagie.text.DocumentException;
 import com.lowagie.text.Paragraph;
 import com.lowagie.text.Phrase;
 import com.lowagie.text.pdf.PdfWriter;
import com.quickshop.core.util.LoggerManager;

import java.io.ByteArrayOutputStream;
 import java.io.DataOutput;
 import java.io.DataOutputStream;
 import java.io.IOException;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 public class ExportPDF extends HttpServlet
 {
   public void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException
   {
     res.setContentType("application/pdf");
    Document document = new Document();
   ByteArrayOutputStream buffer = new ByteArrayOutputStream();
   try
   {
     PdfWriter.getInstance(document, buffer);
     document.open();
    document.add(new Paragraph("Report"));
    document.add(new Phrase((String)req.getSession().getAttribute("export")));
    document.close();
  }
   catch (DocumentException de)
   {
     LoggerManager.writeLogWarning(de);
    }
    try
    {
      DataOutput output = new DataOutputStream(res.getOutputStream());
      byte[] bytes = buffer.toByteArray();
      res.setContentLength(bytes.length);
     for (int i = 0; i < bytes.length; i++) {
        output.writeByte(bytes[i]);
      }
    }
     catch (IOException ioe)
    {
      LoggerManager.writeLogWarning(ioe);
    }
   }
 }

