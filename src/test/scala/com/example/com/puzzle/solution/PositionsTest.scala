package com.example.com.puzzle.solution

import com.puzzle.solution.{Init, Card, PositionMap, Position}
import org.scalatest.FlatSpec

/**
 * Created by dmitrii on 14/12/15.
 */
class PositionsTest extends FlatSpec{

     behavior of "Solution validation Stack"

    //"Empty solution "
  ignore should "Valid and not complete" in {

      val solution = new PositionMap(List(new Position(null,List()),
        new Position(null,List((2,1,0))),
        new Position(null,List((1,0,1),(0,1,2))),
        new Position(null,List((2,0,1)))
      ))
      assert(solution.isValid())
      assert(!solution.isComplete())

    }

    "Solution 1,2,3 2,3,1 1,3,2" should "not Valid" in {
      val solution = new PositionMap(List(
        new Position(new Card(1,2,3),List()),
        new Position(new Card(2,3,1),List((2,1,0))),
        new Position(new Card(1,3,2),List((1,0,1),(0,1,2))),
        new Position(null,List((2,0,1)))
      ))
      Init.positions=solution;
      assert(!solution.isValid())

    }
}
