(ns refresh-materialized-view.core
  (:require [environ.core :refer [env]]
            [clj-postgresql.core :as pg]
            [clojure.java.jdbc :as j]))


(defn open-db-conn [spec]
  (pg/spec :host (:db-host spec)
           :user (:db-user spec)
           :dbname (:db-name spec)
           :password (:db-password spec)))

(defn close-db-conn [db]
  (pg/close! db))


(defn -main [& [port]]
  (let [connection (open-db-conn env)
        sql-stmt (str "REFRESH MATERIALIZED VIEW CONCURRENTLY " (env :db-materialized-view))]
    (println "start" sql-stmt)
    (j/execute! connection sql-stmt)
    (println "end" sql-stmt)
    (close-db-conn connection)))