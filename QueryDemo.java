import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;

import java.io.IOException;

public class LiaoQueryDemo {
    static Configuration conf= null;
    static {
        conf = HBaseConfiguration.create();
    }

    public static void queryByRow(String tableName,String rowKey) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);
        if (!admin.tableExists(tableName)) {
            admin.close();
            System.out.println(tableName+"表不存在！");
            System.exit(1);
        }

        Get get = new Get(rowKey.getBytes());
        HTable table = new HTable(conf, tableName);
        Result res = table.get(get);
        Cell[] cel = res.rawCells();
        if (cel.length==0) {
            System.out.println("没有该行键："+rowKey);
            table.close();
            System.exit(1);
        }


        for (Cell ce : cel) {
            String fam = new String(CellUtil.cloneFamily(ce));
            String qua = new String(CellUtil.cloneQualifier(ce));
            String val = new String(CellUtil.cloneValue(ce));
            String row = new String(CellUtil.cloneRow(ce));
            long tim = ce.getTimestamp();
            System.out.println("行健="+row+",列族="+fam+",列="+qua+",值="+val+",时间戳="+tim);
        }
        table.close();
    }

    public static void main(String[] args) throws IOException {
        queryByRow("stu","rw001");
    }
}
