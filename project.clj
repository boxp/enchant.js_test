(defproject enchant.js_test "1.0.0-SNAPSHOT"
  :description "hellobear by clojurescript"
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cljsbuild "0.3.0"]]
  :cljsbuild {
    :builds [{
      ;�\�[�X�R�[�h��z�u����p�X
      :source-paths ["src/enchant.js_test"]
      ;ClojureScript�R���p�C���̊�{�I�v�V����
      ;(ClojureScript�̃h�L�������g��ǂ����Ă�)
      :compiler {
        ;�W���ݒ�: target/cljsbuild-main.js
        :optimizations :whitespace
        :pretty-print true}}]})
