<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container mt-5" style="margin-top: 100px">
    <h2 class="mb-4 text-center">Chuyển khoản ngân hàng</h2>



    <form action="" method="post" class="mx-auto" style="max-width:500px;">
        <div class="mb-3">
            <label for="fromAccount" class="form-label">Tài khoản gửi</label>
            <input type="text" class="form-control" id="fromAccount" name="fromAccount" required>
        </div>
        <div class="mb-3">
            <label for="toAccount" class="form-label">Tài khoản nhận</label>
            <input type="text" class="form-control" id="toAccount" name="toAccount" required>
        </div>
        <div class="mb-3">
            <label for="amount" class="form-label">Số tiền</label>
            <input type="number" class="form-control" id="amount" name="amount" required min="1" step="0.01">
        </div>
        <button type="submit" class="btn btn-primary w-100">Chuyển khoản</button>
    </form>
</div>