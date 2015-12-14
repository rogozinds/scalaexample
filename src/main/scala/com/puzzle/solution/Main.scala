package com.puzzle.solution


object Main extends App{

  Console.println(Init.positions.isValid())
  Console.println(Init.positions)
  Init.positions.solve()
  Console.println(Init.positions)

}
