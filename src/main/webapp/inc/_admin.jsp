<%-- 
    Document   : _admin
    Created on : 13 thg 12, 2025, 03:19:56
    Author     : parrot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="utils.API" %>
<%@page import="data.dao.Database" %>
<style>

    .svg-icon>svg {
        width: 1.45rem;
        height: 1.45rem;
    }
</style>
<div class="container-fluid">
    <div class="row" >

        <!-- Sidebar -->
        <nav class="col-md-1 d-none d-md-block bg-light sidebar"  >
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item mb-2"><a class="nav-link active" href="#">Dashboard</a></li>
                    <li class="nav-item mb-2"><a class="nav-link" href="admin#users">Users</a></li>
                    <li class="nav-item mb-2"><a class="nav-link" href="#cars">Cars</a></li>
                    <li class="nav-item mb-2"><a class="nav-link" href="#" onclick="location.href = 'logout'">logout</a></li>
                </ul>
            </div>
        </nav>

        <!-- Main Content -->
        <main class="col-md-11 col-lg-10 px-md-4 ms-1" >
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light mb-4">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Admin Panel</a>
                </div>
            </nav>

            <!-- Dashboard Cards -->
            <div class="row mb-4">
                <div class="col-md-3">
                    <div class="card text-white bg-primary mb-3">
                        <div class="card-body">
                            <h5 class="card-title">Total Cars</h5>
                            <p class="card-text">${adlc.size()}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card text-white bg-success mb-3">
                        <div class="card-body">
                            <h5 class="card-title">Total Users</h5>
                            <p class="card-text">${adlus.size()}</p>
                        </div>
                    </div>
                </div>
            </div>



            <h1>Invoice</h1>
            <table class="table table-bordered table-hover align-middle">
                <thead class="table-dark text-center">
                    <tr>
                        <th>ID</th>
                        <th>Họ tên</th>
                        <th>Số điện thoại</th>
                        <th>Email</th>
                        <!--<th>Địa chỉ</th>-->
                        <!--<th>CCCD</th>-->
                        <!--<th>Ngày sinh</th>-->
                        <th>Ngày tạo</th>
                        <th>ID Xe</th>
                        <th>Trang Thai</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${users}">
                        <c:forEach var="u1" items="${donghang}">
                            <c:forEach var="m" items="${mycart}">
                                <c:if test="${u1.getId_user() == u.getId() && m.isTrangthai() && m.getId_user() == u.getId() && m.getId_car() == u1.getId_car()}">
                                    <c:set var="car" value="${Database.getCar().find(u1.getId_car())}"/>
                                    <tr>
                                        <!--<form action="" method="post">-->
                                        <td>${u.getId()}</td>
                                        <td>${u.getName()}</td>
                                        <td>${u.getPhone()}</td>
                                        <td>${u.getEmail()}</td>                            
                                        <td>${u1.getNgay_mua()}</td>          
                                        <td>${car.getTen()}</td>     
                                        <td>${u1.getTrangthai().equals('0') ? 'Đang xử lý' : 'Hoan Thanh'}</td>     
                                        <td>
                                            <c:if test="${u1.getTrangthai().equals('0')}">
                                                <div class="row mb-0 justify-content-center">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="id_donhang" value="${u1.getId()}">
                                                        <button class="btn btn-secondary col-md-3  " type="submit" name="action" value="xacnhan_donhang" style="margin-right:50px;" >Xac nhan</button>
                                                        <button class="btn btn-danger col-md-3  " type="submit" name="action" value="huybo_donhang">Huy bo</button>
                                                    </form>
                                                </div>
                                            </c:if>
                                            <c:if test="${!u1.getTrangthai().equals('0')}">
                                                <!-- Nút kích hoạt -->
                                                <button  class="btn btn-success w-50" onclick="openInvoiceModal(
                                                                '${u1.getId()}',
                                                                '${u.getName()}',
                                                                '${u1.getNgay_mua()}',
                                                                '${car.getGiaban()}',
                                                                '${u.getEmail()}'
                                                                )">
                                                    Xem Hóa đơn 

                                                </button>
                                                <!--                                                <button type="button" class="btn btn-success w-50" data-bs-toggle="modal" data-bs-target="#invoiceModal">
                                                                                                    Xem Hóa đơn 
                                                
                                                                                                </button>-->


                                            </c:if>
                                        </td>     
                                        <!--</form>-->
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>


                </tbody>

            </table>



            <!-- Cars Table -->
            <h3 id="cars">Cars List</h3>
            <button class="btn btn-success mb-3" data-bs-toggle="modal" data-bs-target="#addModal">
                Thêm sản phẩm
            </button>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Brand</th>
                        <th>Year</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Style</th>
                        <th>Transmission</th>
                        <th>Fuel</th>
                        <th>Description</th>
                        <th>Power</th>
                        <th>Acceleration</th>
                        <th>Top Speed</th>
                        <th>Engine</th>
                        <th>Displacement</th>
                        <th>Drive</th>
                        <th>Tech</th>
                        <th>Weight</th>
                        <th>Hành động</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ic" items="${adlc}">
                        <tr>
                            <td>${ic.getId()}</td>
                            <td>${ic.getTen()}</td>
                            <td>${ic.getId_loaixe()}</td> <!-- Nếu muốn hiển thị tên hãng thì map từ list hãng -->
                            <td>${ic.getNamsanxuat()}</td>
                            <td>$${ic.getGiaban()}</td>
                            <td><img src="img_car/${ic.getImage()}" alt="${ic.getTen()}" width="80"/></td>
                            <td>${ic.getKieudang()}</td>
                            <td>${ic.getHopso()}</td>
                            <td>${ic.getNhienlieu()}</td>
                            <td>${ic.getMota()}</td>
                            <td>${ic.getPower()}</td>
                            <td>${ic.getAcceleration()}</td>
                            <td>${ic.getTopspeed()}</td>
                            <td>${ic.getEngine()}</td>
                            <td>${ic.getDungTich()}</td>
                            <td>${ic.getTruyenDong()}</td>
                            <td>${ic.getCongNghe()}</td>
                            <td>${ic.getTrongLuong()}</td>
                            <td>
                                <button class="btn btn-sm btn-warning"
                                        onclick="openEditModal(
                                                        '${ic.getId()}',
                                                        '${ic.getTen()}',
                                                        '${ic.getId_loaixe()}',
                                                        '${ic.getNamsanxuat()}',
                                                        '${ic.getGiaban()}',
                                                        '${ic.getImage()}',
                                                        '${ic.getKieudang()}',
                                                        '${ic.getHopso()}',
                                                        '${ic.getNhienlieu()}',
                                                        '${ic.getMota()}',
                                                        '${ic.getPower()}',
                                                        '${ic.getAcceleration()}',
                                                        '${ic.getTopspeed()}',
                                                        '${ic.getEngine()}',
                                                        '${ic.getDungTich()}',
                                                        '${ic.getTruyenDong()}',
                                                        '${ic.getCongNghe()}',
                                                        '${ic.getTrongLuong()}'
                                                        )">
                                    ✏️ Sửa
                                </button>

                                <button class="btn btn-sm btn-danger"
                                        onclick="openDeleteModal('${ic.getId()}')">
                                    🗑 Xóa
                                </button>
                            </td>

                        </tr>
                    <div class="modal fade" id="editModal" tabindex="-1">
                        <div class="modal-dialog modal-lg modal-dialog-scrollable">
                            <div class="modal-content">

                                <form action="" method="post" >
                                    <input type="hidden" name="action" value="update">
                                    <input type="hidden" name="id" id="edit-id">

                                    <div class="modal-header bg-warning">
                                        <h5 class="modal-title">Sửa xe</h5>
                                        <button class="btn-close" data-bs-dismiss="modal"></button>
                                    </div>

                                    <div class="modal-body row g-3">

                                        <div class="col-md-6">
                                            <label>Tên xe</label>
                                            <input class="form-control" name="ten" id="edit-ten">
                                        </div>

                                        <div class="col-md-6">
                                            <label>Hãng</label>
                                            <input class="form-control" name="id_loaixe" id="edit-id_loaixe">
                                        </div>

                                        <div class="col-md-4">
                                            <label>Năm SX</label>
                                            <input class="form-control" name="namsanxuat" id="edit-namsanxuat">
                                        </div>

                                        <div class="col-md-4">
                                            <label>Giá bán</label>
                                            <input class="form-control" name="giaban" id="edit-giaban">
                                        </div>

                                        <div class="col-md-4">
                                            <label>Kiểu dáng</label>
                                            <input class="form-control" name="kieudang" id="edit-kieudang">
                                        </div>

                                        <div class="col-12">
                                            <label>Mô tả</label>
                                            <textarea class="form-control" name="mota" id="edit-mota"></textarea>
                                        </div>

                                    </div>

                                    <div class="modal-footer">
                                        <button class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                                        <button class="btn btn-warning">Cập nhật</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="deleteModal" tabindex="-1">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">

                                <form action="" method="post"  >
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="id" id="delete-id">

                                    <div class="modal-header bg-danger text-white">
                                        <h5 class="modal-title">Xác nhận xóa</h5>
                                        <button class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
                                    </div>

                                    <div class="modal-body">
                                        Bạn có chắc chắn muốn xóa xe này không?
                                    </div>

                                    <div class="modal-footer">
                                        <button class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                                        <button class="btn btn-danger">Xóa</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>

                </c:forEach>
                </tbody>
            </table>
            <!-- Users -->
            <section id="users" class="mt-5">
                <h3>Người dùng</h3>
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Quyền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="i" items="${adlus}">
                            <tr>
                                <td>${i.getId()}</td>
                                <td>${i.getName()}</td>
                                <td>${i.getPhone()}</td>
                                <td>${i.getId()}</td>
                                <td>${i.getRole()}</td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>

            <!-- Stats -->
        </main>
    </div>
