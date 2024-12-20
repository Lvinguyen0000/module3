use quanlysinhvien;

select Address, count(StudentID) from student group by Address;

select s.StudentID, s.StudentName, avg(m.Mark)
from student s 
inner join mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName;

select s.StudentID, s.StudentName, avg(m.Mark)
from student s 
inner join mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName
having avg(m.Mark) > 15;


-- Finding avg mark > 15 without HAVING
-- WITH StudentAverages AS (  
--     SELECT s.StudentID, s.StudentName, AVG(m.Mark) AS AvgMark  
--     FROM student s   
--     INNER JOIN mark m ON s.StudentID = m.StudentID  
--     GROUP BY s.StudentID, s.StudentName  
-- )  

-- SELECT StudentID, StudentName, AvgMark  
-- FROM StudentAverages  
-- WHERE AvgMark > 15;

select s.StudentID, s.StudentName, avg(m.Mark)
from student s 
inner join mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName
having avg(mark) >= all (select avg(mark) from Mark group by Mark.StudentID);




