import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object Spark_Project extends App {
  private val session = SparkSession
    .builder()
    .master("local")
    .appName("T1")
    .getOrCreate()

  //读取csv的配置项
  private val StockOverFlow = session.read
    .format("csv")
    .option("sep", ",")
    .option("header", "true")
    .load("D:\\毕业设计\\stotag.csv")
  //创建临时视图
  StockOverFlow.createOrReplaceTempView("Stack")

  //编写SQL语句并将结果写入指定表
  //ToDo 技术标签
  private val Stack_all: Dataset[Row] = StockOverFlow.select("tag_name", "total_count").distinct()
  SQL.options(Stack_all, "Label_A_All")
  println(s"${Stack_all}导入MySQL成功")
  //  Stack_all.show()

  //ToDo 技术提问量Top10
  private val Top = session.sql("select tag_name,sum(post_count) as sum_post from " +
    "Stack group by tag_name order by sum_post desc limit 10")
  SQL.options(Top, "Label_B_Top")
  println(s"${Top}导入MySQL成功")
  //  Top.show()

  //ToDo 多维度分析:随机抽样技术
  private val Random = session.sql("select tag_name,total_count from Stack").distinct()
    .sample(withReplacement = false, 0.01).toDF()
  SQL.options(Random, "Label_C_Random")
  println(s"${Random}导入MySQL成功")
  //  Random.show()

  //ToDo 指定五项技术比较
  private val Compare = StockOverFlow.select("tag_name", "total_count")
    .distinct().where("tag_name in ('python','java','c#','scala','go')")
  SQL.options(Compare, "Label_D_Compare")
  println(s"${Compare}导入MySQL成功")
  //  Compare.show()

  //ToDo 2021年1至5月html,css,javascript,jquery,reactjs技术的提问趋势
  private val SMonth: Dataset[Row] = StockOverFlow.select("year_month", "tag_name", "post_count")
    .where("year_month in ('21-Jan','21-Feb','21-Mar','21-Apr','21-May') and " +
      "tag_name in ('html','css','javascript','jquery','reactjs')").orderBy("year_month")
  SQL.options(SMonth, "Label_E_SMonth")
  println(s"${SMonth}导入MySQL成功")
  //  SMonth.show()

  //ToDo 提问次数低于30次的技术
  private val Lower: DataFrame = session.sql("select tag_name,count(tag_id) as tag_count from " +
    "Stack group by tag_name having tag_count < 30")
  SQL.options(Lower, "Label_F_Lower")
  println(s"${Lower}导入MySQL成功")
  //  Lower.show()

  //释放资源
  session.close()
}
