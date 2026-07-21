<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.API" %>
<style>
    body {
        background-color: #f8f9fa;
    }

    .filter-sidebar {
        background: white;
        border-radius: 12px;
        position: sticky;
        top: 20px;
        height: fit-content;
    }

    .product-card {
        background: white;
        border-radius: 12px;
        transition: all 0.3s ease;
        height: 100%;
    }

    .product-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 10px 20px rgba(0,0,0,0.1);
    }

    .product-image {
        height: 200px;
        object-fit: cover;
        border-radius: 12px 12px 0 0;
    }

    .price {
        color: #2563eb;
        font-weight: 600;
    }

    .discount-badge {
        position: absolute;
        top: 10px;
        right: 10px;
        background: #dc2626;
        color: white;
        padding: 4px 8px;
        border-radius: 6px;
        font-size: 0.875rem;
    }

    .wishlist-btn {
        position: absolute;
        top: 10px;
        left: 10px;
        background: white;
        border: none;
        width: 32px;
        height: 32px;
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
        transition: all 0.2s;
    }

    .wishlist-btn:hover {
        background: #fee2e2;
        color: #dc2626;
    }

    .rating-stars {
        color: #fbbf24;
    }

    .category-badge {
        background: #e5e7eb;
        color: #4b5563;
        padding: 4px 8px;
        border-radius: 6px;
        font-size: 0.75rem;
    }

    .filter-group {
        border-bottom: 1px solid #e5e7eb;
        padding-bottom: 1rem;
        margin-bottom: 1rem;
    }

    .color-option {
        width: 24px;
        height: 24px;
        border-radius: 50%;
        cursor: pointer;
        position: relative;
    }

    .color-option.selected::after {
        content: '';
        position: absolute;
        inset: -3px;
        border: 2px solid #2563eb;
        border-radius: 50%;
    }

    .sort-btn {
        background: white;
        border: 1px solid #e5e7eb;
        padding: 8px 16px;
        border-radius: 8px;
        transition: all 0.2s;
    }

    .sort-btn:hover {
        background: #f3f4f6;
    }

    .cart-btn {
        background: #2563eb;
        color: white;
        border: none;
        transition: all 0.2s;
    }

    .cart-btn:hover {
        background: #1d4ed8;
        transform: translateY(-2px);
    }
