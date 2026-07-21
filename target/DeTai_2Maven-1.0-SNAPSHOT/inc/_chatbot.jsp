<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    .badge-wrap {
        white-space: normal !important; /* Cho phép xuống dòng */
        word-wrap: break-word;          /* Xuống dòng khi có từ dài */
        word-break: break-word;         /* Bất cứ chỗ nào dài quá */
        display: inline-block;          /* Vẫn giữ dạng badge */
        max-width: 250px;               /* Giới hạn chiều rộng (tùy bạn) */
    }

</style>
<div class="container py-4" style="margin-top: 100px">
    <div class="row justify-content-center">
        <div class="col-md-7 col-lg-5">

            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0">Chatbot</h5>
                </div>

                <div class="card-body" style="height:350px; overflow-y:auto;">

                    <!-- Nếu chưa có tin nhắn -->
                    <c:if test="${empty messages}">
                        <p class="text-muted">Chưa có tin nhắn nào...</p>
                    </c:if>

                    <!-- Lặp tin nhắn -->
                    <c:forEach var="msg" items="${messages}">
                        <div class="mb-2">
                            <!-- Người gửi -->
                            <c:if test="${msg.from == 'user'}">
                                <div class="text-end">
                                    <span class="badge bg-primary" style="color: black">${msg.text}</span>
                                </div>
                            </c:if>

                            <!-- Bot -->
                            <c:if test="${msg.from == 'bot'}">
                                <div class="text-start" >
                                    <span class="badge bg-secondary badge-wrap" style="color: black">${msg.text}</span>
                                </div>
                            </c:if>

                        </div>
                    </c:forEach>
                </div>

                <!-- Form gửi -->
                <div class="card-footer">
                    <form action="chatbot" method="post" class="input-group">
                        <input name="message" class="form-control" placeholder="Nhập tin nhắn..." required>
                        <button class="btn btn-primary">Gửi</button>
                    </form>
                </div>

            </div>

        </div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {

        const input = document.querySelector("input[name='message']");
        const form = input.closest("form");

        /* --- Enter = gửi --- */
        input.addEventListener("keydown", function (e) {
            if (e.key === "Enter") {
                e.preventDefault();
                form.submit();
            }
        });

        /* --- Tự động focus vào ô nhập tin --- */
        input.focus();

        /* --- Auto scroll xuống cuối --- */
        const box = document.getElementById("chatBox");
        if (box) {
            box.scrollTop = box.scrollHeight;
        }
    }
    );
</script>


