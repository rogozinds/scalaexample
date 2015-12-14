package com.puzzle.solution

/**
 * Created by dmitrii on 14/12/15.
 */
object Init {
  class Items(items:List[Card]) {
    def get(index:Int) = items(index)
  }
  val items = new Items(List(new Card(1,2,3),new Card(1,3,2),new Card(3,2,1),new Card(2,3,1)));
  val positions=new PositionMap(List(new Position(null,List()),
    new Position(null,List((2,1,0))),
    new Position(null,List((1,0,1),(0,1,2))),
    new Position(null,List((2,0,1)))
    ))
}
