<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 15px rgba(0,0,0,0.2);
        width: 400px;
    }

    .form-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .form-group {
        margin-bottom: 15px;
    }

    .form-group label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

    .form-group input {
        width: 100%;
        padding: 8px 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    .form-group input[type="date"] {
        padding: 6px 10px;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }

    .error {
        color: red;
        font-size: 13px;
        margin-top: 5px;
    }
</style>
<h1>${xe}</h1>
<h1>${khachhang}</h1>
<div class="form-container" style="margin-top: 100px">
    <h2>Thông tin khách hàng</h2>
    <form id="" method="post">
        <div class="form-group">
            <label for="hoten">Họ và tên</label>
            <input type="text" id="hoten" name="hoten" required>
            <div class="error" id="errorHoten"></div>
        </div>

        <div class="form-group">
            <label for="sodienthoai">Số điện thoại</label>
            <input type="tel" id="sodienthoai" name="sodienthoai" required>
            <div class="error" id="errorSDT"></div>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
            <div class="error" id="errorEmail"></div>
        </div>

        <div class="form-group">
            <label for="diachi">Địa chỉ</label>
            <input type="text" id="diachi" name="diachi" required>
            <div class="error" id="errorDiachi"></div>
        </div>

        <div class="form-group">
            <label for="cccd">CCCD/CMND</label>
            <input type="text" id="cccd" name="cccd" required>
            <div class="error" id="errorCCCD"></div>
        </div>

        <div class="form-group">
            <label for="ngaysinh">Ngày sinh</label>
            <input type="date" id="ngaysinh" name="ngaysinh" required>
            <div class="error" id="errorNS"></div>
        </div>

        <div class="form-group">
            <label for="ngaytao">Ngày tạo</label>
            <input type="date" id="ngaytao" name="ngaytao" required>
            <div class="error" id="errorNT"></div>
        </div>

        <button type="submit">Gửi thông tin</button>
    </form>
</div>

<script>
    const form = document.getElementById('khachhangForm');

    form.addEventListener('submit', function (event) {
        event.preventDefault();

        // Xóa lỗi cũ
        document.querySelectorAll('.error').forEach(e => e.textContent = '');

        let valid = true;

        // Kiểm tra Họ và tên
   

        // Kiểm tra SDT
       

        // Kiểm tra Email
       

        // Kiểm tra CCCD
      

        // Ngày sinh và ngày tạo
       

        if (valid) {
            alert('Thông tin đã được gửi thành công!');
            form.reset();
        }
    });
</script>

