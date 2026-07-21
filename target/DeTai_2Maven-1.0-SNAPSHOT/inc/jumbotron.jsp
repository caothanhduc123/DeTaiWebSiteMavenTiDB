<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Carousel Start -->
<div class="container-fluid carousel-header vh-100 px-0">
    <div id="carouselId" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#carouselId" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#carouselId" data-bs-slide-to="1"></li>
            <li data-bs-target="#carouselId" data-bs-slide-to="2"></li>
            <li data-bs-target="#carouselId" data-bs-slide-to="3"></li>
            <li data-bs-target="#carouselId" data-bs-slide-to="4"></li>
            <li data-bs-target="#carouselId" data-bs-slide-to="5"></li>

        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                <img src="img_car/ferrari_296gtb.jpg" class="img-fluid" alt="Image">
                <div class="carousel-caption">
                    <div class="p-3" style="max-width: 900px;">
                        <h4 class="text-white text-uppercase fw-bold mb-4" style="letter-spacing: 3px;">Tuyệt Tác Động Cơ Hoàng Gia</h4>
                        <h1 class="display-1 text-capitalize text-white mb-4">Ferrari 296 GTB</h1>
                        <p class="mb-5 fs-5">Ferrari 296 GTB hybrid, V6 + điện, 830 mã lực, tăng tốc 0-100 km/h trong 2,9 giây. 
                        </p>
                        <div class="d-flex align-items-center justify-content-center">
                            <a class="btn-hover-bg btn btn-primary text-white py-3 px-5" href="home#shop">Mua xe</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img_car/bugatti_chiron.jpg" class="img-fluid" alt="Image">
                <div class="carousel-caption">
                    <div class="p-3" style="max-width: 900px;">
                        <h4 class="text-white text-uppercase fw-bold mb-4" style="letter-spacing: 3px;">Cỗ Máy Tốc Độ Tối Thượng</h4>
                        <h1 class="display-1 text-capitalize text-white mb-4">Bugatti Chiron Pur Sport</h1>
                        <p class="mb-5 fs-5">Bugatti Chiron, W16 1500 mã lực, tốc độ tối đa >420 km/h, hypercar hiếm.
                        </p>
                        <div class="d-flex align-items-center justify-content-center">
                            <a class="btn-hover-bg btn btn-primary text-white py-3 px-5" href="home#shop">Mua xe</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img_car/aston_dbs_zagato.jpg" class="img-fluid" alt="Image">
                <div class="carousel-caption">
                    <div class="p-3" style="max-width: 900px;">
                        <h4 class="text-white text-uppercase fw-bold mb-4" style="letter-spacing: 3px;">Khi Tốc Độ Trở Thành Nghệ Thuật</h4>
                        <h1 class="display-1 text-capitalize text-white mb-4">Aston Martin DBS GT Zagato</h1>
                        <p class="mb-5 fs-5">Aston Martin DBS Zagato, V12 715 mã lực, sang trọng và độc quyền.</p>
                        <div class="d-flex align-items-center justify-content-center">
                            <a class="btn-hover-bg btn btn-primary text-white py-3 px-5" href="home#shop">Mua xe</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img_car/bugatti_bolide.jpg" class="img-fluid" alt="Image">
                <div class="carousel-caption">
                    <div class="p-3" style="max-width: 900px;">
                        <h4 class="text-white text-uppercase fw-bold mb-4" style="letter-spacing: 3px;">Biểu Tượng Của Sự Hoàn Mỹ</h4>
                        <h1 class="display-1 text-capitalize text-white mb-4">Bugatti Bolide</h1>
                        <p class="mb-5 fs-5">Bugatti Bolide, phiên bản track, W16 1825 mã lực, siêu nhẹ.</p>
                        <div class="d-flex align-items-center justify-content-center">
                            <a class="btn-hover-bg btn btn-primary text-white py-3 px-5" href="home#shop">Mua xe</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img_car/aston_valkyrie.jpg" class="img-fluid" alt="Image">
                <div class="carousel-caption">
                    <div class="p-3" style="max-width: 900px;">
                        <h4 class="text-white text-uppercase fw-bold mb-4" style="letter-spacing: 3px;">Đỉnh Cao Thiết Kế & Công Nghệ</h4>
                        <h1 class="display-1 text-capitalize text-white mb-4">Aston Martin Valkyrie</h1>
                        <p class="mb-5 fs-5">Aston Martin Valkyrie, hypercar V12 1160 mã lực, khí động học cao.</p>
                        <div class="d-flex align-items-center justify-content-center">
                            <a class="btn-hover-bg btn btn-primary text-white py-3 px-5" href="home#shop">Mua xe</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img_car/aston_valhalla.jpg" class="img-fluid" alt="Image">
                <div class="carousel-caption">
                    <div class="p-3" style="max-width: 900px;">
                        <h4 class="text-white text-uppercase fw-bold mb-4" style="letter-spacing: 3px;">Sang Trọng Ẩn Trong Từng Đường Nét</h4>
                        <h1 class="display-1 text-capitalize text-white mb-4">Aston Martin Valhalla</h1>
                        <p class="mb-5 fs-5">Aston Martin Valhalla, hybrid V6 + điện, 950 mã lực, công nghệ tiên tiến.</p>
                        <div class="d-flex align-items-center justify-content-center">
                            <a class="btn-hover-bg btn btn-primary text-white py-3 px-5" href="home#shop">Mua xe</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<!-- Carousel End -->