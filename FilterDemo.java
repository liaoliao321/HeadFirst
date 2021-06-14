
//-------------------------------------条件过滤Filter，类名:FilterDemo ------------;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.ColumnCountGetFilter;
import org.apache.hadoop.hbase.filter.ColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FirstKeyOnlyFilter;
import org.apache.hadoop.hbase.filter.InclusiveStopFilter;
import org.apache.hadoop.hbase.filter.KeyOnlyFilter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RandomRowFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SkipFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.ValueFilter;
import org.apache.hadoop.hbase.filter.WhileMatchFilter;
import org.apache.hadoop.hbase.util.Bytes;

public class FilterDemo {
    static Configuration conf = null;
    static{
        conf=HBaseConfiguration.create();
    }
    //**************************************************************************************
    public static void rowFilterDemo(String tableName,String rowKey) throws IOException{
        HTable table = new HTable(conf,tableName);
        table.setAutoFlush(false);//关闭 数据自动提交功能

        Scan scan1 = new Scan();
        Filter rf = new RowFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(rowKey.getBytes()));
        scan1.setFilter(rf);//设置扫描条件
        ResultScanner scanner1 = table.getScanner(scan1);

        System.out.println("\t-----------------1.筛选出某一行数据---------------------");
        for(Result res:scanner1){
            for(Cell cell:res.rawCells()){
                System.out.print(new String(cell.getRow())+",");
                System.out.print(new String(CellUtil.cloneFamily(cell))+":");
                System.out.print(new String(CellUtil.cloneQualifier(cell))+",");
                System.out.print("值="+new String(CellUtil.cloneValue(cell))+",");
                System.out.println("时间戳="+cell.getTimestamp());
            }
            System.out.println("---------------------------------------------------------------------");
        }
    }
    //**************************************************************************************
    public static void preFixFilterDemo(String tableName,String rowKey) throws IOException{
        HTable table = new HTable(conf,tableName);
        table.setAutoFlush(false);

        Scan scan1 = new Scan();
        Filter pf = new PrefixFilter(rowKey.getBytes());
        scan1.setFilter(pf);
        ResultScanner scanner1 =table.getScanner(scan1);

        System.out.println("\t--------------2.筛选出行键前缀为 rw 的数据------------------");
        for(Result res:scanner1){
            for(Cell cell:res.rawCells()){
                String row = new String(CellUtil.cloneRow(cell));
                String fam = new String(CellUtil.cloneFamily(cell));
                String qua = new String(CellUtil.cloneQualifier(cell));
                String val = new String(CellUtil.cloneValue(cell));
                long tim = cell.getTimestamp();
                System.out.println(row+","+fam+"："+qua+",值="+val+",时间戳="+tim);
            }
            System.out.println("---------------------------------------------------------------------");
        }
    }
    public static void columnPrefixFilterDemo(String tableName,String Qualifier) throws IOException{
        HTable table = new HTable(conf,tableName);
        Scan scan1 = new Scan();
        Filter cpf = new ColumnPrefixFilter(Qualifier.getBytes());
        scan1.setFilter(cpf);
        ResultScanner scanner1 = table.getScanner(scan1);

        System.out.println("\t---------------7.筛选出指定前缀的列的数据--------------");
        printResult(scanner1);//调用输出方法
    }
    //**************************************************************************************
    public static void printResult(ResultScanner scanner1){ //将输出部分做成类的一个方法
        for(Result res:scanner1){
            for(Cell cell:res.rawCells()){
                String row = new String(CellUtil.cloneRow(cell));
                String fam = new String(CellUtil.cloneFamily(cell));
                String qua = new String(CellUtil.cloneQualifier(cell));
                String val = new String(CellUtil.cloneValue(cell));
                long tim = cell.getTimestamp();
                System.out.println(row+",  "+fam+"："+qua+",  值="+val+",\t时间戳="+tim);
            }
            System.out.println("---------------------------------------------------------------------");
        }
    }
    //**************************************************************************************

    public static void main(String[] args) throws IOException {
        rowFilterDemo("stu", "rw001");
        preFixFilterDemo("stu", "rw");
        columnPrefixFilterDemo("stu", "Ja");
    }
}
