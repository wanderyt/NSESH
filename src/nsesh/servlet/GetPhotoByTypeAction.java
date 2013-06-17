package nsesh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nsesh.DAO.ActivityPhotoDAO;
import nsesh.vo.ActivityPhotoVO;

public class GetPhotoByTypeAction extends HttpServlet {

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
        
        String actType = req.getParameter("actType");
        System.out.println("actType == " + actType);

        JSONObject json = new JSONObject();
        resp.setContentType("text/json;charset=UTF-8");
        ActivityPhotoDAO dao = new ActivityPhotoDAO();
        List<ActivityPhotoVO> photoTypeList = dao.getAllActivityPhotoByType(actType);
        System.out.println(photoTypeList.size());
        String[] photos = new String[photoTypeList.size()];
        int i = 0;
        for(ActivityPhotoVO activityPhotoVO : photoTypeList) {
            photos[i] = activityPhotoVO.getPhotoURL();
            i++;
        }
        JSONArray jsonArray = JSONArray.fromObject(photos);
        json.put("photos", jsonArray);
        resp.getWriter().print(json.toString());
    }

}