# Write your MySQL query statement below
Select 
    a.sell_date, Count(distinct(a.product)) as num_sold,
    GROUP_CONCAT(DISTINCT a.product order by a.product) as products
From 
    Activities a
GROUP BY 
    sell_date
ORDER BY
    sell_date;