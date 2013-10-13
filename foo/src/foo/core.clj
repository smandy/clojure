(ns foo.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn square [x] [x (* x x ) ] )

(take 20 (repeat 10) )

(take 20 (cycle '(1 2 3)))

(defn foobar [x] (println x))

(defn foobaz [x] (println x)) 

(defn raporbaz [x] (println x))

; (spit "/home/andy/foo.txt" "bla\n")

(def lines (slurp "/home/andy/foo.txt"))

(def myLines 
  (let [ splitCsv #(seq (.split %1 ",") ) ]
    (map splitCsv ( .split lines "\n") )
    )
  )

(def myFun 
  (fn [x] [(reduce + (range 1 x)) 
           (reduce * (range 1 x) ) ] ) )

(def addOne #(+ %1 1 ))

(range 1 10 20)

; (defn nz [x] ( (comp not zero?) x ))

(def nz (comp not zero?))

(letfn [ (nz [x] ( (comp not zero?) x )) ]
  ( ->> 
    (range)
    (take 1000) 
    (filter #( nz (mod %1 2 )) ) 
    (filter #( nz (mod %1 4 )) ) 
    (filter #( nz (mod %1 6 )) ) 
    )
  )

(def foo { :city { :burough { :name "vauxhall" }}})

(-> foo :city :burough :name )

(defn prune-zeros
  "Remove zeros from dictionary" 
  [ x ] (into {} (for [ [ q v ] (seq x) :when (not (zero? v) ) ] [q v] ) ) )

(def portOne { "VOD.L" 100
               "GLW.L" 500
               "RR.L"  200 })

(def portTwo { "BASFn.DE" -100
               "GLW.L"    -500
               "RR.L"     -40 })

(def portThree { "AAPL.O" -100 })
               
(def port4 (prune-zeros (merge-with + portOne portTwo portThree) ))

(defn makeSeq 
  "Construct an arbitrary sequence for the pythagorean triples exmaple" 
  [] (range 1 100))

(letfn [ 
        (makeSeq [] (range 100) ) 
        (sq [x] ( * x x ))
        (isTriple [x y z ] (= (+ (sq x) (sq y) ) (sq z)) )
        ]
  (for [ 
        x (makeSeq) 
        y (makeSeq) 
        z (makeSeq) 
        :when (isTriple x y z )
        ]  
    [x y z] ))
