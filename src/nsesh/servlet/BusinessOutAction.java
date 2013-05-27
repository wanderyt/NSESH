package nsesh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class BusinessOutAction extends HttpServlet {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        
        JSONObject json = new JSONObject();

        resp.setContentType("text/json;charset=UTF-8");
        
        json.put("title", "本周出差");
        resp.getWriter().print(json.toString());
    }

}
