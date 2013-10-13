(ns foo.core)
(use '[clojure.string :only (split triml)])

(defn sub [x y] ( - x y ))
(defn add [x y] ( + x y ))

(add 2 3)
(sub 2 3)

(->> 
 (slurp "/home/andy/jabber.txt")
 ( #(split % #"\n") )
 ( mapcat #(split % #" ") )
 ( map #(.toLowerCase % ) )
 ( frequencies )
)

(defn return-pair [] [2 3] )

(defn sugar []
  ( let [ [first last] (return-pair) ]
    { :first first :last last } ) )

(sugar)

(def x (agent {} ))

(send-off x assoc :foo :bar)
(send-off x assoc :goo :boo)
(send-off x assoc :foo :bar)


