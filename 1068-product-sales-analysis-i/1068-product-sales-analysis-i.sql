# Write your MySQL query statement below
SELECT p.product_name, # cols needed in output
       s.year, 
       s.price
FROM Sales s # need to include all sales
LEFT JOIN Product p # add rows from product to sales
    ON s.product_id = p.product_id; # match rows with same product id