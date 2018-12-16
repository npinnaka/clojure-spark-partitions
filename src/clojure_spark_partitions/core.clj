(ns clojure-spark-partitions.core
  (:require [flambo.session :as session]
            [flambo.conf :as conf]
            [flambo.sql :as sql]
            [flambo.api :as api])
  (:import [org.apache.spark.sql.types DataTypes]
           [org.apache.spark.sql Column
            RowFactory
            SaveMode])
  (:gen-class))

(defn build-spark-session[app-name]
  (->
   (session/session-builder)
   (session/master "local")
   (session/get-or-create)))

(defn build-columns
  "prepare a column array"
  [& mycols]
  (into-array Column (map (fn [x] (Column. x)) mycols)))

(defn str-arry
  "prepare a string array"
  [& mycols]
  (into-array String mycols))

(defonce spark-session (build-spark-session "welcome"))

(defn read-json
  "read json file to Dataset"
  [file-name]
  (->
   spark-session
   (.read)
   (.json file-name)))

(defn write-paritions
  "write partitions by given columns"
  [data-set partition-columns file-name]
  (->
   data-set
   (.write)
   (.partitionBy (str-arry partition-columns))
   (.mode SaveMode/Overwrite)
   (.json file-name)))

(defn read-paritions
  "read only from given state partition"
  [file-name state]
  (->
   spark-session
   (.read)
   (.json file-name)
   (.filter (format "state='%s'" state))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "writing json data to partitions...")
  (->
   (read-json "resources/employee.json")
   (write-paritions "state" "out/employee-partition.json"))

  (println "reading from partitions ")
  (->
   (read-paritions "out/employee-partition.json" "IL")
   (.show)))
