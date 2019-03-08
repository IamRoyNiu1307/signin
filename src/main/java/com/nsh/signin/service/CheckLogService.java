package com.nsh.signin.service;

import com.nsh.signin.dao.CheckLogDao;
import com.nsh.signin.entity.CurrentCourse;
import com.nsh.signin.entity.StudentClass;
import com.nsh.signin.entity.TeacherCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CheckLogService {

    @Autowired
    private CheckLogDao checkLogDao;

    /**
     * 根据教师id查询现在正在进行的课程
     * @param teacherId 教师id
     * @return 当前进行的课程
     */
    public CurrentCourse getCurrentCourse(String teacherId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date now = new Date();

        int no = 0;

        //将当前时间的日期格式化 年-月-日
        String nowDate = dateFormat.format(now);

        try {
            Date no1Start = sdf.parse(nowDate + " 8:00");
            Date no1End = sdf.parse(nowDate + " 9:50");
            Date no2Start = sdf.parse(nowDate + " 10:10");
            Date no2End = sdf.parse(nowDate + " 11:50");
            Date no3Start = sdf.parse(nowDate + " 14:00");
            Date no3End = sdf.parse(nowDate + " 15:50");
            Date no4Start = sdf.parse(nowDate + " 16:10");
            Date no4End = sdf.parse(nowDate + " 17:50");

            if(now.compareTo(no1Start)>0&&now.compareTo(no1End)<0) no=1;
            if(now.compareTo(no2Start)>0&&now.compareTo(no2End)<0) no=2;
            if(now.compareTo(no3Start)>0&&now.compareTo(no3End)<0) no=3;
            if(now.compareTo(no4Start)>0&&now.compareTo(no4End)<0) no=4;

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return checkLogDao.getCurrentCourse(teacherId,no);

    }

    /**
     * 开始考勤
     * @param teacherId 教师id
     * @param className 班级名称
     * @param studentClassList 班级中的所有学生
     * @return 考勤记录的id
     */
    public int startCheckin(String teacherId, String className,List<StudentClass> studentClassList){
        //获取当前的时间戳
        Timestamp now = new Timestamp(new Date().getTime());
        //创建考勤表 生成考勤记录
        TeacherCheckin teacherCheckin = new TeacherCheckin(teacherId,now);
        checkLogDao.addTeacherCheckin(teacherCheckin);
        //将学号添加到考勤列表中
        for(StudentClass studentClass : studentClassList){

            checkLogDao.addStudentsToCheckinList(studentClass.getStudentId(), teacherCheckin.getId());

        }

        return teacherCheckin.getId();
    }

    /**
     * 获取当前签到通道开启的考勤并且 学号 还没有签到的数据
     * @param studentId 学号
     * @return 缺勤表
     */
    public Map getCheckStatus(String studentId){
        return checkLogDao.getCheckStatus(studentId);
    }

    public void setStatus(String studentId,int teacherCheckinId){
        checkLogDao.setStatus(studentId,teacherCheckinId);
    }

    public void closeCheckin(int checkinId){
        checkLogDao.closeCheckin(checkinId);
    }

    public List<Map> getAbsentList(int checkinId){
        List<Map> absentList = checkLogDao.getAbsentList(checkinId);
        return absentList;
    }

}
