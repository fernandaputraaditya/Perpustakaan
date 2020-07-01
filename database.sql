SQL> CREATE TABLESPACE fernanda_07015_modul1
  1  datafile 'E:\ITATS\Matkul\Semester 4\ Basis Data\Praktikum\Modul 1\ sistem_perpustakaan.dbf'
  2  size 30M;

Tablespace created.

SQL> CREATE USER fernanda_07015
  1  IDENTIFIED BY fernanda
  2  DEFAULT TABLESPACE fernanda_07015_modul1
  3  QUOTA 30M ON fernanda_07015_modul1;

User created.

SQL> GRANT ALL PRIVILEGES TO fernanda_07015;

Grant succeeded.

SQL> conn fernanda_07015/fernanda
Connected.

SQL> create table Admin_07015
  1  (
  2  Id_admin INTEGER not null,
  3  Nama VARCHAR2(30),
  4  Alamat VARCHAR2(100),
  5  Jenis_kelamin VARCHAR2(10),
  6  Password VARCHAR2(15),
  7  constraint PK_Admin primary key (Id_admin)
  8  );

Table created.

SQL> create table Member_07015
  1  (
  2  Id_member INTEGER not null,
  3  Nama VARCHAR2(30),
  4  Alamat VARCHAR2(100),
  5  Jenis_kelamin VARCHAR2(10),
  6  Tanggal_lahir DATE,
  7  No_telp NUMBER(12),
  8  Nik NUMBER(20),
  9  Email VARCHAR2(30),
 10  Password VARCHAR2(15),
 11  constraint PK_Member primary key(Id_member)
 12  );

Table created.

SQL> create table Buku_07015
  1  (
  2  Id_buku INTEGER not null,
  3  Judul_buku VARCHAR2(20),
  4  Pengarang VARCHAR2(30),
  5  Tahun_terbit NUMBER(4),
  6  constraint PK_Buku primary key (Id_buku)
  7  );

Table created.

SQL> create table Peminjaman_07015
  1  (
  2  Id_peminjaman INTEGER not null,
  3  Id_admin INTEGER,
  4  Id_member INTEGER,
  5  Id_buku INTEGER,
  6  Tanggal_pinjam DATE,
  7  constraint PK_Peminjaman primary key(Id_peminjaman)
  8  );

Table created.

SQL> create table Detail_Peminjaman_07015
  1  (
  2  Id_peminjaman INTEGER not null,
  3  Id_buku INTEGER
  4  );

Table created.

SQL> alter table Peminjaman_07015
  1  add constraint FK_Id_Admin FOREIGN KEY (Id_admin)
  2  references Admin_07015(Id_admin)
  3  add constraint FK_Id_Member FOREIGN KEY (Id_member)
  4  references Member_07015(Id_member)
  5  add constraint FK_Id_Buku FOREIGN KEY (Id_buku)
  6  references Buku_07015(Id_buku);

Table altered.

SQL> alter table Detail_Peminjaman_07015
  1  add constraint FK_Id_Peminjaman FOREIGN KEY (Id_peminjaman)
  2  references Peminjaman_07015(Id_peminjaman)
  3  add constraint FK_Id_Book FOREIGN KEY (Id_buku)
  4  references Buku_07015(Id_buku);

Table altered.

SQL> create sequence seq_peminjaman
  1  minvalue 1
  2  maxvalue 9999
  3  start with 1
  4  increment by 1
  5  nocache;

Sequence created.

SQL> insert into Admin_07015 (Id_Admin, Nama, Alamat, Jenis_Kelamin, Password) values (1, 'Fernanda Putra', 'Sidoarjo', 'Pria', 'admin1');

1 row created.

SQL> insert into Admin_07015 (Id_Admin, Nama, Alamat, Jenis_Kelamin, Password) values (2, 'Odila Windy', 'Sidoarjo', 'Perempuan', 'admin2');

1 row created.

SQL> insert all
  1  into Admin_07015 (Id_Admin, Nama, Alamat, Jenis_Kelamin, Password) values (3, 'Siska Dian', 'Surabaya', 'Perempuan', 'admin3')
  2  into Admin_07015 (Id_Admin, Nama, Alamat, Jenis_Kelamin, Password) values (4, 'Sita Fara', 'Surabaya', 'Perempuan', 'admin4')
  3  into Admin_07015 (Id_Admin, Nama, Alamat, Jenis_Kelamin, Password) values (5, 'Puji Febrian', 'Sidoarjo', 'Pria', 'admin5')
  4  select 1 from dual;

3 rows created.

SQL> insert into Member_07015 (Id_Member, Nama, Alamat, Jenis_Kelamin, Tanggal_Lahir, No_Telp, Nik, Email, Password) values (1, 'Ilham Bayu', 'Sidoarjo', 'Pria', to_date('01/10/1998','dd/mm/yyyy'), '123456789', '987654321', 'ilhambayu@gmail.com', 'member1');

1 row created.

SQL> insert into Member_07015 (Id_Member, Nama, Alamat, Jenis_Kelamin, Tanggal_Lahir, No_Telp, Nik, Email, Password) values (2, 'M Yusuf', 'Sidoarjo', 'Pria', to_date('25/01/1997','dd/mm/yyyy'), '234567891', '876543219', 'myusuf@gmail.com', 'member2');

