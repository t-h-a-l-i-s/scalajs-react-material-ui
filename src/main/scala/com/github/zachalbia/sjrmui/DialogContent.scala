package com.github.zachalbia.sjrmui

import japgolly.scalajs.react.vdom.VdomNode
import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object DialogContent {

  @JSImport("material-ui", "DialogContent")
  @js.native
  private object RawComponent extends js.Object

  @js.native
  private[sjrmui] trait Props extends js.Object {
    var classes: js.Dictionary[String] = js.native
    var className: js.UndefOr[String] = js.native
  }

  sealed abstract case class ClassKey(get: String) extends StringType
  object root extends ClassKey("root")

  private val component = JsComponent[Props, Children.Varargs, Null](RawComponent)

  def apply(
      classes:   Map[String, String] = Map.empty,
      className: js.UndefOr[String]  = js.undefined)(children: VdomNode*) = {
    val p = (new js.Object).asInstanceOf[Props]
    p.classes = classes
    p.className = className
    component(p)(children: _*)
  }
}
