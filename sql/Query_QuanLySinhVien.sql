use quanlysinhvien;

select StudentName, Address, Phone, Status 
from student where StudentName like 'h%';

select ClassName, StartDate 
from class
where month(StartDate) = 12;

select SubName, Credit
from subject where Credit between 3 and 5;

update student
set ClassID = 2
where StudentName = "Hung";

SELECT s.StudentName, sub.SubName, m.Mark  
FROM mark m  
inner join Student s ON m.StudentID = s.StudentID  
inner join subject sub ON m.SubID = sub.SubID  
ORDER BY m.Mark DESC, s.StudentName ASC;  