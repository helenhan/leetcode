/* Second Highest Salary
https://leetcode.com/problems/second-highest-salary/discuss/52957/Simple-query-which-handles-the-NULL-situation*/
select max(Salary) as SecondHighestSalary from Employee where Salary< (select max(Salary) from Employee)

/*The LIMIT clause can be used to constrain the number of rows returned by the SELECT statement. LIMIT takes one or two numeric arguments, which must both be nonnegative integer constants (except when using prepared statements).
With two arguments, the first argument specifies the offset of the first row to return, and the second specifies the maximum number of rows to return. The offset of the initial row is 0 (not 1).*/
/* Mysql uses limit and Oracle use ROWNUM
*/
/**
 Nth Highest Salary
 */
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M=N-1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct Salary from Employee  order by Salary desc limit M,1
  );
END

/* Department Top Three Salaries */
select d.Name AS Department, e1.Name As Employee,e1.Salary As Salary
from Employee e1
join Department d
on e1.DepartmentId = d.Id
where (select count(distinct (e2.Salary))  from Employee e2 where e2.salary>e1.salary and e2.DepartmentId=e1.DepartmentId) <3

/*Customers Who Never Order*/
select c.Name Customers
from Customers c
where c.Id not in (select o.CustomerId from  Orders o)


/* Friend Requests I: Overall Acceptance Rate
https://leetcode.com/problems/friend-requests-i-overall-acceptance-rate/discuss/103581/Easy-no-subquery-AC-solution*/
select ifnull((
    select round(count(distinct requester_id, accepter_id)/count(distinct sender_id,send_to_id),2)
    from   friend_request,request_accepted ),0) as accept_rate

/**
Friend Requests II: Who Has the Most Friends
https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/discuss/103812/Share-My-Accepted-SQL-Query-using-%22union-all%22-the-first-Accepted-answer-of-all
 */
 select id, count(*) num from
( select requester_id id from request_accepted
 union all
 select accepter_id id  from request_accepted
)tb
group by id order by num desc limit 1