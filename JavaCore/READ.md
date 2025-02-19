I. List Interface 
List Interface : là interface của collection interface chúng ta có thế
luu giữ tập hợp các đối tượng có thứ tự được thực hiện bởi
 + List : Là một danh sách các phần tử có thứ tự list có thể chứa hai hoặc nhiều các
 phần tử giống nhau :
   -ArryList : Được sử dụng trong trường hợp bản đọc không dùng taác động thêm sửa xóa vì nó không tối ưu trong trường
   hợp taác động vào nó sẽ phải sắp xếp lại các phần tử phù hợp nhất với read
   -LinkList : Dùng nhiều trong trường hợp thêm sửa xóa sản phẩm đươợc tại nó khoong tác động nhiều tới danh sách
   nó chỉ tác động đến hai phần tử trc và sau nó
 + Set : là một danh sách các phần tu không có thứ tự và không cho phép các phần  tử trùng nhau
   -L
 + Map : lứu trữ các phần tử thao cặp giá trị (Key end Value) không cho phép cap Key trùng nhau
 + Queue : Lưu Các Phần tử theo công thứ FIFO(First in , First out) (sử dụng trong các dao dịch cần theo thứ tự)


Giả sử viết mot chương trình thực thi giao dịch ATM system hoặc giao dịch internet BAnking
chuungs ta sẽ phải thực hiện các collection API như tnao ?
1. Map<String, Account> accountsMap = new HashMap<>();
    - Chức Năng : Lưu trữ ds tài khoản, tra cứu nhanh thao stk (account number)
    - HashMap : có thời gian truy xuất phần tử trung bình là 0(1), phù hợp cho thao tác tim hiểu cap nhật

2. List<Transaction> transactionList = new ArrayList<>();
    - chức năng : lưu toàn bộ lịch sử giao dịch 
    - ArrayList : Cho phép duyêệt và thêm cuối nhanh trung  biình là 0(1). không dùng cho thao taác 
    trèn xóa sửa ở giữa ... thường xuyên
   
3. Set<String>backlistAccounts = HashSet<>();
    - Chức Nẳng : lưu danh saách các tài khóa , (blacklist), cần khoong trùng lặp và kiểm tra thành viên nhanh
    - HashSet : cho phép kiểm tra (contains) trung bình 0(1) rất thích hợp , tìm kiếm, ngăn chặn

4. Queue<Transaction>transaction Queue = new LinkedList <>();
    - Chức Năng : minh họa mô hình FIFO(First in First out) cho phép diễn ra giao dịch lần lượt
    - LinkedList : thực hiện tốt câấu trúc queue

5. Set<String>storeAccountNumbers = new Tree<>();
    - Chức Năng : Lưu Các accountNumber dưới dạng sắp xếp tự nhiên theo thứ tự tăng dần

6. PriorityQueue<Account> accountByBalance = new PriorityQueue<>(Comparator)
    -Chức Năng : Luưu các account theo độ ưu tiên (vd: Xắp xếp giảm  dần theo số dư), giúp ta biết ngay
    ngay tài khoản có số dư lớn nhất
    -PriorityQueue : cho phép lấy phần tử có độ ưu tiên trung bình là 0(log n)
II. JDBC :
1. JDBC là gì ?
   - JDBC (Java Database Connectivity) là một API của Java cho phép các lập trình viên truy cập và thao tác với cơ sở dữ liệu
   - JDBC cung cấp một tập hợp các lớp và giao diện để kết nối với cơ sở dữ liệu, thực hiện các truy vấn và cập nhật dữ liệu
   - JDBC cung cấp một cách tiêu chuẩn để kết nối với bất kỳ cơ sở dữ liệu nào
   + NoSQL : Dùng cho khi sd đến cơ sở dữ lieeu BigData ví dụ được sd trong fb
   + SQL : Dùng cho cơ sở dữ liệu quan hệ trúng thường được dùng cho truy vết thông tin dùng trong bans 
    hàng (câần có sự ràng buộc với nhau)
   - Connect to database có hai phương thức để kết nối với nó :
   + Statement va PreparedStatement nên dùng PreparedStatement vì nó an toàn hơn khó bị tấn
   công SQL Injection hơn là khi sử dụng statement
   - 1NF 2NF 3NF là : Các bước chuẩn hóa cơ sở dữ liệu (Database Normalization) để giảm thiểu dữ liệu trùng lặp
    và giữ cho dữ liệu cơ sở dữ liệu có tính nhất quán
   + 1NF : Fist Nomal Form : dạng chuẩn 1NF nếu các thuộc tính chỉ nhận giá trị tại moot bản ghi
   hay noi một cách khác mọi thuộc tính đều là đơn trị,để đưa ve chuẩn 1 có 2 cacách :
    - Tách bảng : Tách bảng ra thành các bảng và ghi giá trị của chugs
    - Tacách cột : Tách cột ra thành các cột
    
   + 2NF : SeCond Nomal Form : Mootjt bảng được gọi là 2NF nếu nó đạt chuẩn 1NF ngoài ra các thuộctinhshs không khóa phụ thuộc tính 
   không khóa phụ thuộc hoàn toàn vào khoá chính , nghĩa là khoong tồn tại trường hợp  thuộc tính không khóa
   phụ thuộc vào tập con của khóa
   
   + 3NF :Third Nomal Form : Một Bảng được gọi là 3NF nếu nó đạt chuẩn 2NF, các thuộc tính không khóa không phụ thuộc bắc cầu vào khóa chiính 
   , nghĩa là không toon tại trường hợp thuộc tính không khooas phụ thuộc vào thuộc tính không khóa khác

Baif Tập Hoành thành atm system JDBC
viết data chuẩn hóa giữ liệu 1NF 2NF 3NF
    