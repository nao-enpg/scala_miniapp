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
      Question(2, "「飲み会のシメはラーメンじゃなくて、ステーキだよ」という思想の人達と飲みました", List("校長", "ひろゆき"), 1),
      Question(3, "痩せたくないなら痩せなくていいんじゃないですか？", List("校長", "ひろゆき"), 1),
      Question(4, "酒を飲んだらSNSでやることはただ1つです。それは「ラーメンをアップする」です", List("校長", "ひろゆき"), 0),
      Question(5, "頭の中ではメッシやクリスティアーノ・ロナウドを超えるプレーをしている", List("校長", "ひろゆき", "本田圭佑"), 2),
      Question(6, "頭悪いんだから独学止めた方がいいっすよ", List("校長", "ひろゆき"), 1),
      Question(7, "あなたが避けられてるんじゃないですかね？", List("校長", "ひろゆき"), 0),
      Question(8, "95%のエンジニアはいらないんじゃないかって思っちゃうんですけど", List("校長", "ひろゆき", "せとゆき"), 2),
      Question(9, "プログラムって1個できるようになると他の言語に行くの簡単なんですよ", List("校長", "ひろゆき"), 1),
      Question(10, "Vimはほとんどやらないです、はい、すみません。", List("校長", "ひろゆき"), 1),
    )
  )

  def index = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(quiz))
  }

  def submit = Action { implicit request: Request[AnyContent] =>
  val answers = request.body.asFormUrlEncoded.getOrElse(Map.empty).flatMap { case (key, values) =>
    key.toIntOption.flatMap { intKey =>
      values.headOption.flatMap(_.toIntOption).map(intKey -> _)
    }
  }

  val results = quiz.questions.map { question =>
    val userAnswer = answers.getOrElse(question.id, -1)
    question -> (userAnswer == question.correctAnswer)
  }

  Ok(views.html.result(results)) // 結果表示画面に結果を渡す
  }
}