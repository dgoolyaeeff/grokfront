import scalatags.Text.all.*
import scalatags.Text.tags2.{section, title}
import cask.*

object Gf extends cask.MainRoutes:
  @cask.get("/styles.css")
  def s() = 
    val path: os.Path = 
      os.root / "home" / "dimany" / "junk_tests" / "grokfront" / "Gf" / "src" / "styles.css"
    val content = os.read(path)
    content

  @cask.get("/icon.png")
  def i() =
    val path: os.Path = 
      os.root / "home" / "dimany" / "junk_tests" / "grokfront" / "Gf" / "src" / "icon.png"
    val content = os.read.bytes(path)
    cask.Response(content, 200, Seq(("Content-Type", "image/png")))
  
  @cask.get("/")
  def h() = 
    html(lang:="ru")(
      head(
        meta(charset:="UTF-8"),
        meta(httpEquiv:="X-UA-Compatible", content:="IE=edge"),
        meta(name:="viewport", content:="width=device-width, initial-scale=1.0"),
        title("grokfront"),
        link(rel:="stylesheet", href:="/styles.css"),
        link(rel:="shortcut icon", href:="/icon.png", `type`:="image/x-icon")
      ),
      body(
        p(cls:="red")("test")
      )
    )
  
  initialize()
end Gf

