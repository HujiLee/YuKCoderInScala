package No446ゆきこーだーの雨と雪1


import scala.io.StdIn

/**
  * Created by Administrator on 2016/11/25 0025.
  */
object Main extends App {
  def ng(): Unit = {
    println("NG")
  }

  def ok(): Unit = {
    println("OK")
  }

  def leadingZero(str: String): Boolean = {
    str.charAt(0) == '0' && str.length > 1
  }

  try {
    var A = StdIn.readLine()
    var B = StdIn.readLine()
    if (leadingZero(A) || leadingZero(B)) {
      throw new Exception("leading zero")
    }
    var (a, b) = (A.toInt, B.toInt)
    if (math.max(a, b) > 12345) {
      throw new Exception("> 12345")
    }
    ok()

  } catch {
    case ex: Exception => {
      Console.err.println(ex)
      ng()
    }
  }
}

/**
  * テストケース

テストケース表示
入力	結果	実行時間
使用メモリ
0_sample_1.in	AC	410 ms
36400 KB
0_sample_2.in	AC	382 ms
36424 KB
0_sample_3.in	AC	402 ms
36280 KB
0_sample_4.in	AC	379 ms
36356 KB
ng_01.in	AC	401 ms
38212 KB
ng_02.in	AC	390 ms
36400 KB
ng_03.in	AC	384 ms
36324 KB
ng_04.in	AC	410 ms
36592 KB
ng_05.in	AC	388 ms
36408 KB
ng_06.in	AC	405 ms
36352 KB
ng_07.in	AC	420 ms
36376 KB
ng_08.in	AC	496 ms
36172 KB
ok_01.in	AC	439 ms
36484 KB
ok_02.in	AC	397 ms
36364 KB
ok_03.in	AC	395 ms
36288 KB
ok_04.in	AC	383 ms
36340 KB
ok_05.in	AC	396 ms
36604 KB テストケース一括ダウンロード
ソースコード

diff #
raw source code プレゼンテーションモードにする
  */
