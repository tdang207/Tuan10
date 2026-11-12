package qlsv;

import java.time.LocalDate;

public class SVchinhquy extends SinhVien {
	private String hocTrucTiep;
	
	public SVchinhquy(String maSV, String hoTen, LocalDate ngaySinh, String lop, int soTinChi, monhoc monHoc,String hocTrucTiep) {
		super(maSV, hoTen, ngaySinh, lop, soTinChi, monHoc);
		this.hocTrucTiep = hocTrucTiep;
	}

	public String getHocTrucTiep() {
		return hocTrucTiep;
	}

	public void setHocTrucTiep(String hocTrucTiep) {
		this.hocTrucTiep = hocTrucTiep;
	}

	@Override
	public String getLoai() {
		// TODO Auto-generated method stub
		return "chinh quy";
	}

	@Override
	public String getThongTinRieng() {
		// TODO Auto-generated method stub
		return "hoc truc tiep tai " + hocTrucTiep;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "|"+ getThongTinRieng();
	}



}
