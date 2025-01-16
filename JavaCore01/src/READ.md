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