

import com.julianpeeters.caseclass.generator._
import com.novus.salat._
import com.novus.salat.global._
import com.mongodb.casbah.Imports._ 
import scala.reflect.runtime.universe._



import org.specs2._
import mutable._
import specification._

class AnyRefAnyRefSpec extends mutable.Specification {

 "given a dynamically generated case class MyRecord_AnyRefAnyRefSpec(a: AnyRef, b: AnyRef) as a type parameter, a grater" should {
    "serialize and deserialize correctly" in {


  val valueMembers: List[FieldData] = List(FieldData("a",typeOf[AnyRef]), FieldData("b",typeOf[AnyRef]))
  val classData = ClassData(ClassNamespace(Some("models")), ClassName("MyRecord_AnyRefAnyRefSpec"), ClassFieldData(valueMembers))
  val dcc = new DynamicCaseClass(classData)


  val typeTemplate = dcc.runtimeInstance

  type MyRecord = typeTemplate.type



  val dbo = grater[MyRecord].asDBObject(typeTemplate)
    println(dbo)

  val obj = grater[MyRecord].asObject(dbo)
    println(obj)
 

      typeTemplate === obj
    }
}



}
