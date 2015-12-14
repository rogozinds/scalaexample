package com.example

/**
 * Created by dmitrii on 27/11/15.
 */
object Util {
  def main(args: Array[String]) {
    val list=List(1,2,3)

    println(list:+10)
  }

  def revert(v:String):String= {
    v.toList.foldRight(List[Char]()) ((list,a)=>a:+list).mkString
  }
}
