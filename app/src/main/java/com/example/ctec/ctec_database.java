package com.example.ctec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ctec_database extends SQLiteOpenHelper {

    // thông số Table SINHVIEN
    private static String TB_STU = "SINHVIEN";
    private static String TB_STU_MSSV = "MSSV";
    private static  String TB_STU_MKDN = "STU_MATKHAUDANGNHAP";
    private static String TB_STU_ANH = "STU_ANH";
    private static String TB_STU_HOTEN = "STU_HOTEN";
    private static String TB_STU_GIOITINH = "STU_GIOITINH";
    private static String TB_STU_NGAYSINH = "STU_NGAYSINH";
    private static String TB_STU_NOISINH = "STU_NOISINH";
    private static String TB_STU_DIACHI = "STU_DIACHI";
    private static String TB_STU_SHSNH = "STU_SOHOSONHAPHOC";
    private static String TB_STU_CCCD = "STU_CCCD";
    private static String TB_STU_SDT = "STU_SDT";
    private static String TB_STU_EMAIL = "STU_EMAIL";

    //lệnh SQL tạo bảng SINHVIEN
    private String CreateTB_SINHVIEN = "CREATE TABLE "+TB_STU+ "("+TB_STU_MSSV+" TEXT PRIMARY KEY, "+TB_STU_MKDN+" TEXT,"+TB_STU_ANH+" BLOB," +TB_STU_HOTEN+" TEXT,"
            +TB_STU_GIOITINH+" TEXT,"+TB_STU_NGAYSINH+ " DATE,"+TB_STU_NOISINH+" TEXT,"+TB_STU_DIACHI+" TEXT,"+TB_STU_SHSNH+"  INTERGER,"+TB_STU_CCCD+" TEXT,"
            +TB_STU_SDT+" TEXT,"+TB_STU_EMAIL+" TEXT,"+TB_LOP_MALOP+" TEXT REFERENCES "+TB_LOP+"("+TB_LOP_MALOP+"),"
            +TB_TCH_MSGV+" TEXT REFERENCES "+TB_TCH+"("+TB_TCH_MSGV+"))";

    // thông số Table GIANGVIEN
    private static String TB_TCH = "GIANGVIEN";
    private static String TB_TCH_MSGV = "MSGV";
    private static String TB_TCH_MKDN = "TCH_MATKHAUDANGNHAP";
    private static String TB_TCH_HOTEN = "TCH_HOTEN";
    private static String TB_TCH_ANH = "TCH_ANH";

        //lệnh SQL tạo bảng SINHVIEN
    private String CreateTB_GIANGVIEN = "CREATE TABLE "+TB_TCH+" ("+TB_TCH_MSGV+" TEXT PRIMARY KEY,"+TB_TCH_MKDN+" TEXT,"+TB_TCH_ANH+" BLOB,"+TB_TCH_HOTEN+" TEXT,"
                +TB_LOP_MALOP+" TEXT, FOREIGN KEY ("+TB_LOP_MALOP+") REFERENCES "+TB_LOP+"("+TB_LOP_MALOP+"))";

    //thông số Table MONHOC
    private static String TB_MONHOC = "MONHOC";
    private static String TB_MONHOC_MAMON = "MAMON";
    private static String TB_MONHOC_TENMON = "TENMON";
    private static String TB_MONHOC_SOTC = "SOTINCHI";

    //lệnh SQL tạo bảng HOCKY
    private String CreateTB_MONHOC = "CREATE TABLE "+TB_MONHOC+"("+TB_MONHOC_MAMON+" TEXT PRIMARY KEY,"+TB_MONHOC_TENMON+" TEXT,"+TB_MONHOC_SOTC+" TEXT,"
            +TB_HOCKY_MAHK+" TEXT, FOREIGN KEY ("+TB_HOCKY_MAHK+") REFERENCES "+TB_HOCKY+"("+TB_HOCKY_MAHK+"))";


    //thông số Table HOCKY
    private static String TB_HOCKY = "HOCKY";
    private static String TB_HOCKY_MAHK = "MAHOCKY";
    private static String TB_HOCKY_TENHK = "TENHOCKY";

    //lệnh SQL tạo bảng HOCKY
    private String CreateTB_HOCKY = "CREATE TABLE "+TB_HOCKY+" ("+TB_HOCKY_MAHK+" TEXT PRIMARY KEY,"+TB_HOCKY_TENHK+" TEXT)";

    //thông số Table KETQUAHOCTAP
    private static String TB_KQHT = "KETQUAHOCTAP";
    private static String TB_KQHT_D1_1 = "D1_1";
    private static String TB_KQHT_D1_2 = "D1_2";
    private static String TB_KQHT_D1_3 = "D1_3";
    private static String TB_KQHT_D2_1 = "D2_1";
    private static String TB_KQHT_D2_2 = "D2_2";
    private static String TB_KQHT_D2_3 = "D2_3";
    private static String TB_KQHT_D3_1 = "D3_1";
    private static String TB_KQHT_TBM = "D_TBM";
    private static String TB_KQHT_TBHP = "D_TBHP";

    //lệnh SQL tạo bảng KETQUAHOCTAP
    private String CreateTB_KQHT = "CREATE TABLE "+TB_KQHT+" ("+TB_STU_MSSV+" TEXT REFERENCES "+TB_STU+"("+TB_STU_MSSV+"),"
            +TB_MONHOC_MAMON+" TEXT REFERENCES "+TB_MONHOC+"("+TB_MONHOC_MAMON+"),"
            +TB_KQHT_D3_1+" FLOAT,"+TB_KQHT_D1_1+ " FLOAT,"+TB_KQHT_D1_2+" FLOAT,"+TB_KQHT_D1_3+" FLOAT,"+TB_KQHT_D2_1+" FLOAT,"
            +TB_KQHT_D2_2+" FLOAT,"+TB_KQHT_D2_3+" FLOAT," +TB_KQHT_TBM+" FLOAT,"+TB_KQHT_TBHP+" FLOAT)";

    //thông số Table LOP
    private static String TB_LOP = "LOP";
    private static String TB_LOP_MALOP = "MALOP";
    private static String TB_LOP_TENLOP = "TENLOP";

    //lệnh SQL tạo bảng LOP
    private static String CreateTB_LOP = "CREATE TABLE "+TB_LOP+" ("+TB_LOP_MALOP+" TEXT PRIMARY KEY,"+TB_LOP_TENLOP+" TEXT)";



    public ctec_database(@Nullable Context context) {
        super(context, "QUANLYCTEC", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTB_LOP);
        db.execSQL(CreateTB_HOCKY);
        db.execSQL(CreateTB_MONHOC);
        db.execSQL(CreateTB_GIANGVIEN);
        db.execSQL(CreateTB_SINHVIEN);
        db.execSQL(CreateTB_KQHT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//-----------------------------------------------------------------------TABLE SINHVIEN---------------------------------------------------------------------------
    //Xử lý chức năng cơ sở dữ liệu của bảng SINHVIEN
            //sự kiện insert
  public Boolean insertSTU(String mssv, String mk, String hoten, String gt, String ngaysinh,
                           String noisinh, String diachi, String sohs, String cccd, String sdt,
                           String email, String mlop, String magv) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MSSV",mssv);
        values.put("STU_MATKHAUDANGNHAP",mk);
        values.put("STU_HOTEN",hoten);
        values.put("STU_GIOITINH",gt);
        values.put("STU_NGAYSINH",ngaysinh);
        values.put("STU_NOISINH",noisinh);
        values.put("STU_DIACHI",diachi);
        values.put("STU_SOHOSONHAPHOC",sohs);
        values.put("STU_CCCD",cccd);
        values.put("STU_SDT",sdt);
        values.put("STU_EMAIL",email);
        values.put("MALOP",mlop);
        values.put("MSGV",magv);
        Long kq = DB.insert("SINHVIEN",null,values);
        if (kq == -1) {
            return false;
        } else {
            return true;
        }
    }

            //sự kiện update
            public Boolean updateSTU(String mssv, String mk, String hoten, String gt, String ngaysinh,
                                     String noisinh, String diachi, String sohs, String cccd, String sdt,
                                     String email, String mlop, String magv) {
                SQLiteDatabase DB = this.getWritableDatabase();
                ContentValues values = new ContentValues();;
                values.put("STU_MATKHAUDANGNHAP",mk);
                values.put("STU_HOTEN",hoten);
                values.put("STU_GIOITINH",gt);
                values.put("STU_NGAYSINH",ngaysinh);
                values.put("STU_NOISINH",noisinh);
                values.put("STU_DIACHI",diachi);
                values.put("STU_SOHOSONHAPHOC",sohs);
                values.put("STU_CCCD",cccd);
                values.put("STU_SDT",sdt);
                values.put("STU_EMAIL",email);
                values.put("MALOP",mlop);
                values.put("MSGV",magv);
                Cursor cursor = DB.rawQuery("SELECT * FROM SINHVIEN WHERE MSSV = ?",new String[]{mssv});
                if (cursor.getCount()>0) {
                    long kq = DB.update("SINHVIEN",values,"MSSV = ?",new String[]{mssv});
                    if (kq == -1) {
                        return false;
                    } else {
                        return true;
                    }
                }
                else {
                    return false;
                }
            }

                // sự kiện delete
                public Boolean deleteSTU(String mssv) {
                    SQLiteDatabase DB = this.getWritableDatabase();
                    Cursor cursor = DB.rawQuery("SELECT * FROM SINHVIEN WHERE MSSV = ?",new String[]{mssv});
                    if (cursor.getCount()>0) {
                        long kq = DB.delete("SINHVIEN","MSSV = ?",new String[]{mssv});
                        if (kq == -1) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                    else {
                        return false;
                    }
                }


                    // sự kiện lấy dữ liệu lưu bằng con trỏ
                    public Cursor getdataSTU() {
                        SQLiteDatabase DB = this.getWritableDatabase();
                        Cursor cursor = DB.rawQuery("SELECT * FROM SINHVIEN",null);
                        return cursor;
                    }

                    // sự kiện lấy dữ liệu theo MSSV
                    public Cursor getdataSTU_withID(String id) {
                        SQLiteDatabase DB = this.getWritableDatabase();
                        Cursor cursor = DB.rawQuery("SELECT * FROM SINHVIEN WHERE MSSV = ?",new String[]{id});
                        return cursor;
                    }

                   // sự kiện lấy dữ liệu lưu bằng mảng dùng cho chức năng clickItem



        //sự kiện kiểm tra đăng nhập Sinh Viên
        public Boolean checkLG_STU(String user, String pass) {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("SELECT * FROM SINHVIEN WHERE MSSV = ? AND STU_MATKHAUDANGNHAP = ?",new String[]{user,pass});
            if (cursor.getCount()>0) {
                return true;
            } else {
                return false;
            }
        }
//-----------------------------------------------------------------------TABLE GIANGVIEN---------------------------------------------------------------------------

    public Boolean insertTCH(String msgv, String mk, String hoten, String mlop) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MSGV",msgv);
        values.put("TCH_MATKHAUDANGNHAP",mk);
        values.put("TCH_HOTEN",hoten);
        values.put("MALOP",mlop);
        Long kq = DB.insert("GIANGVIEN",null,values);
        if (kq == -1) {
            return false;
        } else {
            return true;
        }
    }

    //sự kiện update
    public Boolean updateTCH(String msgv, String mk, String hoten, String mlop) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TCH_MATKHAUDANGNHAP",mk);
        values.put("TCH_HOTEN",hoten);
        values.put("MALOP",mlop);
        Cursor cursor = DB.rawQuery("SELECT * FROM GIANGVIEN WHERE MSGV = ?",new String[]{msgv});
        if (cursor.getCount()>0) {
            long kq = DB.update("GIANGVIEN",values,"MSGV = ?",new String[]{msgv});
            if (kq == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    // sự kiện delete
    public Boolean deleteTCH(String msgv) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM GIANGVIEN WHERE MSGV = ?",new String[]{msgv});
        if (cursor.getCount()>0) {
            long kq = DB.delete("GIANGVIEN","MSGV = ?",new String[]{msgv});
            if (kq == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }


    // sự kiện lấy dữ liệu
    public Cursor getdataTCH() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM GIANGVIEN",null);
        return cursor;
    }

    // sự kiện lấy dữ liệu theo MSGV
    public Cursor getdataTCH_withID(String id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM GIANGVIEN WHERE MSGV = ?",new String[]{id});
        return cursor;
    }


    //sự kiện kiểm tra đăng nhập Sinh Viên
    public Boolean checkLG_TCH(String user, String pass) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM GIANGVIEN WHERE MSGV = ? AND TCH_MATKHAUDANGNHAP = ?",new String[]{user,pass});
        if (cursor.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }
//-----------------------------------------------------------------------TABLE GIANGVIEN---------------------------------------------------------------------------

//-------------------------------------------------------------------TABLE MONHOC--------------------------------------------------------------------------------
    public Boolean insertOBJECT(String mamon,String tenmon,String sotinchi, String mahocky){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAMON",mamon);
        values.put("TENMON",tenmon);
        values.put("SOTINCHI",sotinchi);
        values.put("MAHOCKY",mahocky);
        long kq = DB.insert("MONHOC",null,values);
        if (kq == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateOBJECT(String mamon,String tenmon,String sotinchi, String mahocky){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENMON",tenmon);
        values.put("SOTINCHI",sotinchi);
        values.put("MAHOCKY",mahocky);
        Cursor cursor = DB.rawQuery("SELECT * FROM MONHOC WHERE MAMON = ?",new String[]{mamon});
        if (cursor.getCount()>0){
        long kq = DB.update("MONHOC",values,"MAMON = ?",new String[]{mamon});
        if (kq == -1){
            return false;
        } else {
            return true;
        }
    } else {
            return false;
        }
    }

    public Boolean deleteOJECT(String mamon) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM MONHOC WHERE MAMON = ?",new String[]{mamon});
        if (cursor.getCount()>0) {
            long kq = DB.delete("MONHOC","MAMON = ?",new String[]{mamon});
            if (kq == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public Cursor getdataOBJECT() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM MONHOC",null);
        return cursor;
    }

    public Cursor getdataOBJECT_withID(String id ) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM MONHOC WHERE MAMON = ?",new String[]{id});
        return cursor;
    }


    //--------------------------------------------------------------------------------------TABLE MONHOC-----------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------TABLE KETQUAHOCTAP-----------------------------------------------------------------------------------------------
    public Boolean insertKQHT(String mssv, String mamon,String d1_1, String d1_2, String d1_3, String d2_1, String d2_2,
                             String d2_3, String d3_1) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MSSV",mssv);
        values.put("MAMON",mamon);
        values.put("D1_1",d1_1);
        values.put("D1_2",d1_2);
        values.put("D1_3",d1_3);
        values.put("D2_1",d2_1);
        values.put("D2_2",d2_2);
        values.put("D2_3",d2_3);
        values.put("D3_1",d3_1);
        long d11 = Long.parseLong(d1_1);
        long d12 = Long.parseLong(d1_2);
        long d13 = Long.parseLong(d1_3);
        long d21 = Long.parseLong(d2_1);
        long d22 = Long.parseLong(d2_2);
        long d23 = Long.parseLong(d2_3);
        long d31 = Long.parseLong(d3_1);
        long tbm = Long.parseLong(String.valueOf(((d11+d12+d13)+2*(d22+d23+d21))/9));
        values.put("D_TBM",tbm);
        long tbhp = Long.parseLong((String.valueOf(((3*d31)+tbm)/4)));
        values.put("D_TBHP",tbhp);
        Long kq = DB.insert("KETQUAHOCTAP",null,values);
        if (kq == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getdataKQHTT() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM KETQUAHOCTAP",null);
        return cursor;
    }

    public Cursor getdataKQHTT_withID(String msv,String mmon) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM KETQUAHOCTAP WHERE MSSV = ? AND MAMON = ?",new String[]{msv,mmon});
        return cursor;
    }
    //--------------------------------------------------------------------------------------TABLE KETQUAHOCTAP-----------------------------------------------------------------------------------------------

}
