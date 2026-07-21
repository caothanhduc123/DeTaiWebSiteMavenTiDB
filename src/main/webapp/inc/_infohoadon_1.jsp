<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>${xe}</h1>
<h1>${khachhang}</h1>
<div class="container py-5" style="max-width: 800px;">

    <div class="card shadow p-4" style="margin-top: 100px">

        <h2 class="text-center mb-4">🚗 HÓA ĐƠN MUA BÁN XE Ô TÔ</h2>

        <!-- Thông tin showroom -->
        <div class="mb-4">
            <strong>Showroom:</strong> SuperCar brands Việt Nam <br>
            <strong>Địa chỉ:</strong> Hue <br>
            <strong>Hotline:</strong> 00906362598
        </div>

        <hr>

        <!-- Thông tin khách -->
        <h4 class="mb-3">👤 Thông tin người mua</h4>
        <p><strong>Họ tên:</strong> ${khachhang.getHoten()}</p>
        <p><strong>SĐT:</strong> ${khachhang.getSodienthoai()}</p>
        <p><strong>Email:</strong> ${khachhang.getEmail()}</p>
        <p><strong>Địa chỉ:</strong> ${khachhang.getDiachi()}</p>
        <p><strong>CCCD:</strong> ${khachhang.getCccd()}</p>

        <hr>

        <!-- Thông tin xe -->
        <h4 class="mb-3">🚘 Thông tin xe</h4>
        <p><strong>Tên xe:</strong> ${xe.getTen()}</p>
        <p><strong>Năm sản xuất:</strong> 2025</p>
        <p><strong>Mã lực:</strong> 986 hp</p>
        <p><strong>Động cơ:</strong> Hybrid V8</p>

        <table class="table table-bordered mt-3">
            <thead class="table-secondary">
                <tr>
                    <th>Hạng mục</th>
                    <th class="text-end">Giá (VND)</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="total" value="0" />
                <tr>
                    <td>Giá xe</td>
                    <td class="text-end">${xe.getGiaban()} $</td>
                </tr>
                <tr>
                    <td>Phí trước bạ</td>
                    <td class="text-end">10,50</td>
                    
                </tr>
                <tr>
                    <td>Biển số</td>
                    <td class="text-end">200,0</td>
                </tr>
                <tr>
                    <td>Bảo hiểm vật chất</td>
                    <td class="text-end">450</td>
                </tr>
            </tbody>
            <tfoot class="table-light">
                <tr>
                    <th>Tổng cộng</th>
                    <th class="text-end text-danger">${xe.getGiaban() + 11 + 200 + 450} $</th>
                </tr>
            </tfoot>
        </table>

        <div class="mt-4">
            <strong>Ngày lập hóa đơn:</strong> 05/12/2025 <br>
            <strong>Nhân viên bán hàng:</strong> Cao Thanh Duc
        </div>

        <div class="text-center mt-4">
            <button class="btn btn-primary px-4">In hóa đơn</button>
            <button class="btn btn-success px-4 ms-2">Xuất PDF</button>
        </div>

    </div>

</div>