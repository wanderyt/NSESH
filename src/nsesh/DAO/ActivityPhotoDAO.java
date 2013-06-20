package nsesh.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nsesh.database.MyConnection;
import nsesh.vo.ActivityPhotoVO;

public class ActivityPhotoDAO {
    
    Connection connection = null;
    
    public ActivityPhotoDAO() {
        this.connection = MyConnection.getConnectionByJDBC("localhost");
    }
    
    /**
     * Get all photo objects from database
     * @return
     */
    public List<ActivityPhotoVO> getAllActivityPhoto() {
        List<ActivityPhotoVO> photoList = new ArrayList<ActivityPhotoVO>();
        
        String sql = "select * from activityPhoto";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ActivityPhotoVO photoVO = new ActivityPhotoVO();
                photoVO.setPhotoCategory(rs.getString(0));
                photoVO.setPhotoURL(rs.getString(1));
                photoList.add(photoVO);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return photoList;
    }
    
    /**
     * Get all photo types from database
     * @return
     */
    public List<String> getAllTypes() {
        List<String> photoTypesList = new ArrayList<String>();
        
        String sql = "select distinct photoCategory from activityPhoto";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ActivityPhotoVO photoVO = new ActivityPhotoVO();
                photoTypesList.add(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return photoTypesList;
    }
    
    /**
     * Get all photos according to the given type from database
     * @param type --- photo type
     * @return
     */
    public List<ActivityPhotoVO> getAllActivityPhotoByType(String type) {
        List<ActivityPhotoVO> photoList = new ArrayList<ActivityPhotoVO>();
        
        String sql = "select * from activityPhoto where photoCategory = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ActivityPhotoVO photoVO = new ActivityPhotoVO();
                photoVO.setPhotoCategory(rs.getString(1));
                photoVO.setPhotoURL(rs.getString(2));
                photoList.add(photoVO);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return photoList;
    }
    
    /**
     * Get one record from database
     * @param type
     * @return
     */
    public ActivityPhotoVO getOneActivityPhotoByType(String type) {
        ActivityPhotoVO photoVO = new ActivityPhotoVO();
        
        String sql = "select * from activityPhoto where photoCategory = ? limit 0,1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                photoVO.setPhotoCategory(rs.getString(1));
                photoVO.setPhotoURL(rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return photoVO;
    }

}
