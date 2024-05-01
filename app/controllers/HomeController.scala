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
      Question(2, "「飲み会のシメはラーメンじゃなくて、ステーキだよ」という思想の人達と飲みました", List("校長", "ひろゆき"), 0),
      Question(3, "痩せたくないなら痩せなくていいんじゃないですか？", List("校長", "ひろゆき"), 0),
      Question(4, "昼はコーヒーミーティング。夜はラーメンミーティング。", List("校長", "ひろゆき"), 0),
      Question(5, "頭の中ではメッシやクリスティアーノ・ロナウドを超えるプレーをしている", List("校長", "ひろゆき", "本田圭佑"), 0),
      Question(6, "頭悪いんだから独学止めた方がいいっすよ", List("校長", "ひろゆき"), 0),
      Question(7, "あなたが避けられてるんじゃないですかね？", List("校長", "ひろゆき"), 0),
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
