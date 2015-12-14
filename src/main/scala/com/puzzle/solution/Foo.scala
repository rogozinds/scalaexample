package com.puzzle.solution

/**
 * Created by dmitrii on 14/12/15.
 */
class Foo(var positions:List[Position]) {
    if(positions.isEmpty) {
      positions=(for( a <- 0 to 3) yield{
        new Position(null,List())
      }).toList
    }
}
