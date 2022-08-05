package com.lzh.dao;

import java.io.File;
import java.util.List;

import com.lzh.bean.Stu;
import com.lzh.service.StuService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class FromDbToExcel {
    public static void main(String[] args) {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
               String fileName = "E://student.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<Stu> list= StuService.getAllByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelId= new Label(0, 0, "编号(id)");
               Label labelName= new Label(1, 0, "姓名(name)");
               Label labelSex= new Label(2, 0, "时间(dt)");
               Label labelNum= new Label(3, 0, "Hid(hid)");
               
               ws.addCell(labelId);
               ws.addCell(labelName);
               ws.addCell(labelSex);
               ws.addCell(labelNum);
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
                   Label labelName_i= new Label(1, i+1, list.get(i).getName());
                   Label labelDt_i= new Label(2, i+1, list.get(i).getDt());
                   Label labelHid_i= new Label(3, i+1, list.get(i).getHid()+"");
                   ws.addCell(labelId_i);
                   ws.addCell(labelName_i);
                   ws.addCell(labelDt_i);
                   ws.addCell(labelHid_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               System.out.println("数据导出成功!");
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
