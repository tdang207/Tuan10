package qlsv;

import java.util.List;

public interface IFSinhVien {
	boolean them(SinhVien sv);
	boolean xoa(String maSV);
	boolean sua(String maSV, SinhVien sinhvienmoi);
	boolean xoatatca();
	List<SinhVien> laytatca();
	SinhVien timTheoMa(String maSV);
	List<SinhVien> timTheoTen(String tuKhoa);
	List<SinhVien> timTheoLop(String lop);
	List<SinhVien> timTheoLoai(String loai);
	List<SinhVien> timTheoMon(monhoc monHoc);
	int tongSoLuong();
	double ThanhTien();
	List<SinhVien> sapXepTheoTen();
	List<SinhVien> sapXepTheoThanhTienGiamDan();
}
