package com.slicksamples

import com.slicksamples.world.entity.Tables.Country

import scala.slick.lifted.TableQuery
import scala.slick.driver.MySQLDriver.simple._


/**
 * Created by scala on 10/2/15.
 */
object WorldDemo extends App {

  val qCountries = TableQuery[Country]
  //val query = sql"select Code, Name, Continent from world.Country".as[(String, String, String)]
  val db = Database.forURL("jdbc:mysql://localhost:3306/world", driver="com.mysql.jdbc.Driver", user = "worlduser", password = "123456")
  val filterId = "Brazil"
  db.withSession { implicit session =>
    println(qCountries.selectStatement)
    //query.list.foreach(println)
    val filter = qCountries.filter(_.name === filterId).list
    filter.foreach(println)
  }
}
