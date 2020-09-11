package com.cookbook.dao.backstageDao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BackReportFormDao {

    //报表本月收入
    @Select("select sum(l.Shares)'Shares' from income l  where MONTH(l.inTime)=MONTH(NOW())")
    List<Map<String,Object>> ReportFormIncomeMonth();

    //报表本月菜谱种类
    @Select("select count(m.Mtid)'count',\n" +
            "(select mes.Mtname from menutypes mes where mes.Mtid = ms.mLevel)'Mtname'\n" +
            " from works w left join menu m on w.Mid = m.Mid left join menutypes ms on m.Mtid = ms.Mtid where MONTH(w.MakeTime)=MONTH(NOW()) group by m.Mtid")
    List<Map<String,Object>> ReportFormMenuMonth();

    //报表本月菜谱
    @Select("select count(m.Mtid)'count',\n" +
            "(select mes.Mtname from menutypes mes where mes.Mtid = m.Mtid)'Mtname'\n" +
            "from menu m inner join menutypes my on m.Mtid = my.Mtid where Month(m.MadeTime)=MONTH(NOW()) group by m.Mtid")
    List<Map<String,Object>> ReportFormMenuTypesMonth();

    //报表本年收入
    @Select("select sum(l.Shares)'Shares' from income l where YEAR(l.inTime)=YEAR(NOW())")
    List<Map<String,Object>> ReportFormIncomeYear();

    //报表本年菜谱种类
    @Select("select count(m.Mtid)'count',\n" +
            "(select mes.Mtname from menutypes mes where mes.Mtid = ms.mLevel)'Mtnames'\n" +
            " from works w left join menu m on w.Mid = m.Mid left join menutypes ms on m.Mtid = ms.Mtid where YEAR(w.MakeTime)=YEAR(NOW()) group by m.Mtid")
    List<Map<String,Object>> ReportFormMenuYear();

    //报表本年菜谱
    @Select("select count(m.Mtid)'count',\n" +
            "(select mes.Mtname from menutypes mes where mes.Mtid = m.Mtid)'Mtname'\n" +
            "from menu m inner join menutypes my on m.Mtid = my.Mtid where YEAR(m.MadeTime)=YEAR(NOW()) group by m.Mtid")
    List<Map<String,Object>> ReportFormMenuTypesYear();
}
