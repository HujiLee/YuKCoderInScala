package japanese

import scala.io.StdIn

/**
  * Created by Administrator on 2016/12/27 0027.
  */
object Main extends App {
  while (true){
    val input = StdIn.readLine().split("　")
    /*printf(
      """
        |A：%sね。どうしてですか。
        |B：%sですから。
      """.stripMargin, input(0), input(1))*/
    printf(
      """
        |%sから、%s。
      """.stripMargin, input(0),input(1))

/*    printf(
      """
        |%sは%sです。->
        　%sは%sな%sです。
      """.stripMargin, input(0),input(1),input(0),input(1),input(2))*/

  }




}
