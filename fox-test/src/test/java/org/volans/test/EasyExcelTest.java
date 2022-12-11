package org.volans.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author dujf
 * @version 1.0
 * @date 2022/11/29 17:41
 */

public class EasyExcelTest {

    @Test
    public void testExport() {
        String fileName = "d:\\desktop\\" + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 5; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = data();
                excelWriter.write(data, writeSheet);
            }
        }
    }

    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setName("字符串" + i + System.currentTimeMillis());
            data.setBirthDay(LocalDateTime.now());
            data.setMoney(new BigDecimal("0.56"));
            list.add(data);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    static class DemoData {
        @ExcelProperty("字符串标题")
        private String name;
        @ExcelProperty("生日")
        private LocalDateTime birthDay;
        @ExcelProperty("存款")
        private BigDecimal money;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDateTime getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(LocalDateTime birthDay) {
            this.birthDay = birthDay;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }
    }
}
