<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="utils.API" %>
<%@page import="data.dao.Database" %>

<div class="container py-5" style="margin-top:100px">
    <h2 class="mb-4 text-center">🛒 Giỏ hàng của bạn</h2>

    <!-- HOME & CLEAR -->
    <div class="d-flex justify-content-between mb-3">
        <button class="btn btn-outline-secondary"
                onclick="location.href = 'home#shop'">
            Home
        </button>

        <form method="post">
            <button class="btn btn-outline-danger"
                    name="acction" value="dels">
                Clear
            </button>
        </form>
    </div>

    <div class="row">

        <!-- LEFT -->
        <div class="col-lg-8">

            <c:set var="sum" value="0"/>

            <c:forEach var="c" items="${lc}">
                <c:forEach var="m" items="${lm}">
                    <c:if test="${c.id == m.id_car}">

                        <div class="card mb-3 shadow-sm">
                            <div class="row g-0">

                                <div class="col-md-4">
                                    <img src="img_car/${c.image}"
                                         class="img-fluid rounded-start">
                                </div>

                                <div class="col-md-8">
                                    <div class="card-body">

                                        <h5>${c.ten}</h5>
                                        <p>
                                            <strong>Giá:
                                                ${API.formatUSD(c.giaban)}
                                            </strong>
                                        </p>

                                        <c:if test="${!m.trangthai}">
                                            <c:set var="sum"
                                                   value="${sum + c.giaban}"/>
                                        </c:if>

                                        <div class="d-flex gap-2">

                                            <!-- ĐÃ THANH TOÁN -->
                                            <c:if test="${m.trangthai}">
                                              <c:set var="donhang" value="${Database.getdonhang().finddonhang(u.getId(), c.getId())}"/> <button class="btn btn-success w-50" onclick="openInvoiceModal( '${donhang.getId()}', '${u.getName()}', '${donhang.getNgay_mua()}', '${c.getGiaban()}', '${u.getEmail()}' )"> Da Thanh toan </button> 
                                            </c:if>

                                            <!-- CHƯA THANH TOÁN -->
                                            <c:if test="${!m.trangthai}">
                                                <form method="post">
                                                    <input type="hidden"
                                                           name="dcar"
                                                           value="${m.id}">
                                                    <button class="btn btn-danger"
                                                            name="acction"
                                                            value="del">
                                                        Xóa
                                                    </button>
                                                </form>
                                            </c:if>

                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </c:if>
                </c:forEach>
            </c:forEach>

        </div>

        <!-- RIGHT -->
        <div class="col-lg-4">
            <div class="card p-4 shadow-sm sticky-top"
                 style="top:100px">

                <h4>Tổng đơn hàng</h4>

                <div class="d-flex justify-content-between">
                    <span>Tạm tính:</span>
                    <span>${API.formatUSD(sum)}</span>
                </div>

                <div class="d-flex justify-content-between">
                    <span>Phí giao xe:</span>
                    <span>$1,000</span>
                </div>

                <hr>

                <c:set var="sum" value="${sum + 1000}"/>

                <div class="d-flex justify-content-between">
                    <strong>Tổng cộng:</strong>
                    <strong class="text-success">
                        ${API.formatUSD(sum)}
                    </strong>
                </div>

                <c:if test="${sum > 0}">
                    <button class="btn btn-success w-100 mt-3"
                            data-bs-toggle="modal"
                            data-bs-target="#thanhtoanModal">
                        Thanh toán
                    </button>
                </c:if>

            </div>
        </div>

    </div>
</div>

