(ns bollocks.core)

(defn doit [] 
  (map #(format "yo %s" %1) '( 1 2 3 )) 
  )

(defn both [ f1 f2 ] 
  (fn [x] 
    (and (f1 x) (f2 x))
    )
  )

(conjh


(defn between [lhs rhs] 
  (every-pred 
   #( < lhs %1) 
   #( < %1 rhs) )
)



