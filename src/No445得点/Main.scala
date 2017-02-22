package No445得点



import scala.io.StdIn._
/**
  * Created by Administrator on 2016/11/25 0025.
  */
object Main extends App{
  val Array(a,b) = readLine().split(" ").map(x=>x.toInt)

  println(
    50*a+math.floor(50*a/((8+2*b)/10.0)).toInt
  )

}
