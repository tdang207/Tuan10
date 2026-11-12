package qlsv;
import java.time.LocalDate;

public class SVtuxa extends SinhVien{
	private String nenTang;
	public SVtuxa(String maSV, String hoTen, LocalDate ngaySinh, String lop, int soTinChi, monhoc monHoc,String nenTang) {
		super(maSV, hoTen, ngaySinh, lop, soTinChi, monHoc);
		this.nenTang = nenTang;
		// TODO Auto-generated constructor stub
	}
	public String getNenTang() {
		return nenTang;
	}
	public void setNenTang(String nenTang) {
		this.nenTang = nenTang;
	}
	@Override
	public String getLoai() {
		// TODO Auto-generated method stub
		return "tu xa";
	}
	@Override
	public String getThongTinRieng() {
		// TODO Auto-generated method stub
		return "Hoc online qua " + nenTang;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " | " + getThongTinRieng();
	}
	@Override
	public double thanhTien() {
		// TODO Auto-generated method stub
		return super.thanhTien() * 0.9;
	}
	

	
	

}
