(ns stepmania-pre.core)

(set! (. js/window -onload) 
  (fn [] 
    (let [game (enchant/Game. 320 320)] ; ゲームオブジェクト生成
      (do
        (set! (. game -fps) 30) ; fpsを設定
        (. game preload "chara1.png") ; 画像を読み込む
        (set! (. game -onload) ; ロード終了時の処理
          (fn [] 
            (let [bear (enchant/Sprite. 32 32)] ; スプライト生成
              (do
                (set! (. bear -image) (aget (. game -assets) "chara1.png")) ; スプライトに画像を割り当て
                (set! (. bear -x) 0)  
                (set! (. bear -y) 0) ; 座標の初期化
                (set! (. bear -frame) 5) ; スプライト画像のfps
                (.addChild game/rootScene bear) ;描画ツリーのルートにbearスプライトを描画させる
                (.addEventListener bear "enterframe" ; フレーム描画リスナー
                  (fn []
                    (set! (. bear -x) (+ 1 (. bear -x))) ; 右に走る
                    (set! (. bear -frame) (+ (rem (. bear -age) 2) 6)))) ; 6,7番の画像を繰り返す
                (.addEventListener bear "touchstart" ; タッチリスナー
                  (fn [] 
                    (.removeChild game/rootScene bear)))))))) ; bearスプライトを削除
        (.start game))))
