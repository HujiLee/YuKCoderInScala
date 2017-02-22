package No419直角三角形

import scala.io.StdIn

/**
  * Created by Administrator on 2016/11/25 0025.
  */
object Main extends App {
  val Array(a, b) = StdIn.readLine().split(" ").map(x => x.toInt)
  val long = math.max(a, b)
  val short = math.min(a, b)
  if(long!=short){
    println(
      math.pow(
        1*math.pow(long,2)-math.pow(short,2)
        , 0.5
      )
    )
  }else{
    println(
      math.pow(2,0.5)*long
    )
  }


}
