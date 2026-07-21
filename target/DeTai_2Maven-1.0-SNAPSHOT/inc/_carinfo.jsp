<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
    body {
        background: #0a0a0a;
        color: #fff;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
    }

    .car-card {
        max-width: 900px;
        margin: auto;
        background: #111;
        border-radius: 12px;
        overflow: hidden;
        box-shadow: 0 0 20px rgba(255, 0, 0, 0.3);
    }

    .car-img {
        width: 100%;
        height: 400px;
        object-fit: contain;
    }

    .car-content {
        padding: 20px;
    }

    .car-title {
        font-size: 32px;
        font-weight: bold;
        color: #e10600;
        margin-bottom: 10px;
    }

    .car-price {
        font-size: 20px;
        margin-bottom: 20px;
        color: #ff4f4f;
    }

    .specs {
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        gap: 10px;
        margin-bottom: 20px;
    }

    .specs div {
        background: #1a1a1a;
        padding: 12px;
        border-radius: 8px;
    }
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

    .btn:hover {
        background: #ff2a2a;
    }

    /* Popup */
    .popup {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0,0,0,0.7);
        display: none;
        justify-content: center;
        align-items: center;
    }

    .popup-content {
        width: 500px;
        background: #111;
        padding: 25px;
        border-radius: 12px;
    }

    .close-btn {
        float: right;
        font-size: 20px;
        cursor: pointer;
    }
</style>



<c:if test="${car != null}">
    <div class="car-card" style="margin-top: 100px">
        <img src="img_car/${car.getImage()}" class="car-img">

        <div class="car-content">
            <div class="car-title">${car.getTen()}</div>
            <div class="car-price">Giá: ${car.getTen()}USD</div>

            <div class="specs">
                <div><b>Công suất:</b> ${car.getPower()}</div>
                <div><b>0–100 km/h:</b> ${car.getAcceleration()}</div>
                <div><b>Vận tốc tối đa:</b> ${car.getTopspeed()}</div>
                <div><b>Động cơ:</b> ${car.getEngine()}</div>
            </div>

            <p>
                ${car.getMota()}
            </p>

            <a class="btn" href="home" style="background: #9999ff">Back</a>
            <a class="btn" onclick="openPopup()">Xem thêm</a>
            <a class="btn" style="background: green" href="mycart">cart</a>
        </div>
    </div>

    <!-- POPUP -->
    <div class="popup" id="popup">
        <div class="popup-content">
            <span class="close-btn" onclick="closePopup()">&times;</span>
            <h2>Thông tin chi tiết</h2>
            <p>- Hãng: ${carname}</p>
            <p>- Mô hình: ${car.getTen()}</p>
            <p>- Mã lực: ${car.getPower()}</p>
            <p>- Dung tích: ${car.getDungTich()}</p>
            <p>- Truyền động: ${car.getTruyenDong()}</p>
            <p>- Công nghệ: ${car.getCongNghe()}</p>
            <p>- Trọng lượng: ${car.getTrongLuong()}</p>

        </div>

    </div>



    <script>
        function openPopup() {
            document.getElementById("popup").style.display = "flex";
        }
        function closePopup() {
            document.getElementById("popup").style.display = "none";
        }
    </script>
</c:if>