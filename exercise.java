import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.jcodings.util.Hash;

import java.util.HashMap;
import java.util.Map;

public class exercise {
    // base
    static Configuration conf = null;
    static {
        conf = HBaseConfiguration.create();
    }

    private static int createTable(String tbName, String[] families) throws Exception{
        // 1
        HBaseAdmin admin = new HBaseAdmin(conf);
        if (admin.tableExists(tbName)) {
            System.out.println(tbName+"已经存在！");
            admin.close();
            return -1;
        }
        // 2
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tbName));
        for (String family : families)
            tableDescriptor.addFamily(new HColumnDescriptor(family));
        // 3
        admin.createTable(tableDescriptor);
        admin.close();
        System.out.println("新表创建成功！新表为："+tbName);
        return 1;
    }

    private static int _insert(String tbName,String rowKey,String family,String column,String value) throws Exception{
        // 1
        HBaseAdmin admin = new HBaseAdmin(conf);
        if (！admin.tableExists(tbName)) {
            System.out.println(tbName+"不存在！");
            admin.close();
            return -1;
        }
        // 2
        HTable table = new HTable(conf, tbName);
        HTableDescriptor htd = table.getTableDescriptor();
        HColumnDescriptor hcd = htd.getFamily(family.getBytes());
        if (hcd ==null) {
            System.out.println("列族" + family + "不存在");
            return -1;
        }
        // 3
        Put pp = new Put(rowKey.getBytes());
        pp.addColumn(family.getBytes(),column.getBytes(),value.getBytes());
        // 4
        table.put(pp);
        table.close();
        System.out.println("数据插入成功。");
        return 1;
    }

    private static int insert(String tbName,String rowKey,String family,String[] column,String[] value) throws Exception{
        if (column.length!=value.length)
            return -1;

        for (int i = 0; i < column.length; i++)
            if(_insert(tbName,rowKey,family,column[i],value[i])!=1)
                return -1;
        return 1;
    }

    private static void get(String tbName,String rowKey)throws Exception {
        // 1
        HBaseAdmin admin = new HBaseAdmin(conf);
        if (!admin.tableExists(tbName)) {
            System.out.println(tableName + "表不存在！");
            admin.close();
            System.exit(1);
        }
        // 2
        HTable table = new HTable(conf, tbName);
        Get get = new Get(rowKey.getBytes());
        Result result = table.get(get);
        // 3
        Cell[] cells = result.rawCells();
        if (cells.length==0) {
            System.out.println("没有该行键：" + rowKey);
            table.close();
            System.exit(1);
        }
        for (Cell cell : cells) {
            StringBuilder builder = new StringBuilder();
            String fam = new String(CellUtil.cloneFamily(cell));
            String qua = new String(CellUtil.cloneQualifier(cell));
            String val = new String(CellUtil.cloneValue(cell));
            String row = new String(CellUtil.cloneRow(cell));
            long timestamp = cell.getTimestamp();
            builder.append("行健=").append(row);
            builder.append(",列族=").append(fam);
            builder.append(",列=").append(qua);
            builder.append(",值=").append(val);
            builder.append(",时间戳=").append(timestamp);
            System.out.println(builder);
        }
        table.close();
    }


    private static boolean delete(String tbName,String rowName,String family,String column) throws Exception{
        // 1
        HBaseAdmin admin = new HBaseAdmin(conf);
        if (admin.tableExists(tbName)) {
            System.out.println(tbName+"表不存在！");
            return false;
        }
        // 2
        HTable hTable = new HTable(conf, tbName);
        Delete del = new Delete(rowName.getBytes());
        del.deleteColumn(family.getBytes(),column.getBytes());
        hTable.delete(del);
        System.out.println(column+"列删除成功");
        return true;
    }

    private static void scan(String tbName,String family)throws Exception {
        // 1
        HBaseAdmin admin = new HBaseAdmin(conf);
        if (!admin.tableExists(tbName)) {
            admin.close();
            System.out.println(tbName + "表不存在！");
            System.exit(1);
        }
        // 2
        Scan scan = new Scan();
        scan.addFamily(family.getBytes());
        HTable hTable = new HTable(conf, tbName);
        ResultScanner scanner = hTable.getScanner(scan);
        // 3
        for (Result result : scanner) {
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {
                String fam = new String(CellUtil.cloneFamily(cell));
                String qua = new String(CellUtil.cloneQualifier(cell));
                String val = new String(CellUtil.cloneValue(cell));
                String row = new String(CellUtil.cloneRow(cell));
                long timestamp = cell.getTimestamp();
                System.out.println("行健=" + row + ",列族=" + fam + ",列=" + qua + ",值=" + val + ",时间戳=" + timestamp);
            }
        }
        hTable.close();
    }

    public static void main(String[] args) throws Exception{
        String tableName = "staffInfo";
        String families[] = new String[]{"BI","EI","WI"};
        createTable(tableName,families);

        insert(tableName,"1001","BI",new String[]{"name","birth","mobile"},new String[]{"zhangsan","1985.6","1366"});
        insert(tableName,"1001","EI",new String[]{"high","bachelor"},new String[]{"Nanning high school","gxfeu"});
        insert(tableName,"1001","WI",new String[]{"company1","company2"},new String[]{"baidu","huawei"});


        insert(tableName,"1002","BI",new String[]{"name","birth","mobile","email"},new String[]{"lisi", "1990.10", "1712354", "12222@qq.com"});
        insert(tableName,"1002","EI",new String[]{"high", "bachelor", "master",},new String[]{"liuzhou high school", "gxu", "gxu",});
        insert(tableName,"1002","WI",new String[]{"company1","company2"},new String[]{"baidu","sina"});

        insert(tableName,"1003","BI",new String[]{"name","birth","mobile"},new String[]{"wangwu", "1992.8", "139789"});
        insert(tableName,"1003","EI",new String[]{"high", "bachelor", "master", "doctor",},new String[]{"guilin high school", "gxfeu", "gxu", "gxu",});
        insert(tableName,"1003","WI",new String[]{"company1","company2","company3"},new String[]{"baidu","huawei","byd"});



        get(tableName,"1002");
        delete(tableName,"1003","WI","company2");
        scan(tableName,"WI");
    }
}
