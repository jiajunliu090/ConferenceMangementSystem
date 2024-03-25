package utilities;

import javax.print.DocFlavor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TableGenerator {
    private TableGenerator(){}
    public static TableModel generateComingMeetingTable(String loginUser_ID) {
        String[] cols = new String[]{"会议ID", "会议室"};
        Object[][] data = insertData(loginUser_ID);
        return new DefaultTableModel(data, cols);
    }
    public static TableModel generateMeetingInfoTable(String loginUser_ID) {
        String[] cols = new String[]{"会议ID", "会议室", "会议时间", "是否签到"};
        // 添加一个能够生成上面列信息的就行
        List<Object[]> data = ConfigHelper.getInstance().getConferenceDAO().getMeetingInfoData(loginUser_ID);

        // 将List<Object[]>转换为二维数组
        Object[][] dataArray = new Object[data.size()][cols.length];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = data.get(i);
        }

        // 创建DefaultTableModel并返回
        return new DefaultTableModel(dataArray, cols);

    }
    // 创建一个两列的表格{"会议ID", "会议室"}
    private static Object[][] insertData(String user_ID) {
        List<String> meetingId = ConfigHelper.getInstance().getConferenceDAO().getMeeting_ID(user_ID);
        List<String> room_ids = ConfigHelper.getInstance().getRoomConferenceDAO().getRoom_IDByMeeting_ID(meetingId);
        Object[][] data = new Object[meetingId.size()][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = meetingId.get(i);
            data[i][1] = room_ids.get(i);
        }
        return data;
    }
}
