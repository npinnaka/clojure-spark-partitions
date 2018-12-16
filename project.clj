(defproject clojure-spark-partitions "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.logging "0.4.0"]
                 [org.clojure/data.json "0.2.6"]
                 [yieldbot/flambo "0.8.2"]
                 [org.apache.spark/spark-core_2.11 "2.4.0"]
                 [org.apache.spark/spark-sql_2.11 "2.4.0"]
                 [org.apache.spark/spark-hive_2.11 "2.4.0"]]
  :aot :all
  :main ^:skip-aot clojure-spark-partitions.core
  :profiles {:provided
             {:dependencies
              [[org.apache.spark/spark-core_2.11 "2.4.0"]]}})