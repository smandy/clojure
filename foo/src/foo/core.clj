(ns foo.core)

(defn square [x] [x (* x x ) ] )
(def  a (agent {} ))

(send-off a assoc "foo" "bar")
(send-off a assoc "goo" "gar")
(send-off a assoc "twat" "monkey")

(take 20 (repeat 10) )
(take 20 (cycle '[1 2 3]))

(defn foobar [x]   (println x))
(defn foobaz [x]   (println x)) 
(defn raporbaz [x] (println x))

(def lines (slurp "/home/andy/foo.txt"))
(def myLines 
  (let [ splitCsv #(seq (.split %1 ",") ) ]
    (map splitCsv ( .split lines "\n") )
    )
  )

(def myFun 
  (fn [x] [(reduce + (range 1 x)) 
           (reduce * (range 1 x) ) ] ) )

(def addOne #(+ %1 1 ) )

(def addOne (partial + 1 ))

(range 1 100 2 )

(def non-zero? (comp not zero?))

( ->> 
  (range)
  (take 30) 
  (filter #( non-zero? (mod %1 2 )) ) 
  (filter #( non-zero? (mod %1 3 )) ) 
  (filter #( non-zero? (mod %1 5 )) ) 
  (filter #( non-zero? (mod %1 7 )) ) 
  )

(def foo { :city { :burough { :name "vauxhall" }}})

(-> foo :city :burough :name )

(defn prune-zeros
  "Remove zeros from dictionary" 
  [ x ] (into {} (for [ [ q v ] (seq x) :when (non-zero? v) ] [q v] ) ) )

(defn prune-zeros
  "Remove zeros from dictionary" 
  [ x ] (into {} ( for [ [ q v ] x :when (non-zero? v) ] [q v] ) ) )


(def portOne { "VOD.L" 100
               "GLW.L" 500
               "BASFn.DE" 30
               "RR.L"  200 })

(def portTwo { "BASFn.DE" -100
               "GLW.L"    -500
               "RR.L"     -40 })

(def portThree { 
                "BASFn.DE" 101
                "AAPL.O" -100 
                } )

(defn square [x] ( * x x ) )

(square 3)

;(merge-with + portOne portTwo portThree)
(prune-zeros (merge-with + portOne portTwo portThree) )

(defn makeSeq 
  "Construct an arbitrary sequence for the pythagorean triples exmaple" 
  [] (range 1 100))

(letfn [ 
        (makeSeq [] (range 1 10) ) 
        (sq [x] ( * x x ))
        (isTriple [x y z] (= (+ (sq x) (sq y) ) (sq z)) )
        ]
  (for [ 
        x (makeSeq) 
        y (range x 20)
        z (range y 20)
        :when (isTriple x y z )
        ]  
    [x y z]))

(def a (agent {}))