<!-- ================= MODAL THANH TOÁN ================= -->
<!-- Modal Thanh Toán -->
<div class="modal fade" id="thanhtoanModal" tabindex="-1" aria-labelledby="thanhtoanModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <!-- Header -->
            <div class="modal-header bg-success text-white">
                <h5 class="modal-title" id="thanhtoanModalLabel">Thanh toán bằng QR</h5>
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
            </div>

            <!-- Body -->
            <div class="modal-body text-center">

                <p class="mb-3">Vui lòng quét mã QR bên dưới để hoàn tất thanh toán.</p>

                <!-- QR chuyển khoản -->
                <div class="border p-3 rounded shadow-sm bg-light mb-3">
                    <img src="https://www.imgonline.com.ua/examples/qr-code-blue.png" alt="QR Chuyển khoản" class="img-fluid" style="max-width: 220px;">
                </div>

                <!-- Thông tin chuyển khoản -->
                <div class="text-start mb-3">
                    <div class="d-flex justify-content-between">
                        <strong>Tổng tiền:</strong>
                        <strong class="text-success">${API.formatUSD(sum)}</strong>
                    </div>

                    <div class="mt-2">
                        <strong>Nội dung CK:</strong>
                        <span class="text-primary fw-bold">PAY-${user.getId()}</span>
                    </div>

                    <div>
                        <strong>Ngân hàng:</strong> Viettinbank  
                    </div>

                    <div>
                        <strong>Số tài khoản:</strong> CAOTHANHDUC  
                    </div>

                    <div>
                        <strong>Chủ tài khoản:</strong> Cao Thanh Duc
                    </div>
                </div>

                <p class="text-muted fs-6">
                    Sau khi chuyển khoản hoàn tất, vui lòng nhấn nút xác nhận bên dưới.
                </p>
            </div>

            <!-- Footer -->
            <div class="modal-footer">

                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>

                <!-- Link xác nhận đã chuyển khoản -->
<!--                <a href="thanhtoanthuc?id_user=${user.getId()}" class="btn btn-success">
                    Đã chuyển khoản
                </a>-->
                <a href="thanhtoanthuc" class="btn btn-success">
                    Đã chuyển khoản
                </a>

            </div>

        </div>
    </div>
</div>

<!-- ================= MODAL HÓA ĐƠN ================= -->
<div class="modal fade" id="invoiceModal">
    <div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">

            <div class="modal-header">
                <h5>Hóa đơn #<span class="hd-id"></span></h5>
                <button class="btn-close"
                        data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                <div id="invoiceContent">

                    <p>Khách hàng:
                        <strong class="xem-name_user"></strong>
                    </p>

                    <p>Email:
                        <span id="xem-email"></span>
                    </p>

                    <p>Ngày mua:
                        <span class="xem-ngaymua"></span>
                    </p>

                    <hr>

                    <p>
                        Giá xe:
                        $<span id="xem-gia1"></span>
                    </p>

                    <p>
                        Phí giao xe:
                        $1,000
                    </p>

                    <h5 class="text-success">
                        Tổng:
                        $<span id="xem-total"></span>
                    </h5>

                </div>
            </div>

            <div class="modal-footer">
                <button class="btn btn-success"
                        onclick="downloadInvoicePdf()">
                    Tải PDF
                </button>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/html2canvas@1.4.1/dist/html2canvas.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jspdf@2.5.1/dist/jspdf.umd.min.js"></script>

<script>
                            function openInvoiceModal(id, name, date, price, email) {

                                price = Number(price);

                                document.querySelector(".hd-id").innerText = id;
                                document.querySelector(".xem-name_user").innerText = name;
                                document.querySelector(".xem-ngaymua").innerText = date;
                                document.getElementById("xem-email").innerText = email;
                                document.getElementById("xem-gia1").innerText = price.toLocaleString();
                                document.getElementById("xem-total").innerText =
                                        (price + 1000).toLocaleString();

                                new bootstrap.Modal(
                                        document.getElementById("invoiceModal")
                                        ).show();
                            }

                            async function downloadInvoicePdf() {
                                const el = document.getElementById("invoiceContent");
                                const canvas = await html2canvas(el, {scale: 2});
                                const img = canvas.toDataURL("image/png");

                                const {jsPDF} = window.jspdf;
                                const pdf = new jsPDF();
                                pdf.addImage(img, "PNG", 10, 10, 190, 0);
                                pdf.save("hoa_don.pdf");
                            }
</script>
