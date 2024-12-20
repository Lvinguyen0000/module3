use quanlysinhvien;

select * from student;

select * 
from student
where status = true;

select *
from subject
where credit < 10;

select s.StudentID, s.StudentName, c.ClassName
from student s
inner join class c on s.ClassID = c.ClassID
where c.ClassName = "A1";

SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S inner join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';