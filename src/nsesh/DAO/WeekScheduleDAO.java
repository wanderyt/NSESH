package nsesh.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nsesh.database.MyConnection;
import nsesh.vo.ActivityPhotoVO;
import nsesh.vo.WeekScheduleVO;

public class WeekScheduleDAO {
    
Connection connection = null;
    
    public WeekScheduleDAO() {
        this.connection = MyConnection.getConnectionByJDBC("localhost");
    }
    
    public List<WeekScheduleVO> getAllWeekSchedule() {
        List<WeekScheduleVO> weekScheduleVOList = new ArrayList<WeekScheduleVO>();
        
        String sql = "select * from weekschedule";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                WeekScheduleVO weekScheduleVO = new WeekScheduleVO();
                weekScheduleVO.setEmpName(rs.getString(1));
                weekScheduleVO.setSunAM(rs.getString(2));
                weekScheduleVO.setSunPM(rs.getString(3));
                weekScheduleVO.setMonAM(rs.getString(4));
                weekScheduleVO.setMonPM(rs.getString(5));
                weekScheduleVO.setTueAM(rs.getString(6));
                weekScheduleVO.setTuePM(rs.getString(7));
                weekScheduleVO.setWenAM(rs.getString(8));
                weekScheduleVO.setWenPM(rs.getString(9));
                weekScheduleVO.setThuAM(rs.getString(10));
                weekScheduleVO.setThuPM(rs.getString(11));
                weekScheduleVO.setFriAM(rs.getString(12));
                weekScheduleVO.setFriPM(rs.getString(13));
                weekScheduleVO.setSatAM(rs.getString(14));
                weekScheduleVO.setSatPM(rs.getString(15));
                weekScheduleVOList.add(weekScheduleVO);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return weekScheduleVOList;
    }

}
