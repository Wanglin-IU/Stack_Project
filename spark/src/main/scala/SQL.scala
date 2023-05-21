import org.apache.spark.sql.{DataFrame, SaveMode}

import java.util.Properties

object SQL {
  //MySQL配置项 返回结果以及表
  def options(result: DataFrame, table: String): Unit = {
    val prop = new Properties
    prop.setProperty("user", "root")
    prop.setProperty("password", "wang2002")
    prop.setProperty("driver", "com.mysql.cj.jdbc.Driver")
    //写入结果并指定数据库连接
    result.write.mode(SaveMode.Overwrite).jdbc("jdbc:mysql://localhost:3306/store", table, prop)
  }
}
