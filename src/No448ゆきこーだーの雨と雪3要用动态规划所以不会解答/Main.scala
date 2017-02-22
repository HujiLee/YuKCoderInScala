package No448ゆきこーだーの雨と雪3要用动态规划所以不会解答

/**
  * Created by Administrator on 2016/11/26 0026.
  */

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn._

class Plan {
  private[this] var _totalDiff: Int = 0
  private[this] var _maxDiff: Int = 0

  private def totalDiff: Int = _totalDiff

  private def maxDiff: Int = _maxDiff

  def addDiff(int: Int): Plan = {
    if (_maxDiff < int) {
      _maxDiff = int
    }
    _totalDiff += int
    return this
  }

}

object Ns {
  type Time = Int
  type Difficulty = Int
  type Tryed = Boolean
  private var (startTime, endTime,step) = (0, 0,0)
  val (map, plans) = (new mutable.LinkedHashMap[Time, (Difficulty, Tryed)](), new ArrayBuffer[Plan]())

  def setStart(int: Int, boolean: Boolean): Ns.type = {
    if (boolean) {
      startTime = int
    }
    return this
  }

  def setEnd(int: Int, boolean: Boolean): Ns.type = {
    if (boolean) {
      endTime = int
    }
    return this
  }

  def setStep(int: Int): Ns.type ={
    step = int
    return this
  }
  def addTimeDiff(time: Time, difficulty: Difficulty): Ns.type = {
    map += (time -> (difficulty, false))
    return this
  }

  def fillPlans: Ns.type = {
    for (i <- map) {


    }

    return this
  }

}

object Main extends App {
  val Array(n, k) = readLine().split(" ").map(c => c.toInt)
  val ns = {
    for (i <- 1 to n) {
      val Array(ti, di) = readLine().split(" ").map(c => c.toInt)
      Ns.addTimeDiff(ti, di).setStart(ti, i == 1).setEnd(ti, i == n)
    }
    Ns.setStep(k).fillPlans
  }
  print("")

}
