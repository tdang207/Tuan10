package qlsv;

import java.time.LocalDate;

public class SinhVien {
	protected String maSV;
	protected String hoTen;
	protected LocalDate ngaySinh;
	protected String lop;
	protected int soTinChi;
	protected monhoc MonHoc;
	public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String lop, int soTinChi, monhoc monHoc) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.soTinChi = soTinChi;
		MonHoc = monHoc;
	}
	public double thanhTien() {
		return soTinChi * MonHoc.getDonGia();
	}
	public String getLoai() {
		return "Sinh Vien ";
	}
	public String getThongTinRieng() {
		return "";
	}
	public String getMaSV() {
		return maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public String getLop() {
		return lop;
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	public monhoc getMonHoc() {
		return MonHoc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s] %s|Lop %s|NS %s|Mon %s (%d so tin chi %,.0f ) | TT %,.0f VND",
				maSV , hoTen ,lop,ngaySinh,MonHoc.getTenMon(),
				soTinChi,MonHoc.getDonGia(),thanhTien());
	}
	
}