</div>
<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="admin" method="post" >
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Thêm xe mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label>Tên xe</label>
                        <input type="text" class="form-control" name="ten" required>
                    </div>
                    <div class="mb-3">
                        <label>Brand ID</label>
                        <input type="number" class="form-control" name="id_loaixe" required>
                    </div>
                    <div class="mb-3">
                        <label>Năm sản xuất</label>
                        <input type="number" class="form-control" name="namsanxuat" required>
                    </div>
                    <div class="mb-3">
                        <label>Giá bán</label>
                        <input type="number" class="form-control" name="giaban" required>
                    </div>
                    <div class="mb-3">
                        <label>Ảnh</label>
                        <input type="text" class="form-control" name="image" required>
                    </div>
                    <div class="mb-3">
                        <label>Kiểu dáng</label>
                        <input type="text" class="form-control" name="kieudang">
                    </div>
                    <div class="mb-3">
                        <label>Hộp số</label>
                        <input type="text" class="form-control" name="hopso">
                    </div>
                    <div class="mb-3">
                        <label>Nhiên liệu</label>
                        <input type="text" class="form-control" name="nhienlieu">
                    </div>
                    <div class="mb-3">
                        <label>Mô tả</label>
                        <textarea class="form-control" name="mota"></textarea>
                    </div>
                    <div class="mb-3">
                        <label>Power</label>
                        <input type="text" class="form-control" name="power">
                    </div>
                    <div class="mb-3">
                        <label>Acceleration</label>
                        <input type="text" class="form-control" name="acceleration">
                    </div>
                    <div class="mb-3">
                        <label>Top Speed</label>
                        <input type="text" class="form-control" name="topspeed">
                    </div>
                    <div class="mb-3">
                        <label>Engine</label>
                        <input type="text" class="form-control" name="engine">
                    </div>
                    <div class="mb-3">
                        <label>Displacement</label>
                        <input type="text" class="form-control" name="DungTich">
                    </div>
                    <div class="mb-3">
                        <label>Transmission</label>
                        <input type="text" class="form-control" name="TruyenDong">
                    </div>
                    <div class="mb-3">
                        <label>Technology</label>
                        <input type="text" class="form-control" name="CongNghe">
                    </div>
                    <div class="mb-3">
                        <label>Weight</label>
                        <input type="text" class="form-control" name="TrongLuong">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" name="action" value="add_cart" class="btn btn-primary">Thêm sản phẩm</button>
                </div>
            </form>
        </div>
    </div>

