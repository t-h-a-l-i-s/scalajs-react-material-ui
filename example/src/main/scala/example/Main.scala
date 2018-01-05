package example

import com.pangwarta.sjrmui._
import com.pangwarta.sjrmui.Typography.Type
import example.CssSettings._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import ExampleStyles._

import scalacss.ScalaCssReact._

object Main {

  def main(args: Array[String]): Unit = {
    val app =
      <.div(
        ExampleAppBar(),
        <.div(
          ExampleStyles.margin,
          Grid(container = true)()(
            Grid(item = true, md = 6, sm = 12, xs = 12)()(
              TopSection(),
              PaperExample,
              CardExample,
              SimpleExpansionPanel()
            )
          )
        ),
        SimpleBottomNav()
      )
    app.renderIntoDOM(dom.document.getElementById("root"))
    ExampleStyles.addToDocument()
  }

  private val PaperExample =
    Paper(
      classes   = Map(
        Paper.root -> Seq(ExampleStyles.paper, ExampleStyles.paperExample),
        Paper.shadow2 -> ExampleStyles.paperShadow2
      ),
      elevation = 5
    )("foo" -> "bar")(
        Typography(component = "p", `type` = Type.body1)()(
          "The quick brown fox jumps over the lazy dog."
        ),
        AlertDialog(),
        Checkbox(value = "Check me")(),
        Chip(avatar = Avatar()()("ZA"))()
      )

  private val CardExample =
    Card(className = Seq(ExampleStyles.paper, ExampleStyles.card))()(
      CardHeader(
        avatar = Avatar(className = ExampleStyles.cardAvatar.className.value)()("ZA").rawElement,
        title  = <.span("Merry Christmas").rawElement
      )()(),
      CardActions()()()
    )
}
