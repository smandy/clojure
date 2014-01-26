(ns foo.core)
(use '[clojure.string :only (split triml)])

(def foo (->> 
 (slurp "/home/andy/jabber.txt")
 ( #(split % #"\n") )
 ( mapcat #(split % #" ") )
 ( map #(.toLowerCase % ) )
 ( frequencies )
))

(def x (agent {} ))

(send-off x assoc :foo :bar )
(send-off x assoc :goo :boo )
(send-off x assoc :foo :bar )

(defn sub [x y] ( - x y ))
(defn add [x y] ( + x y ))tutu

(add 2 3)
(sub 2 

( ( comp * + ) 3 5 )

( (comp #( + % 10 ) #( * % 2 )) 200 )
( (comp #( + % 10 ) #( * % 2 )) 200 )

(defn wrap [x] (fn [y] (format ( format "%s(%%s)" x ) y ) ) )

( (comp #( format "f(%s)" %1 ) #( format "g(%s)" %1 ) ) "foo")

(defn return-pair [] [2 3] )

(defn sugar []
  ( let [ [first last] (return-pair) ]
    { :first first :last last } ) )

(sugar)