</div>

<script>




    function fillDeleteModal(id, ten) {
        document.getElementById('delete-id').value = id;
        document.getElementById('delete-name').innerText = ten;
    }
</script>
<script>
    function openEditModal(id, ten, id_loaixe, namsanxuat, giaban, image, kieudang, hopso, nhienlieu, mota, power, acceleration, topspeed, engine, DungTich, TruyenDong, CongNghe, TrongLuong) {
        document.getElementById('edit-id').value = id;
        document.getElementById('edit-ten').value = ten;
        document.getElementById('edit-id_loaixe').value = id_loaixe;
        document.getElementById('edit-namsanxuat').value = namsanxuat;
        document.getElementById('edit-giaban').value = giaban;
        document.getElementById('edit-image-preview').src = "img_car/" + image; // thêm <img id="edit-image-preview"> trong modal
        document.getElementById('edit-kieudang').value = kieudang;
        document.getElementById('edit-hopso').value = hopso;
        document.getElementById('edit-nhienlieu').value = nhienlieu;
        document.getElementById('edit-mota').value = mota;
        document.getElementById('edit-power').value = power;
        document.getElementById('edit-acceleration').value = acceleration;
        document.getElementById('edit-topspeed').value = topspeed;
        document.getElementById('edit-engine').value = engine;
        document.getElementById('edit-DungTich').value = DungTich;
        document.getElementById('edit-TruyenDong').value = TruyenDong;
        document.getElementById('edit-CongNghe').value = CongNghe;
        document.getElementById('edit-TrongLuong').value = TrongLuong;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function openEditModal(
            id, ten, id_loaixe, namsanxuat, giaban, image,
            kieudang, hopso, nhienlieu, mota,
            power, acceleration, topspeed, engine,
            dungtich, truyendong, congnhe, trongluong
            ) {
        document.getElementById("edit-id").value = id;
        document.getElementById("edit-ten").value = ten;
        document.getElementById("edit-id_loaixe").value = id_loaixe;
        document.getElementById("edit-namsanxuat").value = namsanxuat;
        document.getElementById("edit-giaban").value = giaban;
        document.getElementById("edit-kieudang").value = kieudang;
        document.getElementById("edit-mota").value = mota;

        new bootstrap.Modal(document.getElementById("editModal")).show();
    }

    function openDeleteModal(id) {
        document.getElementById("delete-id").value = id;
        new bootstrap.Modal(document.getElementById("deleteModal")).show();
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Modal Structure -->
<div class="modal fade" id="invoiceModal" tabindex="-1" >
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="invoiceModalLabel">Chi tiết Hóa đơn #<span class="hd-id"></span></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container mt-6 mb-7">
                    <div class="row justify-content-center">
                        <div class="col-lg-12 col-xl-7">
                            <div class="card">
                                <div class="card-body p-5">
                                    <h2>
                                        Hey <span class="xem-name_user"></span>,
                                    </h2>
                                    <p class="fs-sm">
                                        This is the receipt for a payment of <strong><span class="xem-gia"></span></strong> (USD) you made to Spacial Themes.
                                    </p>

                                    <div class="border-top border-gray-200 pt-4 mt-4">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="text-muted mb-2">Payment No.</div>
                                                <strong>#<span class="hd-id"></span></strong>
                                            </div>
                                            <div class="col-md-6 text-md-end">
                                                <div class="text-muted mb-2">Payment Date</div>
                                                <strong><span class="xem-ngaymua"></span></strong>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="border-top border-gray-200 mt-4 py-4">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="text-muted mb-2">Client</div>
                                                <strong>
                                                    <span class="xem-name_user"></span>
                                                </strong>
                                                <p class="fs-sm">
                                                    Dia diem nhan
                                                    <br>
                                                    <a href="#!" class="text-purple"><span id="xem-email"></span>
                                                    </a>
                                                </p>
                                            </div>
                                            <div class="col-md-6 text-md-end">
                                                <div class="text-muted mb-2">Payment To</div>
                                                <strong>
                                                    Cao Thanh Duc
                                                </strong>
                                                <p class="fs-sm">
                                                    Thanh Pho Hue
                                                    <br>
                                                    <a href="#!" class="text-purple">admin@supercar.com
                                                    </a>
                                                </p>
                                            </div>
                                        </div>
                                    </div>

                                    <table class="table border-bottom border-gray-200 mt-3">
                                        <thead>
                                            <tr>
                                                <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Description</th>
                                                <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Amount</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td class="px-0">Theme customization</td>
                                                <td class="text-end px-0">$<span id="xem-gia1"></span></td>
                                            </tr>
                                            <tr>
                                                <td class="px-0">Gia cong them</td>
                                                <td class="text-end px-0">$1000,00</td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <div class="mt-5">
                                        <div class="d-flex justify-content-end">
                                            <p class="text-muted me-3">Subtotal:</p>
                                            <span>$<span id="xem-gia-10000"> </span> </span>
                                        </div>
                                        <div class="d-flex justify-content-end">
                                            <p class="text-muted me-3">Discount:</p>
                                            <span>-$100.00 (giam gia)</span>
                                        </div>
                                        <div class="d-flex justify-content-end mt-3">
                                            <h5 class="me-3">Total:</h5>
                                            <h5 class="text-success">$<span id="xem-gia-10000-100"> </span></h5>
                                        </div>
                                    </div>
                                </div>
                                <a href="#!" class="btn btn-dark btn-lg card-footer-btn justify-content-center text-uppercase-bold-sm hover-lift-light">
                                    <span class="svg-icon text-white me-2">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512"><title>ionicons-v5-g</title><path d="M336,208V113a80,80,0,0,0-160,0v95" style="fill:none;stroke:#000;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"></path><rect x="96" y="208" width="320" height="272" rx="48" ry="48" style="fill:none;stroke:#000;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"></rect></svg>
                                    </span>
                                    Pay Now
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <script src="https://cdn.jsdelivr.net/npm/html2canvas@1.4.1/dist/html2canvas.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/jspdf@2.5.1/dist/jspdf.umd.min.js"></script>
                <button type="button"
                        class="btn btn-success"
                        onclick="downloadInvoicePdf()">
                    Tải về PDF
                </button>
                <script>
                    async function downloadInvoicePdf() {

                        const invoice = document.getElementById("invoiceModal");

                        if (!invoice) {
                            alert("Không tìm thấy nội dung hóa đơn");
                            return;
                        }

                        // chụp DOM thành ảnh
                        const canvas = await html2canvas(invoice, {
                            scale: 2,
                            useCORS: true
                        });

                        const imgData = canvas.toDataURL("image/png");

                        const {jsPDF} = window.jspdf;

                        const pdf = new jsPDF("p", "mm", "a4");

                        const pdfWidth = 210;
                        const pdfHeight = (canvas.height * pdfWidth) / canvas.width;

                        pdf.addImage(imgData, "PNG", 0, 0, pdfWidth, pdfHeight);

                        // lấy mã hóa đơn đặt tên file
                        const id = document.querySelector(".hd-id")?.innerText || "invoice";

                        pdf.save("hoa_don_" + id + ".pdf");
                    }
                </script>

                <!--<button type="button" class="btn btn-success">Tải về PDF</button>-->
            </div>
        </div>
    </div>
</div>
<script>
    function openInvoiceModal(id_hd, name_user, ngaymua, gia, email) {

        gia = Number(gia); // ÉP KIỂU RẤT QUAN TRỌNG

        document.querySelectorAll(".hd-id")
                .forEach(e => e.innerText = id_hd);

        document.querySelectorAll(".xem-name_user")
                .forEach(e => e.innerText = name_user);

        document.querySelectorAll(".xem-ngaymua")
                .forEach(e => e.innerText = ngaymua);

        document.querySelectorAll(".xem-gia")
                .forEach(e => e.innerText = gia.toLocaleString());

        document.getElementById("xem-gia1").innerText = gia.toLocaleString();
        document.getElementById("xem-gia-10000").innerText =
                (gia + 10000).toLocaleString();
        document.getElementById("xem-gia-10000-100").innerText =
                (gia + 10000 - 100).toLocaleString();

        document.getElementById("xem-email").innerText = email;

        new bootstrap.Modal(
                document.getElementById("invoiceModal")
                ).show();
    }
</script>



