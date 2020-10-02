package frameless

import org.apache.spark.sql.Dataset
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funsuite.AnyFunSuite

case class Event(id: Int, name: String)

class BlahTests extends AnyFunSuite with BeforeAndAfterAll with SparkTesting {

  test("blahblah") {

    val ss = session
    import ss.implicits._

    val ds: Dataset[Event] = session.createDataset(Seq.empty[Event])
    val tds: TypedDataset[Event] = TypedDataset.create(ds)
    //val nameColumn: TypedColumn[Event, String] = tds.col(_.name)
    val idColumn = tds.col(_.id)

    println(idColumn.expr)

  }

}
