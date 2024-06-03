package poly.datn.sd_41.common;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class CloudinaryUpload {

    private static String cloudName = "dig9ulo9l";
    private static String apiKey = "149343326483261";
    private static String apiSecret = "WeLoJlYj_oPDrkmXTwwfBM6JGYQ";

    private static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", cloudName,
            "api_key", apiKey,
            "api_secret", apiSecret
    ));

    public static String uploadFile(MultipartFile file) throws IOException {


        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("No file selected.");
        }
        try {
            //
            String uploadDir = "";
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                uploadDir="D:/imgdatn";
            } else {
                uploadDir="D:/img";
            }
            if (!new File(uploadDir).exists()) {
                new File(uploadDir).mkdirs(); // Tạo thư mục nếu nó không tồn tại
            }
            String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            String filePath = uploadDir + File.separator + fileName;
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(file.getBytes());
            }
            File file1 = new File(filePath);
            Map uploadResult = cloudinary.uploader().upload(file1, ObjectUtils.emptyMap());
            if (uploadResult.containsKey("error")) {
                // Xử lý lỗi tải lên
                throw new Exception(uploadResult.get("error").toString());
            }

            // Lấy URL công khai của tệp tải lên
            String imageUrl = uploadResult.get("secure_url").toString();

            // Tiếp tục xử lý hoặc lưu thông tin về tệp trong cơ sở dữ liệu

            return imageUrl;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error uploading file: " + e.getMessage());
        }
    }

    private static String getFileExtension(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        if (originalFileName != null) {
            int lastDotIndex = originalFileName.lastIndexOf(".");
            if (lastDotIndex != -1) {
                return originalFileName.substring(lastDotIndex + 1);
            }
        }
        return "";
    }
}
