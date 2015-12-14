import com.puzzle.solution.Position

import scala.util.control.Exception

class Items(items:List[Card]) {
  def get(index:Int) = items(index)
}
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
val items = new Items(List(new Card(1,2,3),new Card(1,3,2),new Card(3,2,1),new Card(2,3,1)));
val positions=new Positions(List(new Position(null,List()),
  new Position(null,List((2,1,0))),
  new Position(null,List((1,0,1),(0,1,2))
  )))

//connected (index of connected card,this,that)
class Position(var card:Card,connected:List[(Int,Int,Int)]) {
  def isValidated(): Boolean ={
    if(isEmpty) {
      false
    }
    else {
    val validItems=for (item<-connected) yield {
      val thisIndex=item._2
      val thatIndex=item._3
      if(item._1==Nil || positions.get(item._1).isEmpty){
        true
      } else {
        items.get(thisIndex)==items.get(thatIndex)
      }
    }
    !validItems.contains(false)
    }
  }

  def isEmpty:Boolean = card != null;
  def removeCard() ={
    card =null;
  }
  def addCard(card: Card) = {
    this.card=card
  }
}

class Positions(positions:List[Position]) {
  val a=true;
  def isValid():Boolean = {
    positions.find(p=> !(p.isValidated)).isEmpty
  }

  def get = positions;
  def addCard(c:Card,index:Int)=  positions(index).addCard(c);
  def removeCard(index:Int)=positions(index)
  def tryCardOnPosition(c:Card,posIndex:Int,solution:Positions):Boolean= {

    solution.addCard(c,posIndex)
    while(!solution.isValid()&& c.isRotated()){
      c.rotate()
    }
    if (solution.isValid()) {
      c.reset
      solution.removeCard(posIndex)
      return true
    }
    else {
      return false;
    }
  }
  def backtrack(c:Card,curPos:Int) :Int= {
    if(curPos<0) {
      return -1;
    }
    else if (c.isRotated()) {
      c.reset
      return curPos;
    } else {
      return backtrack(items.get(curPos-1),curPos-1)
    }
  }
  def solve() = {
    var curPos=0;
    val solution=new Positions(List())
    while (!isValid() && curPos>=0) {
      val c=items.get(curPos)
      if(tryCardOnPosition(c,curPos,solution)) {
        curPos=curPos+1;
      } else {
        curPos=backtrack(c,curPos);
      }
    }
  }
}
positions.isValid()

