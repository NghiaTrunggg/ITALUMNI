CREATE DATABASE  IF NOT EXISTS `alumni` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `alumni`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: alumni
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `binhluan`
--

DROP TABLE IF EXISTS `binhluan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `binhluan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `noidung` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `tintuc_id` int DEFAULT NULL,
  `nguoidung_id` int DEFAULT NULL,
  `ngay` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tintuc_binhluan_idx` (`tintuc_id`),
  KEY `fk_nguoidung_binhluan_idx` (`nguoidung_id`),
  CONSTRAINT `fk_nguoidung_binhluan` FOREIGN KEY (`nguoidung_id`) REFERENCES `nguoidung` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binhluan`
--

LOCK TABLES `binhluan` WRITE;
/*!40000 ALTER TABLE `binhluan` DISABLE KEYS */;
INSERT INTO `binhluan` VALUES (3,'Nhanh tay nộp hồ sơ thôi nào !',31,3,'2023-10-27 23:41:29'),(5,'Vui quá',31,7,'2023-10-27 23:47:36'),(8,'Chương trình thật ý nghĩa',NULL,7,'2023-10-28 00:04:26'),(9,'Quá hay',NULL,7,'2023-10-28 00:19:43'),(10,'Thật tuyệt vời',NULL,7,'2023-10-28 00:48:31'),(11,'trung ngu',NULL,4,'2023-10-28 01:05:35'),(12,'trung ngu123',NULL,4,'2023-10-28 01:14:15'),(13,'trung ngu123',NULL,4,'2023-10-28 01:15:04'),(14,'trung ngu123',NULL,4,'2023-10-28 01:15:11');
/*!40000 ALTER TABLE `binhluan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhmuctintuc`
--

DROP TABLE IF EXISTS `danhmuctintuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhmuctintuc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuctintuc`
--

LOCK TABLES `danhmuctintuc` WRITE;
/*!40000 ALTER TABLE `danhmuctintuc` DISABLE KEYS */;
INSERT INTO `danhmuctintuc` VALUES (1,'THÔNG BÁO'),(2,'HOẠT ĐỘNG CỰU SINH VIÊN'),(3,'GƯƠNG MẶT TIÊU BIỂU'),(4,'VIỆC LÀM');
/*!40000 ALTER TABLE `danhmuctintuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(50) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `ten` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `tendn` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `matkhau` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `nienkhoa` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `phanquyen` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `hinhdaidien` varchar(200) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES (3,'Nghia','Trung','nghiatrung','$2a$10$rotTh/FI9Ix5ITRVYHsgA.YhyM9ptHMK.KJe2nFuB8Y048Nly8TP6',NULL,'ROLE_USER',NULL,NULL),(4,'Nguyen','Trung','admin','$2a$10$w0Uo7fJj0ngTIg90vkIEhOG4h8cggf4gyu.a//2F7vj9VozbmjYhK',NULL,'ROLE_ADMIN',NULL,NULL),(5,'Tang','Tai','hoangtai','$2a$10$sQaLrfyt8N51LuOpOPeFAuWbBOUniZVMPHhT5H7QdVm4gmb9yW8Ty',NULL,'ROLE_USER',NULL,'https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698212323/bk5cc1p3j0zpwqr4mxi0.jpg'),(7,'Trần','Lan','honglan','$2a$10$rVIpntMvtLUhVi4/qFMM8.hHT/jvxqMzupWqNlqpHPi93z8vqzNvK','2018','ROLE_USER',NULL,'https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698327914/l3jwjgmy83rbfezjhich.jpg');
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tintuc`
--

DROP TABLE IF EXISTS `tintuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tintuc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` text COLLATE utf8mb3_unicode_ci NOT NULL,
  `tomtat` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  `noidung` text COLLATE utf8mb3_unicode_ci,
  `hinhanh` varchar(200) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `danhmuctintuc_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_news_category_idx` (`danhmuctintuc_id`),
  CONSTRAINT `fk_tintuc_danhmuctintuc` FOREIGN KEY (`danhmuctintuc_id`) REFERENCES `danhmuctintuc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tintuc`
--

LOCK TABLES `tintuc` WRITE;
/*!40000 ALTER TABLE `tintuc` DISABLE KEYS */;
INSERT INTO `tintuc` VALUES (2,'VÒNG SƠ LOẠI HỘI DIỄN VĂN NGHỆ CỰU SINH VIÊN CẤP TRƯỜNG','Chiều ngày 28/5/2023, tại Hội trường 602 cơ sở Võ Văn Tần','Chiều ngày 28/5/2023, tại Hội trường 602 cơ sở Võ Văn Tần đã diễn ra Vòng sơ loại Hội diễn Văn nghệ Cựu sinh viên cấp Trường mang tên 10√e. Vòng sơ loại đã thu hút được sự quan tâm của nhiều Thầy/Cô và các anh/chị cựu sinh viên.\r\n\r\nHội diễn có sự góp mặt của các vị Ban giám khảo đồng thời cũng là các Huấn luyện viên có kinh nghiệm trong lĩnh vực nghệ thuật, là người đảm nhiệm vai trò “cầm cân nảy mực”:\r\n\r\nCa sĩ Siu Y Kao, Ca sĩ Minh Thảo, Ca sĩ Thùy Trang – Nhã Uyên, Ca sĩ Phan Ngọc Luân.\r\nBiên đạo Linh Lê, Biên đạo múa Tuyết Vân, Biên đạo Toàn Moon, Biên đạo XanTo Nguyễn.\r\nMC Khánh Ly.\r\nVòng sơ loại diễn ra với 84 tiết mục ở 3 hạng mục Nhóm nhảy, Đơn ca và Người dẫn chương trình. Các thí sinh sẽ tranh tài và thuyết phục Ban giám khảo lựa chọn vào đội.','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698082855/qdex0vft1a4jp1ycshoq.jpg',2),(6,'SINH VIÊN KHOA CÔNG NGHỆ THÔNG TIN THAM QUAN CÔNG TY LOGIGEAR VIỆT NAM','Chiều ngày 31/03/2023, sinh viên khoa Công nghệ Thông tin','Chiều ngày 31/03/2023, sinh viên khoa Công nghệ Thông tin (CNTT) đã có buổi tham quan đến công ty LogiGear Việt Nam tại 462 Phan Xích Long, phường 2, Quận Phú Nhuận, Thành phố Hồ Chí Minh. Đây là dịp để sinh viên khoa Công nghệ Thông tin đã có cơ hội được tìm hiểu và trải nghiệm công nghệ phần mềm hiện đại tại một trong những công ty hàng đầu về lĩnh vực kiểm thử phần mềm tại Việt Nam.\r\nTại buổi tham quan, Sinh viên được hướng dẫn bởi các chuyên gia có kinh nghiệm trong lĩnh vực kiểm thử phần mềm. Các chuyên gia đã giới thiệu về các sản phẩm và dịch vụ của công ty cũng như các phương pháp và công nghệ kiểm thử phần mềm mới nhất. Bên canh đó các bạn cũng có cơ hội được tham quan các phòng làm việc và trải nghiệm thực tế các công cụ kiểm thử phần mềm.','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698082301/hry4rwg6bmdqyaahqbiu.jpg',2),(8,'CHƯƠNG TRÌNH TẬP HUẤN MỘT SỐ KỸ NĂNG AN TOÀN VÀ BẢO MẬT THÔNG TIN','Chiều ngày 01/06/2023, Trường Đại học Mở Tp. Hồ Chí Minh','Chiều ngày 01/06/2023, Trường Đại học Mở Tp. Hồ Chí Minh tổ chức Chương trình tập huấn một số kỹ năng an toàn và bảo mật thông tin dành cho cán bộ, viên chức nhà trường tại Mũi Né, Tp. Phan Thiết, tỉnh Bình Thuận. Đến dự buổi tập huấn có GS.TS. Nguyễn Minh Hà – Hiệu trưởng nhà trường, TS. Lê Nguyễn Quốc Khang và toàn thể cán bộ, viên chức, người lao động nhà trường.\r\nTại buổi tập huấn, hơn 300 cán bộ viên chức, người lao động đã được truyền đạt các kỹ năng về nhận thức an ninh mạng; Bên cạnh đó, đội quản trị hệ thống được trang bị thêm những kiến thức cần thiết. Ngoài ra, cán bộ viên chức – người lao động cũng có cơ hội biết thêm thông tin về quy trình tấn công dựa trên ma trận ATT và CK (các chiến thuật, kỹ thuật phá hoại và các hiểu biết thông thường), và các trường hợp lừa đảo, dẫn dụ tiết lộ thông tin cá nhân,…','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698081769/kac06xx1rwribrtetl6z.jpg',1),(20,'BÁO CÁO CHUYÊN ĐỀ “NHẬN THỨC VỀ AN NINH MẠNG TRONG THẾ GIỚI HIỆN ĐẠI”','Nhằm nâng cao nhận thức về an toàn và bảo mật thông tin','Nhằm nâng cao nhận thức về an toàn và bảo mật thông tin trong thời đại số; Ngày 05/06/2023, Trường Đại học Mở Thành phố Hồ Chí Minh đã tổ chức báo cáo chuyên đề “Nhận thức về an ninh mạng trong thế giới hiện đại” tại Hội trường 202, cơ sở 35 – 37 Hồ Hảo Hớn, Quận 1. Báo cáo viên của chương trình là Ông Ngô Minh Hiếu – Chuyên gia an toàn thông tin – Trung tâm giám sát an toàn không gian mạng quốc gia Việt Nam và đồng sáng lập dự án Chongluadao.vn.\r\nTrong giai đoạn đẩy mạnh và tăng tốc chuyển đổi số hiện nay, nguy cơ an ninh mạng đang đe dọa đến sự riêng tư, an toàn và tài sản của người dùng. Là một người có nhiều kiến thức liên quan đến vấn đề bảo mật, ông Ngô Minh Hiếu đã đưa ra các tình huống, các thủ đoạn lừa đảo trực tuyến và cách giải quyết để bảo vệ tài khoản trên mạng xã hội cũng như dữ liệu cá nhân, tránh bị hacker xâm nhập.\r\nBáo cáo viên đã hướng dẫn các cán bộ viên chức Nhà trường cách bảo mật tài khoản mạng xã hội cá nhân như: cách đặt mật khẩu, chọn phương thức bảo mật, hạn chế dùng wifi công cộng… Đây là những yếu điểm khiến hacker có thể thâm nhập và đoạt quyền sử dụng tài khoản. Bên cạnh đó, ông Ngô Minh Hiếu còn cho biết thêm các đối tượng lừa đảo lợi dụng công nghệ Deepfake (công nghệ ứng dụng trí tuệ nhân tạo) để tạo ra các đoạn video với hình ảnh, khuôn mặt nhân vật giống hệt như hình ảnh của người dùng muốn giả mạo để yêu cầu “nạn nhân” chuyển tiền.','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698081535/ieigwrgo0xidlkdmije7.jpg',1),(21,'TỌA ĐÀM “HOẠT ĐỘNG CỰU SINH VIÊN TRONG GIAI ĐOẠN HIỆN NAY” ','Sáng ngày 25/06/2023, Trường Đại học Mở TP. Hồ Chí Minh','Sáng ngày 25/06/2023, Trường Đại học Mở TP. Hồ Chí Minh tổ chức buổi Đối thoại “Hoạt động Cựu sinh viên trong giai đoạn hiện nay” & Họp mặt Cựu sinh viên là doanh nhân, nhà quản lý tiêu biểu tại Hội trường 602 cơ sở 97 Võ Văn Tần, với mục đích gặp  mặt giải, tri ân và thảo luận về những đề xuất phát triển hiệu quả hoạt động của các cựu sinh viên trong giai đoạn hiện nay giữa Ban giáo hiệu Trường, lãnh đạo các Khoa, cựu giảng viên, cựu sinh viên trường. \r\nTrong tọa đàm là phần thảo luận và chia sẻ đưa ra những đề xuất phát triển đến Nhà trường nói chung và các hoạt động Cựu sinh viên nói riêng từ lãnh đạo các khoa, cựu giảng viên, cựu sinh viên,…','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698081312/cux67g7i1rla3hzlkjhz.jpg',2),(22,'THƯ MỜI HỌP MẶT CỰU SINH VIÊN KHOA CÔNG NGHỆ THÔNG TIN','Chương trình Họp mặt cựu sinh viên khoa','Chương trình Họp mặt cựu sinh viên khoa Công nghệ thông tin\r\n\r\nNhằm tạo điều kiện, môi trường để các Anh/Chị cựu sinh viên các Khóa ôn lại kỷ niệm thời sinh viên với các Thầy/Cô là giảng viên, cựu giảng viên của khoa Công nghệ thông tin, kết nối các Anh/Chị cựu sinh viên cùng lớp sau những năm xa trường, đồng thời kết nối các thế hệ sinh viên đang học tập tại Khoa với các Anh/Chị cựu sinh viên.\r\n\r\nKhoa Công nghệ thông tin thân mời các Anh/Chị là cựu sinh viên các khóa Khoa Công nghệ thông tin - Khoa Tin Học đến tham dự chương trình họp mặt cựu sinh viên Khoa CNTT, cụ thể như sau:\r\n\r\n    Thời gian: 17h00 ngày 23 tháng 01 năm 2021\r\n\r\n    Địa điểm: Hội trường 602 cơ sở 97 Võ Văn Tần, Phường 6, Quận 3, Thành phố Hồ Chí Minh\r\n\r\nNội dung chương trình:\r\n\r\n    Cùng nhau nhìn lại chặng đường sinh viên đã đi qua.\r\n\r\n    Ôn lại kỷ niệm với quý Thầy/Cô\r\n\r\n    Thưởng thức các tiết mục văn nghệ gợi nhớ trường, lớp.\r\n\r\n    Lễ ra mắt câu lạc bộ Cựu sinh viên khoa Công nghệ thông tin','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698080244/ir4yjniibfed8zlaqe6q.jpg',2),(24,'THÔNG BÁO VỀ VIỆC TỔ CHỨC LỄ TỐT NGHIỆP ĐẠI HỌC CHÍNH QUY NĂM 2023','Thực hiện kế hoạch số 2129/KH-ĐHM ngày 19/9/2023','Thực hiện kế hoạch số 2129/KH-ĐHM ngày 19/9/2023 về việc tổ chức Lễ tốt nghiệp hệ Đại học chính quy năm 2023 (đợt 2) của Trường;\r\n\r\nPhòng Công tác sinh viên và Truyền thông thông báo đến toàn thể sinh viên về việc tổ chức Lễ tốt nghiệp Đại học chính quy năm 2023 (đợt 2), cụ thể như sau:\r\n\r\nĐối tượng: Sinh viên tốt nghiệp đợt tháng 9/2023 và sinh viên đã tốt nghiệp trong năm 2023 chưa đăng ký tham dự lễ tốt nghiệp. Sinh viên (SV) chưa tốt nghiệp (còn nợ môn học) không được đăng ký tham dự lễ.\r\n\r\nThời gian – Địa điểm tổ chức lễ tốt nghiệp:\r\nThời gian: Ngày 11,12,19/11/2023.','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698079950/dfobuohmnbmvh8wfulhs.jpg',1),(28,'TRƯỜNG ĐẠI HỌC MỞ TP.HCM ĐỒNG HÀNH CÙNG CHƯƠNG TRÌNH MENTORING TRONG HÀNH TRÌNH MENTORING 3','Tiếp nối thành công của Chương trình Mentoring ','Tiếp nối thành công của Chương trình Mentoring Mùa 1 và Mùa 2, Chương trình Mentoring Mùa 3 (2023 - 2024) do Câu Lạc Bộ Cựu Sinh Viên Trường Đại học Mở TP. HCM (OU Alumni Club) cùng Câu lạc bộ Doanh nhân Gia đình TP. HCM (FBCH) và Viện phát triển Doanh nghiệp & Tài năng Việt Nam (IVN) phối hợp tổ chức chính thức khởi động nhằm tạo điều kiện tốt nhất cho các bạn sinh viên phát huy khả năng, thấu hiểu bản thân & trao nhiều học bổng, cơ hội nghề nghiệp đến các bạn trẻ. \r\n\r\nHãy trở thành Mentor - người dẫn dắt và truyền cảm hứng cho các thế hệ mai sau, chia sẻ những kinh nghiệm vốn có, quý báu trên chặng đường sự nghiệp cũng như dẫn dắt thế hệ trẻ và tạo nên sự thay đổi ở những thế hệ đàn em của mình.\r\n\r\nVới sứ mệnh: “Cho đi để phát triển”, Chúng tôi tin chắc rằng sẽ tạo điều kiện tốt nhất để tạo cơ hội cho Quý Anh/Chị Mentor cùng với các bạn Mentee có những trải nghiệm tuyệt vời trên chặng đường đồng hành cùng Chương trình.','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698079893/alw61wcjgo9gzg7tonym.jpg',2),(29,'Data Engineer Intern - Savills Vietnam','Data Engineer Intern - Savills Vietnam','Mô Tả Công Việc\r\nTên đơn vị: Savills Vietnam\r\n\r\nĐịa chỉ: Doji Tower, 81-85 Hàm Nghi, Phường Nguyễn Thái Bình, Quận 1, TP.HCM\r\n\r\nĐiện thoại: 028 7309 1868\r\n\r\nWebsite: www.savills.com.vn\r\n\r\nMô tả công việc: \r\nImport data & handle data workflow following business requirements.\r\nDesign, implement and monitor the data quality control system to ensure data completeness and quality.\r\nMaintain data process/ services in Microsoft Azure system.\r\nCrawling, transforming data to serve business insight.\r\nĐịa điểm làm việc: Doji Tower, 81-85 Hàm Nghi, Phường Nguyễn Thái Bình, Quận 1, TP.HCM\r\n\r\nThu nhập: Thỏa thuận\r\n\r\nYêu Cầu Công Việc\r\nYêu cầu ứng viên:\r\n\r\nCurrently enrolled in a relevant degree program.\r\nExcellent attention to detail.\r\nStrong analytical and data science skills.\r\nProficiency in ETL, Data Warehouse, Database Management.\r\nAbility to work independently and in a team environment.\r\n\r\nHồ sơ gồm:\r\n01 CV (Kèm theo ảnh cá nhân)\r\n01 Bản tóm tắt giới thiệu bản thân\r\nNộp hồ sơ:\r\n\r\nHạn chót nhận hồ sơ: 30/11/2023','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698083277/xwaprdevquvjbuzi9q6j.png',4),(30,'Thực tập sinh Lập trình - Công ty Cổ phần ASOFT','Thực tập sinh Lập trình - Công ty Cổ phần ASOFT','Mô Tả Công Việc\r\nTên đơn vị: Công ty Cổ phần ASOFT\r\nĐịa chỉ: Tầng 3, Tòa nhà JVPE, CVPM Quang Trung, P.Tân Chánh Hiệp, Quận 12\r\nWebsite: asoft.com.vn\r\n\r\nMô tả công việc:\r\nLập trình bổ sung tính năng phần mềm\r\nTham gia vào quá trình phát triển ý tưởng, sản phẩm mới.\r\nĐịa điểm làm việc: Tầng 3, Tòa nhà JVPE, CVPM Quang Trung, P.Tân Chánh Hiệp, Quận 12\r\nThu nhập: Thỏa thuận\r\n\r\nĐiều kiện làm việc:\r\nThời gian làm việc Full time: T2 – T6 (8h – 17h; nghỉ trưa 1 tiếng)\r\nThời gian làm việc Part time: tối thiểu 04 ngày/tuần\r\nCombo môi trường làm việc trẻ trung, năng động + đồng nghiệp thân thiện.\r\nĐược đào tạo từ cơ bản đến nâng cao và nghiệp vụ chuyên môn khi tham gia công việc.\r\nHỗ trợ thủ tục hành chính, hướng dẫn các bạn sinh viên thực hiện báo cáo ngoại khóa, khóa luận, đề án tốt nghiệp.\r\n\r\nYêu Cầu Công Việc\r\nYêu cầu ứng viên:\r\nSinh viên năm 4 hoặc vừa mới tốt nghiệp từ các trường Đại học/Cao đẳng chính quy trong nước và nước ngoài khối ngành: tin học quản lý, công nghệ thông tin\r\nGPA >= 6.0\r\nCó kỹ năng giao tiếp và giải quyết vấn đề tốt.\r\nChăm chỉ, nhiệt tình, nhanh nhẹn.\r\n\r\nHồ sơ gồm:\r\nĐơn xin việc\r\nCV\r\n\r\nNộp hồ sơ:\r\nHạn chót nhận hồ sơ: 31/10/2023\r\nPhương thức nộp:\r\nỨng tuyển tại đây: https://forms.office.com/r/btwt4tktS9\r\nGửi về mail: recruit@asoft.com.vn\r\nHotline: 0946.870.035','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698083490/gmnqtgzdzjdxxptvz3oi.png',4),(31,'Thực tập sinh Kỹ Sư Dữ Liệu - Savills Vietnam','Thực tập sinh Kỹ Sư Dữ Liệu - Savills Vietnam\r\n','\r Tên đơn vị: Savills Vietnam\r Địa chỉ: Doji Tower, 81-85 Hàm Nghi, Phường Nguyễn Thái Bình, Quận 1, TP.HCM\r Điện thoại: 028 7309 1868\r Website: www.savills.com.vn.\r \r Mô tả công việc: \r Thiết kế, triển khai và theo dõi hệ thống kiểm soát chất lượng dữ liệu để đảm bảo tính toàn vẹn và chất lượng của dữ liệu.\r Bảo trì quy trình/dịch vụ dữ liệu trong hệ thống Microsoft Azure.\r Thu thập, biến đổi dữ liệu để phục vụ thông tin kinh doanh.\r Địa điểm làm việc: Doji Tower, 81-85 Hàm Nghi, Phường Nguyễn Thái Bình, Quận 1, TP.HCM\r \r Thu nhập: Thỏa thuận\r .\r Yêu Cầu Công Việc\r Yêu cầu ứng viên:\r Hiện đang theo học trong chương trình học liên quan.\r Chú ý tuyệt vời đến chi tiết.\r Kỹ năng phân tích mạnh mẽ và khoa học dữ liệu.\r Thành thạo trong ETL, Data Warehouse, Quản lý Cơ sở dữ liệu.\r Có khả năng làm việc độc lập và trong môi trường làm việc nhóm.\r \r Hồ sơ gồm:\r 01 CV (Kèm theo ảnh cá nhân)\r 01 Bản tóm tắt giới thiệu bản thân\r. Nộp hồ sơ:\r \r Hạn chót nhận hồ sơ: 30/11/2023','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698083729/xwkajctbgvmiy3uhacci.png',4),(32,'BA/QC/Support Intern - Savills Vietnam','BA/QC/Support Intern - Savills Vietnam','Tên đơn vị: Savills Vietnam\r\n\r\nĐịa chỉ: Doji Tower, 81-85 Hàm Nghi, Phường Nguyễn Thái Bình, Quận 1, TP.HCM\r\n\r\nĐiện thoại: 028 7309 1868\r\n\r\nWebsite: www.savills.com.vn\r\n\r\nMô tả công việc: \r\nTo understand clearly about product & write documentation.\r\nLiaise with across business lines to understand their IT requirements.\r\nSupport various teams with their day-to-day IT needs.\r\nWork with the Development Team using Agile standard processes.\r\nĐịa điểm làm việc: Doji Tower, 81-85 Hàm Nghi, Phường Nguyễn Thái Bình, Quận 1, TP.HCM\r\n\r\nThu nhập: Thỏa thuận\r\n\r\nYêu Cầu Công Việc\r\nYêu cầu ứng viên:\r\nEducation: 3rd year or 4th year student.\r\nCommunication skills: Strong interpersonal skills.\r\nPC skills:\r\nGood at Microsoft Office.\r\nPlus for the experience with the Agile Scrum process.\r\nLanguage: Proficient English (both speaking and writing).\r\nKey characteristics:\r\nHave a mindset of teamwork, able to work individually.\r\nPlus for the real estate and property management knowledge.\r\n\r\nHồ sơ gồm:\r\n01 CV (Kèm theo ảnh cá nhân)\r\n01 Bản tóm tắt giới thiệu bản thân\r\n\r\nNộp hồ sơ:\r\nHạn chót nhận hồ sơ: 30/11/2023','https://res.cloudinary.com/dtsgrf7xu/image/upload/v1698083981/metiiobefhtnpsaynrti.png',4);
/*!40000 ALTER TABLE `tintuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tintuc_tag`
--

DROP TABLE IF EXISTS `tintuc_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tintuc_tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tintuc_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tintuc_id_idx` (`tintuc_id`),
  KEY `fk_tag_id_idx` (`tag_id`),
  CONSTRAINT `fk_tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`),
  CONSTRAINT `fk_tintuc_id` FOREIGN KEY (`tintuc_id`) REFERENCES `tintuc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tintuc_tag`
--

LOCK TABLES `tintuc_tag` WRITE;
/*!40000 ALTER TABLE `tintuc_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tintuc_tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-28  1:40:27
