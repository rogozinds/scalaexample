package com.puzzle.solution

import com.puzzle.solution.Init.Items

//connected (index of connected card,this,that)
class Position(var card:Card,connected:List[(Int,Int,Int)]) {


  override def toString():String = {
    if (card==null) {
      return "empty"
    }
    card.a + " "+ card.b + " "+card.c
  }
  def isValidated(): Boolean ={
    if(isEmpty) {
      true
    }
    else {
      val validItems=for (item<-connected) yield {
        val thisIndex=item._2
        val thatIndex=item._3
        if(item._1==Nil || Init.positions.get(item._1).isEmpty){
          true
        } else {
          Init.items.get(thisIndex)==Init.items.get(thatIndex)
        }
      }
      !validItems.contains(false)
    }
  }

  def isEmpty:Boolean = card == null;
  def removeCard() ={
    card =null;
  }
  def addCard(card: Card) = {
    this.card=card
  }
}