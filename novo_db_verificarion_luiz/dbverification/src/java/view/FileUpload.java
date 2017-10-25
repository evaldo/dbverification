/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FileProcess;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author luiz.rodrigues
 */
@WebServlet("/UploadFileServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, // 10MB
                 maxFileSize=1024*1024*20,      // 20MB
                 maxRequestSize=1024*1024*50,
                 location="C:\\tcc_static")   // 50MB
public class FileUpload extends  HttpServlet{
    private static final long serialVersionUID = 1L;
    private static final String UPLOADED_SCRIPTS_FOLDER = "UPLOADED_SCRIPTS";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String fullFileDest = upload(request);
        
        FileProcess fileUpload = FileProcess.getInstance();
        fileUpload.processFile(fullFileDest);
        
        
        request.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);
    }
    
    
    private String upload(HttpServletRequest request) throws IOException, ServletException{
        //TODO: Refactor this shit
        final String savePath = UPLOADED_SCRIPTS_FOLDER;
        
        File fileSaveDir = new File("C:\\tcc_static" + File.separator + savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
            return "C:\\tcc_static" + File.separator + savePath + File.separator + fileName;
        }
        return null;
    }
    
    /**
        * Extracts file name from HTTP header content-disposition
        */
       private String extractFileName(Part part) {
           String contentDisp = part.getHeader("content-disposition");
           String[] items = contentDisp.split(";");
           for (String s : items) {
               if (s.trim().startsWith("filename")) {
                   return s.substring(s.indexOf("=") + 2, s.length()-1);
               }
           }
           return "";
       }
}
