package No446ゆきこーだーの雨と雪2


import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by Administrator on 2016/11/25 0025.
  */


class Question($star: Int) {
  val star = $star
  private[this] var _countSolved: Int = 0

  def countSolved: Int = _countSolved

  private def countSolved_=(value: Int): Unit = {
    _countSolved = value
  }


  def beSolved: Int = {
    _countSolved += 1
    _countSolved
  }

}

class User($name: String) {
  private var totalScore = -1
  private var mapQuesIndex2Score = new mutable.HashMap[Int,Double]()

  def toString(problems: mutable.HashMap[Int, Question]): String = {
    def singleQustionCalc(question: Question, solvedOrder: Int): Double = {
      math.floor(50 * question.star + (50 * question.star) / ((8 + 2 * solvedOrder) / 10.0))
    }

    if (totalScore == -1) {
      for(i<-problems.keys){
        if(mapQuesIndex2SolvedOrder.contains(i)){
          mapQuesIndex2Score+=(i->singleQustionCalc(problems(i),mapQuesIndex2SolvedOrder(i)))
        }else{
          mapQuesIndex2Score+=(i->0.0)
        }
      }
      totalScore = {
        var $ = 0.0
        for(i<-mapQuesIndex2Score.keys){
          $+=mapQuesIndex2Score(i)
        }
        $.toInt
      }
    }
    var result = {
      var $ = ""
      for(i<- 0 until mapQuesIndex2Score.size){
        if(i>0){
          $+=" "
        }
        $+=mapQuesIndex2Score(i).toInt
      }
      $+=(" "+totalScore)
      $
    }
    result
  }

  def getTotal:Int={
    require(totalScore>=0)
    return totalScore
  }

  private var order = 0
  val name = $name
  private var mapQuesIndex2SolvedOrder = new mutable.HashMap[Int, Int]()

  def setOrder(int: Int): User = {
    this.order = int
    this
  }
  def getOrder:Int=order

  def solve(index: Int, solvedOrder: Int): User = {
    mapQuesIndex2SolvedOrder += (index -> solvedOrder)
    this
  }
}

object Users {
  /**
    * 0->Question1{star 1;2 men solved me}
    */
  private var problemsIndex2Question = new mutable.HashMap[Int, Question]()
  private var users = new mutable.LinkedHashMap[String, User]()
  private var usersList:List[(String, User)] = null

  def initStars(ints: Array[Int]): Users.type = {
    for (i <- ints.indices) {
      problemsIndex2Question += (i -> new Question(ints(i)))
    }
    return this
  }

  private def char2Index(chars: String): Int = chars.charAt(0) - 'A'

  def whoSolvedWhich(name: String, problem: String): Users.type = {
    val proIndex = char2Index(problem)
    if (problemsIndex2Question.contains(proIndex)) {
      problemsIndex2Question(proIndex).beSolved
    } else {
      //不可能啊 应该都在
      throw new Exception("I'll never show")
    }
    if (users.contains(name)) {
      users(name).solve(proIndex, problemsIndex2Question(proIndex).countSolved)
    } else {
      users.+=(name -> new User(name).solve(proIndex, problemsIndex2Question(proIndex).countSolved))
    }
    return this
  }

  def setUserOrder(name: String, order: Int): Users.type = {
    require(users.contains(name), "这个函数必须在whoSolvedWhich后执行")
    users(name).setOrder(order)
    return this
  }

  def sortUsers: Users.type ={
    usersList = users.toList
    for(i<-usersList){
      i._2.toString(problemsIndex2Question)
    }

    usersList = usersList.sortWith((a,b)=>{
      (a._2.getTotal>b._2.getTotal) match {
        case true=>true
        case false=>{
          (a._2.getTotal<b._2.getTotal) match {
            case true=>false
            case false=>a._2.getOrder<b._2.getOrder
          }
        }
      }
    })

    this
  }

  def printAfterSort={
    for(i<-usersList.indices){
      println(s"${i+1} ${usersList(i)._1} ${usersList(i)._2.toString(problemsIndex2Question)}")
    }
  }


}

/*object UserOrder{
  private var map = new mutable.HashMap[String,Int]()
  def push(username:String): UserOrder.type ={
    if(!map.contains(username)){
      map+=(username->(map.size+1))
    }else{
      for(i<-map.keys if map(i) > map(username)){
        map(i)-=1
      }
      map(username) = map.size
    }
    return this
  }
  def getMap: mutable.Map[String, Int] = map
}*/

object Main extends App {
  //  val order = UserOrder
  val users = Users.initStars(
    {
      //noinspection ScalaUnusedSymbol
      val countQuestions = StdIn.readInt()
      StdIn.readLine().split(" ").map(x => x.toInt)
    }
  )

  val T = StdIn.readInt()


  for (i <- 1 to T) {
    /**
      * name=username
      * ques = "ABCD...."
      */
    val Array(name, ques) = StdIn.readLine().split(" ")
    Users.whoSolvedWhich(name, ques).setUserOrder(name, i)
    //    order.push(name)

  }
  users.sortUsers.printAfterSort


  print("")


}
/**
テストケース

テストケース表示
入力	結果	実行時間
使用メモリ
0_sample_01.in	AC	406 ms
36828 KB
0_sample_02.in	AC	426 ms
37048 KB
0_sample_03.in	AC	403 ms
36836 KB
gen_case_1.txt	AC	519 ms
54916 KB
gen_case_2.txt	AC	539 ms
46196 KB
gen_case_3.txt	AC	695 ms
52012 KB
gen_case_4.txt	AC	677 ms
72012 KB
gen_case_5.txt	AC	626 ms
56684 KB
gen_case_6.txt	AC	618 ms
55860 KB
gen_case_7.txt	AC	684 ms
73824 KB
gen_case_8.txt	AC	492 ms
55468 KB
gen_case_9.txt	AC	564 ms
53804 KB
gen_case_10.txt	AC	531 ms
53224 KB
gen_case_11.txt	AC	645 ms
64700 KB
gen_case_12.txt	AC	766 ms
73972 KB
gen_case_13.txt	AC	525 ms
55800 KB
gen_case_14.txt	AC	536 ms
55444 KB
gen_case_15.txt	AC	503 ms
51896 KB
gen_case_16.txt	AC	466 ms
42680 KB
gen_case_17.txt	AC	766 ms
93200 KB
gen_case_18.txt	AC	685 ms
74920 KB
gen_case_19.txt	AC	546 ms
55540 KB
gen_case_20.txt	AC	509 ms
51056 KB
gen_max_1.txt	AC	530 ms
53976 KB
gen_max_2.txt	AC	677 ms
73004 KB
gen_max_3.txt	AC	690 ms
90420 KB
gen_max_4.txt	AC	579 ms
58048 KB
gen_max_5.txt	AC	558 ms
62388 KB テストケース一括ダウンロード
ソースコード

diff #
raw source code プレゼンテーションモードにする
  */