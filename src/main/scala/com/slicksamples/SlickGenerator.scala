package com.slicksamples


/**
 * Generates code
 * Created by scala on 10/2/15.
 */
object SlickGenerator extends App {

  slick.codegen.SourceCodeGenerator.main(
  Array("scala.slick.driver.MySQLDriver", "com.mysql.jdbc.Driver",
    "jdbc:mysql://localhost:3306/world",
    "/home/scala/workspaceIntellij/slickTest/src/main/scala", "com.slicksamples.world.entity", "worlduser", "123456")
  )
}
