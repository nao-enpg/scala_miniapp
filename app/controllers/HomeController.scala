package controllers

import javax.inject._
import play.api.mvc._
import models._
import play.api.libs.json.Json

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  private val quiz = Quiz(
    List(
      Question(1, "今日食べたものが、マック、焼肉、ラーメン、アイスって完全に脂肪フラグ", List("校長", "ひろゆき"), 0),
      // 他の質問も同様に追加
    )
  )

  def index = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(quiz))
  }

  def submit = Action { implicit request: Request[AnyContent] =>
    // フォームから回答を取得し、正誤を評価するロジックをここに記述
    Ok("結果")
  }
}
