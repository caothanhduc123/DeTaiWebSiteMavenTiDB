package utils;

import data.model.car;
import java.util.ArrayList;

public class chatbot {

    // Tìm xe theo tên
    public car timXe(String query, ArrayList<car> list) {
        query = query.toLowerCase();
        for (car c : list) {
            String ten = c.getTen().toLowerCase();

            if (ten.contains(query) || query.contains(ten)) {
                return c;
            }
        }
        return null;
    }

    // Trả lời chi tiết một xe
    public String traLoiXe(car c) {
        if (c == null) {
            return "Mình không tìm thấy mẫu xe bạn cần, bạn thử nhập tên chính xác hơn nhé.";
        }

        return "🚗 *Thông tin chi tiết về " + c.getTen() + "*\n\n"
                + "• Kiểu dáng: " + c.getKieudang() + "\n"
                + "• Năm sản xuất: " + c.getNamsanxuat() + "\n"
                + "• Giá bán: $" + c.getGiaban() + "\n"
                + "• Nhiên liệu: " + c.getNhienlieu() + "\n"
                + "• Hộp số: " + c.getHopso() + "\n"
                + "• Công suất: " + c.getPower() + "\n"
                + "• Tăng tốc 0-100 km/h: " + c.getAcceleration() + "\n"
                + "• Tốc độ tối đa: " + c.getTopspeed() + "\n"
                + "• Động cơ: " + c.getEngine() + "\n"
                + "• Dung tích động cơ: " + c.getDungTich() + "\n"
                + "• Truyền động: " + c.getTruyenDong() + "\n"
                + "• Công nghệ: " + c.getCongNghe() + "\n"
                + "• Trọng lượng: " + c.getTrongLuong() + "\n\n"
                + "📌 Nhận xét: " + c.getMota();
    }

    // Gợi ý theo nhu cầu người dùng
    public String goiYTheoNhuCau(String nhuCau) {
        nhuCau = nhuCau.toLowerCase();

        if (nhuCau.contains("điện") || nhuCau.contains("electric")) {
            return "⚡ Gợi ý xe điện mạnh nhất:\n"
                    + "- Rimac Nevera (1914 hp)\n"
                    + "- Lotus Evija (2000 hp)\n"
                    + "- Rimac Concept Two";
        }

        if (nhuCau.contains("hybrid")) {
            return "🔋 Gợi ý xe Hybrid:\n"
                    + "- Lamborghini Revuelto\n"
                    + "- Ferrari 296 GTB\n"
                    + "- McLaren Artura\n"
                    + "- Mercedes-AMG One";
        }

        if (nhuCau.contains("nhanh") || nhuCau.contains("tốc")) {
            return "🚀 Top xe tăng tốc nhanh nhất:\n"
                    + "- Rimac Nevera — 1.85s\n"
                    + "- Rimac Concept Two — 1.85s\n"
                    + "- Koenigsegg Jesko — 1.9s";
        }

        if (nhuCau.contains("coupe")) {
            return "🎨 Các mẫu Coupe đẹp nhất:\n"
                    + "- Ferrari SF90\n"
                    + "- Lamborghini Huracan\n"
                    + "- Koenigsegg Jesko\n"
                    + "- Bugatti Chiron";
        }

        if (nhuCau.contains("roadster") || nhuCau.contains("mui trần")) {
            return "🌤 Gợi ý Roadster:\n"
                    + "- McLaren Elva\n"
                    + "- Ferrari Monza SP1/SP2\n"
                    + "- Pagani Huayra R (track)";
        }

        return "Bạn muốn tìm xe điện, hybrid, coupe, mui trần hay xe tăng tốc nhanh?";
    }

    // Xử lý input Chatbot
    public String xuLyChatbot(String input, ArrayList<car> list) {

        // 1. Tìm xe theo tên
        car c = timXe(input, list);
        if (c != null) {
            return traLoiXe(c);
        }

        // 2. Gợi ý theo nhu cầu
        String goiY = goiYTheoNhuCau(input);
        if (goiY != null) {
            return goiY;
        }

        // 3. Không hiểu — trả lời mặc định
        return "Mình có thể giúp bạn xem thông tin siêu xe, so sánh và tư vấn.\n"
                + "Bạn thử nhập: 'Revuelto', 'xe hybrid', 'siêu xe điện', 'coupe', 'tăng tốc nhanh', ...";
    }
}
