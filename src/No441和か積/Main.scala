package No441和か積

import scala.io.StdIn

/**
  * Created by Administrator on 2016/12/26 0026.
  */
object Main  extends App{

  val bigInts: Array[BigInt] = StdIn.readLine().split(" ").map(x=>BigInt.apply(x))
  val sum = bigInts.sum
  val mul = bigInts.product
  val cha = sum-mul
  if(cha>0){
    println("S")
  }else if(cha<0){
    println("P")
  }else{
    println("E")
  }


}
