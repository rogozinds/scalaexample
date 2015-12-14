package com.puzzle.solution


class Card(var a:Int, var b:Int,var c:Int) {
  var initialValues=List(a,b,c)
  var nRotation=0;
  def rotate(): Unit ={
    nRotation+=1;
    val tmp=a;
    a=c;
    c=b;
    b=tmp;
  }
  def isRotated()= nRotation>2
  def reset= {
    nRotation=0;
    a=initialValues(0);
    b=initialValues(0);
    c=initialValues(0);
  }
}
