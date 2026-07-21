<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    .btn {
        display: inline-block;
        margin-top: 10px;
        background: #e10600;
        padding: 10px 20px;
        color: #fff;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.2s;
        text-decoration: none;
        margin: 0px 95px;
    }
</style>
<div class="container my-4" style="max-width: 700px;">
    <div class="card shadow-sm p-4" style="margin-top: 100px">

        <h3 class="mb-4">🧾 Thông tin người mua xe</h3>

        <div class="mb-2">
            <strong>Họ và tên:</strong> ${khachhang.getHoten()}
        </div>

        <div class="mb-2">
            <strong>Số điện thoại:</strong> ${khachhang.getSodienthoai()}
        </div>

        <div class="mb-2">
            <strong>Email:</strong> ${khachhang.getEmail()}
        </div>

        <div class="mb-2">
            <strong>Địa chỉ:</strong> ${khachhang.getDiachi()}
        </div>

        <div class="mb-2">
            <strong>CCCD:</strong> ${khachhang.getCccd()}
        </div>

        <div class="mb-2">
            <strong>Ngày sinh:</strong> ${khachhang.getNgaysinh()}
        </div>
        <div class="mb-2">
            <strong>Ngày  bans</strong> ${khachhang.getNgay_tao()}
        </div>

        <hr>

        <h4 class="mt-3 mb-3">🚗 Xe đã mua</h4>

        <div class="border rounded p-3">
            <strong>${xe.getTen()}</strong><br>
            Giá: ${xe.getGiaban()} $ <br>
            Số lượng: 1
        </div>
        <a class="btn" style="background: green; margin-top: 5px" href="infohoadon?xe=${xe.getId()}&khachhang=${khachhang.getId()}">xem hoa don</a>

    </div>
</div>
