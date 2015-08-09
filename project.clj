(defproject refresh-materialized-view "0.1.0-SNAPSHOT"
  :description "Clojure app that can refresh PG materialized view"
  :url "https://github.com/hashobject/refresh-materialized-view"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                  [environ "1.0.0"]
                  [org.clojure/java.jdbc "0.3.6"]
                  [clj-postgresql "0.6.0-SNAPSHOT"]]
:main refresh-materialized-view.core
:aot [refresh-materialized-view.core]
:jvm-opts ^:replace ["-server"])