1 row created.

SQL> insert all
  2  into Member_07015 (Id_Member, Nama, Alamat, Jenis_Kelamin, Tanggal_Lahir, No_Telp, Nik, Email, Password) values (3, 'Eri Rahmawati', 'Surabaya', 'Perempuan', to_date('06/11/2000','dd/mm/yyyy'), '345678912', '765432198', 'erir@gmail.com', 'member3')
  3  into Member_07015 (Id_Member, Nama, Alamat, Jenis_Kelamin, Tanggal_Lahir, No_Telp, Nik, Email, Password) values (4, 'Cindy Melinda', 'Sidoarjo', 'Perempuan', to_date('08/01/1998','dd/mm/yyyy'), '456789123', '654321987', 'cindym@gmail.com', 'member4')
  4  into Member_07015 (Id_Member, Nama, Alamat, Jenis_Kelamin, Tanggal_Lahir, No_Telp, Nik, Email, Password) values (5, 'Dwi Prasetyo', 'Surabaya', 'Pria', to_date('31/05/1998','dd/mm/yyyy'), '567891234', '543219876', 'dwip@gmail.com', 'member5')
  5  select 1 from dual;

3 rows created.


SQL> insert into Buku_07015 (Id_Buku, Judul_Buku, Pengarang, Tahun_Terbit) values (1, 'Basis Data', 'Kurniawan', '2020');

1 row created.

SQL> insert into Buku_07015 (Id_Buku, Judul_Buku, Pengarang, Tahun_Terbit) values (2, 'Jaringan Komputer', 'Gusti Eka', '2020');

1 row created.

SQL> insert all
  into Buku_07015 (Id_Buku, Judul_Buku, Pengarang, Tahun_Terbit) values (3, 'Statistika Komputasi', 'Rani Muhima', '2020')
  into Buku_07015 (Id_Buku, Judul_Buku, Pengarang, Tahun_Terbit) values (4, 'Otomata', 'Hendro P', '2020')
  into Buku_07015 (Id_Buku, Judul_Buku, Pengarang, Tahun_Terbit) values (5, 'Bahasa Inggris', 'Putut Handoko', '2020')
  select 1 from dual;

3 rows created.

SQL> insert into Peminjaman_07015 (Id_Peminjaman, Id_Admin, Id_Member, Id_Buku, Tanggal_Pinjam_07015) values (seq_peminjaman.nextval, 1, 1, 1, to_date('25/04/2020','dd/mm/yyyy'));

1 row created.

SQL> insert into Peminjaman_07015 (Id_Peminjaman, Id_Admin, Id_Member, Id_Buku, Tanggal_Pinjam_07015) values (seq_peminjaman.nextval, 2, 2, 2, to_date('26/04/2020', 'dd/mm/yyyy'));

1 row created.

SQL> insert into Peminjaman_07015 (Id_Peminjaman, Id_Admin, Id_Member, Id_Buku, Tanggal_Pinjam_07015) values (seq_peminjaman.nextval, 3, 3, 3, to_date('27/04/2020','dd/mm/yyyy'));

1 row created.

SQL> insert into Peminjaman_07015 (Id_Peminjaman, Id_Admin, Id_Member, Id_Buku, Tanggal_Pinjam_07015) values (seq_peminjaman.nextval, 4, 4, 4, to_date('28/04/2020','dd/mm/yyyy'));

1 row created.

SQL> insert into Peminjaman_07015 (Id_Peminjaman, Id_Admin, Id_Member, Id_Buku, Tanggal_Pinjam_07015) values (seq_peminjaman.nextval, 5, 5, 5, to_date('29/04/2020','dd/mm/yyyy'));

1 row created.

SQL> insert into Detail_Peminjaman_07015 (Id_Peminjaman, Id_Buku) values (1, 1);

1 row created.

SQL> insert into Detail_Peminjaman_07015 (Id_Peminjaman, Id_Buku) values (2, 2);

1 row created.

SQL> insert all
  2  into Detail_Peminjaman_07015 (Id_Peminjaman, Id_Buku) values (3, 3)
  3  into Detail_Peminjaman_07015 (Id_Peminjaman, Id_Buku) values (4, 4)
  4  into Detail_Peminjaman_07015 (Id_Peminjaman, Id_Buku) values (5, 5)
  5  select 1 from dual;

3 rows created.

SQL> SELECT A.ID_PEMINJAMAN, B.NAMA, C.NAMA, D.JUDUL_BUKU, A.TANGGAL_PINJAM FROM PEMINJAMAN_07015 A JOIN ADMIN_07015 B 
     ON A.ID_ADMIN = B.ID_ADMIN JOIN MEMBER_07015 C ON A.ID_MEMBER = C.ID_MEMBER JOIN BUKU_07015 D ON 
     A.ID_BUKU = D.ID_BUKU ORDER BY ID_PEMINJAMAN ASC;

SQL> CREATE OR REPLACE VIEW LIST_DETAIL_PEMINJAMAN AS
  2  SELECT A.ID_PEMINJAMAN, A.ID_BUKU, B.TANGGAL_PINJAM
  3  FROM DETAIL_PEMINJAMAN_07015 A JOIN PEMINJAMAN_07015 B ON A.ID_PEMINJAMAN = B.ID_PEMINJAMAN;

View created.





