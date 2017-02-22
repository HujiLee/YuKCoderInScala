package No24数当てゲーム

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by Administrator on 2016/12/24 0024.
  */
object Sub {
  def intersection(arrSet: mutable.HashSet[Array[Int]]): mutable.HashSet[Int] = {
    var count = 0
    var set = new mutable.HashSet[Int]()

    for(arr<-arrSet){
      if(count==0){
        for(i<-arr){
          set.add(i)
        }
      }else{
        set={
          val tempSet = new mutable.HashSet[Int]()
          for(i<-arr){
            if(set.contains(i)){
              tempSet.add(i)
            }
          }
          tempSet
        }
      }
      count+=1
    }
    set
  }

  def intersection(intSet: mutable.HashSet[Int], numbers: mutable.TreeSet[Int]): Int = {
    for(i<-numbers){
      if(intSet.contains(i)){
        return i
      }
    }
    return  -1
  }
}

object Main extends App {
  val numbers = new mutable.TreeSet[Int]()
  for (i <- 0 to 9) {
    numbers += i
  }
  val count = StdIn.readInt()
  val yesSet = new mutable.HashSet[Array[Int]]()
  for (_ <- 1 to count) {
    val input = StdIn.readLine().split(" ")
    val array = input.toList.slice(0, 4).toArray.map(i => i.toInt)
    if (input.last == "YES") {
      yesSet.add(array)
    }
    else {
      for (i <- array) {
        numbers.remove(i)
      }
    }
  }
  if (yesSet.size > 0) {
    println(Sub.intersection(Sub.intersection(yesSet), numbers))
  } else {
    println(numbers.toArray.apply(0))
  }

}

/**
入力	結果	実行時間
使用メモリ
01.txt	AC	362 ms
36704 KB
02.txt	AC	384 ms
37844 KB
03.txt	AC	363 ms
37128 KB
04.txt	AC	386 ms
36808 KB
05.txt	AC	364 ms
36796 KB
06.txt	AC	388 ms
36788 KB
07.txt	AC	398 ms
36752 KB
08.txt	AC	386 ms
36884 KB
09.txt	AC	379 ms
36784 KB
10.txt	AC	385 ms
37040 KB
  */