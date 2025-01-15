<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container px-5">

    <form action="<c:url value="/list"/>" method="post">
        <div class="form-group">
            <label for="status-choice">Trang thai (*)</label>
            <select class="form-control" name="status" id="status-choice">
                <option>Trong</option>
                <option>Ha tang</option>
                <option>Day du</option>
            </select>
        </div>
        <div class="form-group">
            <label for="floor-choice">Tang</label>
            <select class="form-control" name="floor" id="floor-choice">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
                <option>15</option>
            </select>
        </div>
        <div class="form-group">
            <label for="type-choice">Loai van phong (*)</label>
            <select class="form-control" name="type" id="type-choice">
                <option>Van phong chia se</option>
                <option>Van phong tron goi</option>
            </select>
        </div>
        <div class="form-group">
            <label for="price-choice">Gia cho thue (*)</label>
            <input type="text" class="form-control" name="price" id="price-choice" placeholder=""><span>VND</span>
        </div>
        <button type="submit" class="btn btn-primary mb-2">Tim kiem</button>
    </form>


    <h1>Danh sach mat bang</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Ma MB</th>
            <th>Dien tich</th>
            <th>Trang thai</th>
            <th>Tang</th>
            <th>Loai van phong</th>
            <th>Mo ta</th>
            <th>Gia cho thue</th>
            <th>Ngay bat dau</th>
            <th>Ngay ket thuc</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${apt_list}" var="apt">
            <tr>
                <th scope="row">${apt.id}</th>
                <td>${apt.area}</td>
                <td>${apt.status}</td>
                <td>${apt.floor}</td>
                <td>${apt.type}</td>
                <td>${apt.description}</td>
                <td>${apt.price}</td>
                <td>${apt.startDate}</td>
                <td>${apt.endDate}</td>
                <td><button id="del-${apt.id}" type="button" class="btn btn-danger">Xoa</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script>
    <c:forEach items="${apt_list}" var="apt">
        document.getElementById("del-${apt.id}").onclick = function (){
            if (confirm("Delete?")){
                window.location.href = '/del?id=${apt.id}';
            }
        }

    </c:forEach>
    </script>
    </body>
    </html>
