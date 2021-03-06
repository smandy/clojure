(ns foo.core)
(use '[clojure.string :only (split triml)])

(def foo (->> 
 ( slurp "/home/andy/jabber.txt")
 ( #(split % #"\n") )
 ( mapcat #(split % #" ") )
 ( map #(.toLowerCase % ) ) 
 ( frequencies )
))

(def x (agent {} ))
(send-off x assoc :foo :bar )
(send-off x assoc :goo :boo )
(send-off x assoc :sue :bar )

(defn sub [x y] ( - x y ))
(defn add "Add some shit - duh" [x y] ( + x y ))

(add 2 3)

( (comp * +) 3 5 )
( (comp #( + % 10 ) #( * % 2 )) 200 )
( (comp #( + % 10 ) #( * % 2 )) 200 )

(defn wrap [x] (fn [y] (format ( format "%s(%%s)" x ) y ) ) )

(defn make-fmt [c]
  #( format "%s(%s)" c %1 )
  )

( (comp (make-fmt "f")
        (make-fmt "g") ) "foo")

(defn return-pair [] [2 3] )

(defn sugar []
  ( let [ [first last] (return-pair) ]
    { :first first :last last } ) )


