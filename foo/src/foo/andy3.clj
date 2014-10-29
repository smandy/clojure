(ns foo.andy3)

(defn addOne [x y z] ( + x y z ) )

(addOne 1 2 3)

(conj '(1 2 3) 10 20 )

;(conj #(1 2 3) 10)

(def x #{1 2 3} )

(if (x 20) (println "Woot") (println "Bogus") )

(case 
    (+ 30 2 )
  20 ( + 3 2 )
  15 ( * 3 5 )
  32 ( + 1 1 )
)

