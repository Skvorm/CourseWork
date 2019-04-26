;;
;; FILE:     homework05.rkt
;; AUTHOR:   Mark Skvor
;; DATE:     2/18/17
;;

#lang racket
(provide prefix-of? includes-course? max-length prefix->infix)

;; --------------------------------------------------------------------------
;; Problem 1                                           (structural recursion)
;; --------------------------------------------------------------------------

(define prefix-of?
  (lambda (lst1 lst2)
    (if (null? lst1)
     #f
      (if (null? lst2)
        #f
        (if (equal? (first lst1)(first lst2))
            #t
            (prefix-of? (rest lst1)(rest lst2))))))) 

;; --------------------------------------------------------------------------
;; Problem 2                                               (mutual recursion)
;; --------------------------------------------------------------------------        
(define includes-course?
  (lambda (course course-tree) 
    (if (null? course-tree)
         #f
        (includes-course-ce? course course-tree))))

(define includes-course-ce?
  (lambda (course course-tree)
    (if (symbol? (first course-tree))
        (if (eq? course (first course-tree))
            #t
            (includes-course? course (rest course-tree)))
         (includes-course? course (first course-tree)))))

        

;; --------------------------------------------------------------------------
;; Problem 3                                               (mutual recursion)
;; --------------------------------------------------------------------------

(define max-length
  (lambda (str-list) 
    (if (null? str-list)
        -1
        (max (max-length-se (first str-list)) (max-length-se (rest str-list))))))
(define max-length-se
  (lambda (str-list)
    (if(string? str-list)
        (string-length str-list)
        (max-length str-list))))

       

;; --------------------------------------------------------------------------
;; Problem 4                                               (mutual recursion)
;; --------------------------------------------------------------------------

(define prefix->infix
  (lambda (binary-exp)    
    (if (null? binary-exp)
        '()
        (numexp->infix  binary-exp))))
(define numexp->infix
  (lambda (binary-exp)
        (list (first(rest binary-exp))
        (first binary-exp)(first(rest (rest binary-exp))))
        ))
        
        

;; --------------------------------------------------------------------------
