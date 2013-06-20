package nsesh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nsesh.DAO.WeekScheduleDAO;
import nsesh.vo.WeekScheduleVO;

public class WeekScheduleAction extends HttpServlet {
    
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
        
        JSONObject globalJson = new JSONObject();
        resp.setContentType("text/json;charset=UTF-8");
        WeekScheduleDAO dao = new WeekScheduleDAO();
        List<WeekScheduleVO> weekScheduleList = dao.getAllWeekSchedule();
        JSONObject[] jsonObjects = new JSONObject[weekScheduleList.size()];
        int i = 0;
        for(WeekScheduleVO weekScheduleVO : weekScheduleList) {
            JSONObject json = new JSONObject();
            json.put("name", weekScheduleVO.getEmpName());
            /*json.put("1", modifyDefault(weekScheduleVO.getSunAM()));
            json.put("2", modifyDefault(weekScheduleVO.getSunPM()));
            json.put("3", modifyDefault(weekScheduleVO.getMonAM()));
            json.put("4", modifyDefault(weekScheduleVO.getMonPM()));
            json.put("5", modifyDefault(weekScheduleVO.getTueAM()));
            json.put("6", modifyDefault(weekScheduleVO.getTuePM()));
            json.put("7", modifyDefault(weekScheduleVO.getWenAM()));
            json.put("8", modifyDefault(weekScheduleVO.getWenPM()));
            json.put("9", modifyDefault(weekScheduleVO.getThuAM()));
            json.put("10", modifyDefault(weekScheduleVO.getThuPM()));
            json.put("11", modifyDefault(weekScheduleVO.getFriAM()));
            json.put("12", modifyDefault(weekScheduleVO.getFriPM()));
            json.put("13", modifyDefault(weekScheduleVO.getSatAM()));
            json.put("14", modifyDefault(weekScheduleVO.getSatPM()));*/
            String[] schedules = new String[14];
            schedules[0] = modifyDefault(weekScheduleVO.getSunAM());
            schedules[1] = modifyDefault(weekScheduleVO.getSunPM());
            schedules[2] = modifyDefault(weekScheduleVO.getMonAM());
            schedules[3] = modifyDefault(weekScheduleVO.getMonPM());
            schedules[4] = modifyDefault(weekScheduleVO.getTueAM());
            schedules[5] = modifyDefault(weekScheduleVO.getTuePM());
            schedules[6] = modifyDefault(weekScheduleVO.getWenAM());
            schedules[7] = modifyDefault(weekScheduleVO.getWenPM());
            schedules[8] = modifyDefault(weekScheduleVO.getThuAM());
            schedules[9] = modifyDefault(weekScheduleVO.getThuPM());
            schedules[10] = modifyDefault(weekScheduleVO.getFriAM());
            schedules[11] = modifyDefault(weekScheduleVO.getFriPM());
            schedules[12] = modifyDefault(weekScheduleVO.getSatAM());
            schedules[13] = modifyDefault(weekScheduleVO.getSatPM());
            json.put("ss", JSONArray.fromObject(schedules));
            jsonObjects[i++] = json;
        }
        JSONArray jsonArray = JSONArray.fromObject(jsonObjects);
        globalJson.put("schedule", jsonArray);
        resp.getWriter().print(globalJson.toString());
    }
    
    private String modifyDefault(String str) {
        return str == null ? "" : str;
    }

}
