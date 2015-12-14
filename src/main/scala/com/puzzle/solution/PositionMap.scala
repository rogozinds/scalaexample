package com.puzzle.solution


class PositionMap(var positions:List[Position]) {
  if(positions.isEmpty) {
    positions=(for( a <- 0 to 3) yield{
      new Position(null,List())
    }).toList
  }
  val items = Init.items;

  def isComplete() :Boolean = {
    positions.find(p=>(p.isEmpty)).isEmpty
  }
  def isValid():Boolean = {
    positions.find(p=> !(p.isValidated)).isEmpty
  }

  override def toString():String = {
    positions mkString "/"
  }
  def get = positions;
  def addCard(c:Card,index:Int)=  positions(index).addCard(c);
  def removeCard(index:Int)=positions(index)
  def tryCardOnPosition(c:Card,posIndex:Int,solutions:PositionMap):Boolean= {

    solutions.addCard(c,posIndex)
    while(!(solutions.isValid() || c.isRotated())){
      c.rotate()
    }
    if (solutions.isValid()) {
      return true
    }
    else {
      c.reset
      solutions.removeCard(posIndex)
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
    val solution=new PositionMap(List())
    while ((!solution.isValid() || !solution.isComplete()) && curPos>=0) {
      val c=items.get(curPos)
      if(tryCardOnPosition(c,curPos,solution)) {
        curPos=curPos+1;
      } else {
        curPos=backtrack(c,curPos);
      }
    }
  }
}