</style>
<h1>${id}</h1>
<h1>${ids}</h1>
<div class="container py-5" id="shop">
    <!-- Top Bar -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h4 class="mb-0">Product Collection</h4>
        <div class="container w-50">
            <form action="" method="post">
                <input type="text" placeholder="Tim Kiem Xe" name="findxe" class="w-75 border-dark rating-stars m-lg-2 h-auto col-10 filter-sidebar" style="padding: 10px; color: black" value="${findName_data}">
                <button type="submit"  style="padding: 10px" class="w-auto filter-sidebar" >Tim Kiem</button>
            </form>
        </div>
        <!--        <div class="d-flex gap-2 align-items-center">
                    <span class="text-muted">Sort by:</span>
                    <button class="sort-btn">
                        Newest <i class="bi bi-chevron-down ms-2"></i>
                        
                    </button>
                </div>-->
    </div>

    <div class="row g-4">
        <!-- Filters Sidebar -->
        <div class="col-lg-3">
            <form action="home" method="post">
                <div class="filter-sidebar p-4 shadow-sm">
                    <div class="filter-group">
                        <h6 class="mb-3">Categories</h6>
                        <!--                                            <div class="form-check mb-2">
                                                                        <input class="form-check-input" type="checkbox" id="electronics">
                                                                        <label class="form-check-label" for="electronics">
                                                                            Electronics
                                                                        </label>
                                                                    </div>
                                                                    <div class="form-check mb-2">
                                                                        <input class="form-check-input" type="checkbox" id="clothing">
                                                                        <label class="form-check-label" for="clothing">
                                                                            Clothing
                                                                        </label>
                                                                    </div>
                                                                    <div class="form-check mb-2">
                                                                        <input class="form-check-input" type="checkbox" id="accessories">
                                                                        <label class="form-check-label" for="accessories">
                                                                            Accessories
                                                                        </label>
                                                                    </div>-->
                        <c:forEach var="ic" items="${lcs}"  >
                            <div class="form-check mb-2">
                                <input class="form-check-input" type="radio" id="clothing" name="hangxe" value="${ic.getId()}">
                                <label class="form-check-label" for="clothing">
                                    ${ic.getHangxe()}
                                </label>
                            </div>
                        </c:forEach>
                    </div>

                    <div class="filter-group">
                        <h6 class="mb-3">Price Range</h6>

                        <input type="range" class="form-range" id="priceRange"
                               min="0" max="1000000000" value="500000000" step="1000000" name="price">

                        <div class="d-flex justify-content-between">
                            <span class="text-muted">$0</span>
                            <span id="rangeValue" class="text-muted">$500000000</span>
                        </div>
                    </div>
                    <button class="btn btn-outline-primary w-100" type="submit">Apply Filters</button>
                </div>
            </form>
        </div>

        <!-- Product Grid -->
        <div class="col-lg-9">

            <div class="row g-4">
                <!--                 Product Card 1 
                                <div class="col-md-4">
                                    <div class="product-card shadow-sm">
                                        <div class="position-relative">
                                            <img src="https://via.placeholder.com/300x200" class="product-image w-100" alt="Product">
                                            <span class="discount-badge">-20%</span>
                                            <button class="wishlist-btn">
                                                <i class="bi bi-heart"></i>
                                            </button>
                                        </div>
                                        <div class="p-3">
                                            <span class="category-badge mb-2 d-inline-block">Electronics</span>
                                            <h6 class="mb-1">Wireless Headphones</h6>
                                            <div class="rating-stars mb-2">
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-half"></i>
                                                <span class="text-muted ms-2">(4.5)</span>
                                            </div>
                                            <div class="d-flex justify-content-between align-items-center">
                                                <span class="price">$129.99</span>
                                                <button class="btn cart-btn">
                                                    <i class="bi bi-cart-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                
                                 Product Card 2 
                                <div class="col-md-4">
                                    <div class="product-card shadow-sm">
                                        <div class="position-relative">
                                            <img src="https://via.placeholder.com/300x200" class="product-image w-100" alt="Product">
                                            <button class="wishlist-btn">
                                                <i class="bi bi-heart"></i>
                                            </button>
                                        </div>
                                        <div class="p-3">
                                            <span class="category-badge mb-2 d-inline-block">Electronics</span>
                                            <h6 class="mb-1">Smart Watch Pro</h6>
                                            <div class="rating-stars mb-2">
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star"></i>
                                                <span class="text-muted ms-2">(4.0)</span>
                                            </div>
                                            <div class="d-flex justify-content-between align-items-center">
                                                <span class="price">$299.99</span>
                                                <button class="btn cart-btn">
                                                    <i class="bi bi-cart-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                
                                 Product Card 3 
                                <div class="col-md-4">
                                    <div class="product-card shadow-sm">
                                        <div class="position-relative">
                                            <img src="https://via.placeholder.com/300x200" class="product-image w-100" alt="Product">
                                            <span class="discount-badge">-15%</span>
                                            <button class="wishlist-btn">
                                                <i class="bi bi-heart"></i>
                                            </button>
                                        </div>
                                        <div class="p-3">
                                            <span class="category-badge mb-2 d-inline-block">Accessories</span>
                                            <h6 class="mb-1">Leather Wallet</h6>
                                            <div class="rating-stars mb-2">
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <i class="bi bi-star-fill"></i>
                                                <span class="text-muted ms-2">(5.0)</span>
                                            </div>
                                            <div class="d-flex justify-content-between align-items-center">
                                                <span class="price">$59.99</span>
                                                <button class="btn cart-btn">
                                                    <i class="bi bi-cart-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>-->


                <c:forEach var="c" items="${lc}">
                    <%--<c:forEach var="m" items="${mcs}">--%>
                        <%--<c:if test="${c.getId() != m.getId_car()}">--%>
                        <div class="col-md-4">
                            <div class="product-card shadow-sm">
                                <div class="position-relative">
                                    <img src="img_car/${c.getImage()}" class="product-image w-100" alt="Product">
                                    <!--<span class="discount-badge">-15%</span>-->
                                    <!--                                <button class="wishlist-btn">
                                                                        <i class="bi bi-heart"></i>
                                                                    </button>-->
                                </div>
                                <div class="p-3">
                                    <!--<span class="category-badge mb-2 d-inline-block">Accessories</span>-->
                                    <h6 class="mb-1">${c.getTen()}</h6>
                                    <div class="rating-stars mb-2">
                                        <i class="bi bi-star-fill"></i>
                                        <i class="bi bi-star-fill"></i>
                                        <i class="bi bi-star-fill"></i>
                                        <i class="bi bi-star-fill"></i>
                                        <i class="bi bi-star-fill"></i>
                                        <span class="text-muted ms-2">(5.0)</span>
                                    </div>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <!--<span class="price">$${c.getGiaban()}</span>-->
                                        <span class="price">${API.formatUSD(c.getGiaban())}</span>
                                        <a href="
                                           <c:if test="${user == null}">
                                               login-register
                                           </c:if>
                                           <c:if test="${user != null}">
                                               car_info?carId=${c.getId()}
                                           </c:if>">
                                            <button class="btn cart-btn" >
                                                <i class="bi bi-cart-plus"></i>
                                            </button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--</c:if>--%>

                    </c:forEach>



                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        const range = document.getElementById('priceRange');
        const output = document.getElementById('rangeValue');

        // Hi?n th? khi load trang
        output.textContent = "$" + range.value.toLocaleString();

        // Update khi kéo
        range.addEventListener('input', function () {
            output.textContent = "$" + parseInt(this.value).toLocaleString();
        });

    </script>