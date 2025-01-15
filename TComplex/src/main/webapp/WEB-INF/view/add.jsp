<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container px-5">
    <h1>Dang ky mat bang</h1>
    <c:if test="${message != null}">
        <div class="alert alert-danger" role="alert">
            <c:out value="${message}"/>
        </div>
    </c:if>
<form action="<c:url value="/add"/>" method="post">
    <div class="form-group">
        <label for="id-choice">Ma mat bang (*)</label>
        <input type="text" class="form-control" id="id-choice" name="id" placeholder="XXXX-XXX-XX">
    </div>
    <div class="form-group">
        <label for="area-choice">Dien tich (*)</label>
        <input type="text" class="form-control" id="area-choice" name="area" placeholder="">
    </div>
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
        <label for="description-choice">Mo ta chi tiet</label>
        <textarea class="form-control" name="description" id="description-choice" rows="3"></textarea>
    </div>
    <div class="form-group">
        <label for="price-choice">Gia cho thue (*)</label>
        <input type="text" class="form-control" name="price" id="price-choice" placeholder=""><span>VND</span>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="start-date-choice">Ngay bat dau</label>
            <input type="text" class="form-control" name="start_date" id="start-date-choice" placeholder="/ /">
        </div>
        <div class="form-group col-md-6">
            <label for="end-date-choice">Ngay ket thuc</label>
            <input type="text" class="form-control" name="end_date" id="end-date-choice" placeholder="/ /">
        </div>
    </div>
    <button type="submit" class="btn btn-primary mb-2">Luu</button>
    <button type="reset" class="btn btn-warning mb-2">Huy</button>
</form>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
