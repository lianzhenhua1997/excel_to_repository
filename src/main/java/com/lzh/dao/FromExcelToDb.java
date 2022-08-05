package com.lzh.dao;

import com.lzh.bean.Stu;
import com.lzh.service.StuService;
import com.lzh.util.DBhelper;

import java.util.List;

public class FromExcelToDb {
    public static void main(String[] args) {
        //得到表格中所有的数据
        List<Stu> listExcel= StuService.getAllByExcel("E://student.xls");  //目录下可以没有文件！，但必须得有目录
        /*
         	得到数据库表中所有的数据
        	List<Stu> listDb=StuService.getAllByDb();
        */

        DBhelper db=new DBhelper();

        for (Stu stuEntity : listExcel) {
            int id=stuEntity.getId();
            if (!StuService.isExist(id)) {
                //不存在就添加
                String sql="insert into student (name,dt,hid) values(?,?,?)";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getDt(),stuEntity.getHid()+""};
                db.AddU(sql, str);
            }else {
                //存在就更新
                String sql="update student set name=?,dt=?,hid=? where id=?";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getDt(),stuEntity.getHid()+"",id+""};
                db.AddU(sql, str);
            }
        }
        System.out.println("数据更新成功！");
    }
}
