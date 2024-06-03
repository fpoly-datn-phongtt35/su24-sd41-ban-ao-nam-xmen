package poly.datn.sd_41.common;

import poly.datn.sd_41.entity.HoaDon;

public class Template {
    public static String hoaDonMoi(HoaDon hoaDon) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html lang=\"en\">");
        html.append("<head>");
        html.append("<meta charset=\"UTF-8\">");
        html.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        html.append("<title>Order Details</title>");
        html.append("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
        html.append("</head>");
        html.append("<body>");
        html.append("<div class=\"container mt-5\">");
        html.append("<h2>Hóa đơn " + hoaDon.getMaHoaDon() + "</h2>");

        // Customer Information
        html.append("<div class=\"mb-4\">");
        html.append("<h4>Thông tin khách hàng</h4>");
        html.append("<p><strong>Name:</strong> " + hoaDon.getNguoiMua().getHo() + " " + hoaDon.getNguoiMua().getTen() + "</p>");
        //    html.append("<p><strong>Phone:</strong> " + hoaDon.getDiaChiGiao() != null ? hoaDon.getDiaChiGiao().getSoDienThoai() : "Không có" + "</p>");
        //    html.append("<p><strong>Email:</strong> " + hoaDon.getDiaChiGiao() != null ? hoaDon.getDiaChiGiao().getNguoiDung().getEmail() : "Không có" + "</p>");
        //    html.append("<p><strong>Address:</strong> " + hoaDon.getDiaChiGiao() != null ? hoaDon.getDiaChiGiao().getXa() + " " + hoaDon.getDiaChiGiao().getHuyen() + " " + hoaDon.getDiaChiGiao().getTinh() : "Không có" + "</p>");
        html.append("</div>");

        // Product Information
        html.append("<h4>Thông tin sản phẩm</h4>");
        html.append("<table class=\"table table-bordered\">");
        html.append("<thead>");
        html.append("<tr>");
        html.append("<th>Mã SP</th>");
        html.append("<th>Hình ảnh</th>");
        html.append("<th>Tên sản phẩm</th>");
        html.append("<th>Màu sắc</th>");
        html.append("<th>Kích thước</th>");
        html.append("<th>Số lượng</th>");
        html.append("</tr>");
        html.append("</thead>");
        html.append("<tbody>");

        // Product rows
        for (var item : hoaDon.getHoaDonChiTietList()) {
            html.append("<tr>");
            html.append("<td>" + item.getSanPhamChiTiet().getMaSanPham() + "</td>");
            html.append("<td><img style=\"height: 120px;width: auto;\" src=\"" + item.getSanPhamChiTiet().getHinhAnh() + "\"></td>");
            html.append("<td>" + item.getSanPhamChiTiet().getTenSanPham() + "</td>");
            html.append("<td>" + item.getSanPhamChiTiet().getMauSac().getTenMau() + "</td>");
            html.append("<td>" + item.getSanPhamChiTiet().getKichThuoc().getTenKichThuoc() + "</td>");
            html.append("<td>" + item.getSoLuong() + "</td>");
            html.append("</tr>");
        }

        // Close HTML tags
        html.append("</tbody>");
        html.append("</table>");
        html.append("</div>");
        html.append("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>");
        html.append("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\"></script>");
        html.append("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        html.append("</body>");
        html.append("</html>");
        return html.toString();
    }

    public static String baoCaoHTML() {
        StringBuilder html = new StringBuilder();

        // HTML head
        html.append("<!DOCTYPE html>");
        html.append("<html>");
        html.append("<head>");
        html.append("<title>Sample HTML Page</title>");
        html.append("</head>");

        // HTML body
        html.append("<body>");
        html.append("<h1>Hello, World!</h1>");
        html.append("<p>This is a sample HTML page generated by Java.</p>");
        html.append("</body>");

        html.append("</html>");

        return html.toString();
    }
}
