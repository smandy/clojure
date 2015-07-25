(ns foo.core)
(use '[clojure.string :only (split triml)])

(def x (agent {} )
  
(def myAgent (agent 1))

(send-off x assoc :foo :bar )
(send-off x assoc :goo :boo )
(send-off x assoc :foo :bar )

(defn addToAgent [x n] ( + x n ) )

(dotimes [x 20] (send-off myAgent inc) )

(send-off myAgent mutate 5 )

(def myAtom (atom 0) )

(dosync (alter myAtom #( + %1 1 )))

(dotimes [ x 20 ] (swap! myAtom #( + %1 1 )) )


(defn square2 [x]
  """Square my arguments"""
  (* x x ))

(map square2  (range 1 10) )



