use quanlysinhvien;

select SubID, SubName, Credit, Status from subject
group by SubID, SubName, Status
having Credit >= all (select Credit from subject group by SubID);

select s.SubID, s.SubName, m.Mark
from subject s 
inner join mark m on s.SubID = m.SubID
group by s.SubID
having m.Mark >= all(select Mark from mark);

select s.StudentID, s.StudentName, avg(m.Mark)
from student s
inner join mark m on s.StudentID = m.StudentID
group by s.StudentID
order by avg(m.Mark) desc;