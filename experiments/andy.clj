
(defn add [x] (fn [y] ( + x y )))

(def addOne ( add 1 ))

(addOne 2)

(defn sayHello [] ( println "Hello"))

(sayHello)

(defn myFunc [] ( 
                 let [ x { 
                          :source "10" 
                          :dest   "20"
                          } ] (println x ) ) )
