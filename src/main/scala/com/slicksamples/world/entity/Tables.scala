package com.slicksamples.world.entity
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = City.ddl ++ Country.ddl ++ Countrylanguage.ddl
  
  /** Entity class storing rows of table City
   *  @param id Database column ID DBType(INT), AutoInc, PrimaryKey
   *  @param name Database column Name DBType(CHAR), Length(35,false), Default()
   *  @param countrycode Database column CountryCode DBType(CHAR), Length(3,false), Default()
   *  @param district Database column District DBType(CHAR), Length(20,false), Default()
   *  @param population Database column Population DBType(INT), Default(0) */
  case class CityRow(id: Int, name: String = "", countrycode: String = "", district: String = "", population: Int = 0)
  /** GetResult implicit for fetching CityRow objects using plain SQL queries */
  implicit def GetResultCityRow(implicit e0: GR[Int], e1: GR[String]): GR[CityRow] = GR{
    prs => import prs._
    CityRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Int]))
  }
  /** Table description of table City. Objects of this class serve as prototypes for rows in queries. */
  class City(_tableTag: Tag) extends Table[CityRow](_tableTag, "City") {
    def * = (id, name, countrycode, district, population) <> (CityRow.tupled, CityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, countrycode.?, district.?, population.?).shaped.<>({r=>import r._; _1.map(_=> CityRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column ID DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column Name DBType(CHAR), Length(35,false), Default() */
    val name: Column[String] = column[String]("Name", O.Length(35,varying=false), O.Default(""))
    /** Database column CountryCode DBType(CHAR), Length(3,false), Default() */
    val countrycode: Column[String] = column[String]("CountryCode", O.Length(3,varying=false), O.Default(""))
    /** Database column District DBType(CHAR), Length(20,false), Default() */
    val district: Column[String] = column[String]("District", O.Length(20,varying=false), O.Default(""))
    /** Database column Population DBType(INT), Default(0) */
    val population: Column[Int] = column[Int]("Population", O.Default(0))
    
    /** Foreign key referencing Country (database name city_ibfk_1) */
    lazy val countryFk = foreignKey("city_ibfk_1", countrycode, Country)(r => r.code, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table City */
  lazy val City = new TableQuery(tag => new City(tag))
  
  /** Entity class storing rows of table Country
   *  @param code Database column Code DBType(CHAR), PrimaryKey, Length(3,false), Default()
   *  @param name Database column Name DBType(CHAR), Length(52,false), Default()
   *  @param continent Database column Continent DBType(ENUM), Length(13,false), Default(Asia)
   *  @param region Database column Region DBType(CHAR), Length(26,false), Default()
   *  @param surfacearea Database column SurfaceArea DBType(FLOAT), Default(0.0)
   *  @param indepyear Database column IndepYear DBType(SMALLINT), Default(None)
   *  @param population Database column Population DBType(INT), Default(0)
   *  @param lifeexpectancy Database column LifeExpectancy DBType(FLOAT), Default(None)
   *  @param gnp Database column GNP DBType(FLOAT), Default(None)
   *  @param gnpold Database column GNPOld DBType(FLOAT), Default(None)
   *  @param localname Database column LocalName DBType(CHAR), Length(45,false), Default()
   *  @param governmentform Database column GovernmentForm DBType(CHAR), Length(45,false), Default()
   *  @param headofstate Database column HeadOfState DBType(CHAR), Length(60,false), Default(None)
   *  @param capital Database column Capital DBType(INT), Default(None)
   *  @param code2 Database column Code2 DBType(CHAR), Length(2,false), Default() */
  case class CountryRow(code: String = "", name: String = "", continent: String = "Asia", region: String = "", surfacearea: Float = 0.0F, indepyear: Option[Short] = None, population: Int = 0, lifeexpectancy: Option[Float] = None, gnp: Option[Float] = None, gnpold: Option[Float] = None, localname: String = "", governmentform: String = "", headofstate: Option[String] = None, capital: Option[Int] = None, code2: String = "")
  /** GetResult implicit for fetching CountryRow objects using plain SQL queries */
  implicit def GetResultCountryRow(implicit e0: GR[String], e1: GR[Float], e2: GR[Option[Short]], e3: GR[Int], e4: GR[Option[Float]], e5: GR[Option[String]], e6: GR[Option[Int]]): GR[CountryRow] = GR{
    prs => import prs._
    CountryRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[Float], <<?[Short], <<[Int], <<?[Float], <<?[Float], <<?[Float], <<[String], <<[String], <<?[String], <<?[Int], <<[String]))
  }
  /** Table description of table Country. Objects of this class serve as prototypes for rows in queries. */
  class Country(_tableTag: Tag) extends Table[CountryRow](_tableTag, "Country") {
    def * = (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) <> (CountryRow.tupled, CountryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (code.?, name.?, continent.?, region.?, surfacearea.?, indepyear, population.?, lifeexpectancy, gnp, gnpold, localname.?, governmentform.?, headofstate, capital, code2.?).shaped.<>({r=>import r._; _1.map(_=> CountryRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7.get, _8, _9, _10, _11.get, _12.get, _13, _14, _15.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column Code DBType(CHAR), PrimaryKey, Length(3,false), Default() */
    val code: Column[String] = column[String]("Code", O.PrimaryKey, O.Length(3,varying=false), O.Default(""))
    /** Database column Name DBType(CHAR), Length(52,false), Default() */
    val name: Column[String] = column[String]("Name", O.Length(52,varying=false), O.Default(""))
    /** Database column Continent DBType(ENUM), Length(13,false), Default(Asia) */
    val continent: Column[String] = column[String]("Continent", O.Length(13,varying=false), O.Default("Asia"))
    /** Database column Region DBType(CHAR), Length(26,false), Default() */
    val region: Column[String] = column[String]("Region", O.Length(26,varying=false), O.Default(""))
    /** Database column SurfaceArea DBType(FLOAT), Default(0.0) */
    val surfacearea: Column[Float] = column[Float]("SurfaceArea", O.Default(0.0F))
    /** Database column IndepYear DBType(SMALLINT), Default(None) */
    val indepyear: Column[Option[Short]] = column[Option[Short]]("IndepYear", O.Default(None))
    /** Database column Population DBType(INT), Default(0) */
    val population: Column[Int] = column[Int]("Population", O.Default(0))
    /** Database column LifeExpectancy DBType(FLOAT), Default(None) */
    val lifeexpectancy: Column[Option[Float]] = column[Option[Float]]("LifeExpectancy", O.Default(None))
    /** Database column GNP DBType(FLOAT), Default(None) */
    val gnp: Column[Option[Float]] = column[Option[Float]]("GNP", O.Default(None))
    /** Database column GNPOld DBType(FLOAT), Default(None) */
    val gnpold: Column[Option[Float]] = column[Option[Float]]("GNPOld", O.Default(None))
    /** Database column LocalName DBType(CHAR), Length(45,false), Default() */
    val localname: Column[String] = column[String]("LocalName", O.Length(45,varying=false), O.Default(""))
    /** Database column GovernmentForm DBType(CHAR), Length(45,false), Default() */
    val governmentform: Column[String] = column[String]("GovernmentForm", O.Length(45,varying=false), O.Default(""))
    /** Database column HeadOfState DBType(CHAR), Length(60,false), Default(None) */
    val headofstate: Column[Option[String]] = column[Option[String]]("HeadOfState", O.Length(60,varying=false), O.Default(None))
    /** Database column Capital DBType(INT), Default(None) */
    val capital: Column[Option[Int]] = column[Option[Int]]("Capital", O.Default(None))
    /** Database column Code2 DBType(CHAR), Length(2,false), Default() */
    val code2: Column[String] = column[String]("Code2", O.Length(2,varying=false), O.Default(""))
  }
  /** Collection-like TableQuery object for table Country */
  lazy val Country = new TableQuery(tag => new Country(tag))
  
  /** Entity class storing rows of table Countrylanguage
   *  @param countrycode Database column CountryCode DBType(CHAR), Length(3,false), Default()
   *  @param language Database column Language DBType(CHAR), Length(30,false), Default()
   *  @param isofficial Database column IsOfficial DBType(ENUM), Length(2,false), Default(F)
   *  @param percentage Database column Percentage DBType(FLOAT), Default(0.0) */
  case class CountrylanguageRow(countrycode: String = "", language: String = "", isofficial: String = "F", percentage: Float = 0.0F)
  /** GetResult implicit for fetching CountrylanguageRow objects using plain SQL queries */
  implicit def GetResultCountrylanguageRow(implicit e0: GR[String], e1: GR[Float]): GR[CountrylanguageRow] = GR{
    prs => import prs._
    CountrylanguageRow.tupled((<<[String], <<[String], <<[String], <<[Float]))
  }
  /** Table description of table CountryLanguage. Objects of this class serve as prototypes for rows in queries. */
  class Countrylanguage(_tableTag: Tag) extends Table[CountrylanguageRow](_tableTag, "CountryLanguage") {
    def * = (countrycode, language, isofficial, percentage) <> (CountrylanguageRow.tupled, CountrylanguageRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (countrycode.?, language.?, isofficial.?, percentage.?).shaped.<>({r=>import r._; _1.map(_=> CountrylanguageRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column CountryCode DBType(CHAR), Length(3,false), Default() */
    val countrycode: Column[String] = column[String]("CountryCode", O.Length(3,varying=false), O.Default(""))
    /** Database column Language DBType(CHAR), Length(30,false), Default() */
    val language: Column[String] = column[String]("Language", O.Length(30,varying=false), O.Default(""))
    /** Database column IsOfficial DBType(ENUM), Length(2,false), Default(F) */
    val isofficial: Column[String] = column[String]("IsOfficial", O.Length(2,varying=false), O.Default("F"))
    /** Database column Percentage DBType(FLOAT), Default(0.0) */
    val percentage: Column[Float] = column[Float]("Percentage", O.Default(0.0F))
    
    /** Primary key of Countrylanguage (database name CountryLanguage_PK) */
    val pk = primaryKey("CountryLanguage_PK", (countrycode, language))
    
    /** Foreign key referencing Country (database name countryLanguage_ibfk_1) */
    lazy val countryFk = foreignKey("countryLanguage_ibfk_1", countrycode, Country)(r => r.code, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Countrylanguage */
  lazy val Countrylanguage = new TableQuery(tag => new Countrylanguage(tag))
}