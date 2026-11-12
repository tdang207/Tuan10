package qlsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public class ListSV implements IFSinhVien {

    private ArrayList<SinhVien> danhSach;

    public ListSV() {
        this.danhSach = new ArrayList<SinhVien>();
    }

    public ListSV(ArrayList<SinhVien> ds) {
        this.danhSach = (ds == null)
                ? new ArrayList<SinhVien>()
                : ds;
    }

    public boolean them(SinhVien sv) {
        if (sv == null)
            return false;

        if (timTheoMa(sv.getMaSV()) != null)
            return false;

        return danhSach.add(sv);
    }

    public boolean sua(String maSV, SinhVien sinhvienmoi) {
        if (maSV == null || sinhvienmoi == null)
            return false;

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSV().equalsIgnoreCase(maSV)) {
                danhSach.set(i, sinhvienmoi);
                return true;
            }
        }

        return false;
    }

    public boolean xoa(String maSV) {
        if (maSV == null)
            return false;

        return danhSach.removeIf(
                sv -> sv.getMaSV().equalsIgnoreCase(maSV)
        );
    }

    public boolean xoatatca() {
        if (danhSach.isEmpty())
            return false;

        danhSach.clear();
        return true;
    }

    public List<SinhVien> laytatca() {
        return new ArrayList<>(danhSach);
    }

    // ==================== TIM KIEM ====================

    // Tim theo ma sinh vien
    public SinhVien timTheoMa(String maSV) {
        if (maSV == null)
            return null;

        for (SinhVien sv : danhSach) {
            if (sv.getMaSV().equalsIgnoreCase(maSV))
                return sv;
        }

        return null;
    }

    // Ham tim kiem chung
    public List<SinhVien> tim(Predicate<SinhVien> dieuKien) {
        List<SinhVien> kq = new ArrayList<>();

        if (dieuKien == null)
            return kq;

        for (SinhVien sv : danhSach) {
            if (dieuKien.test(sv))
                kq.add(sv);
        }

        return kq;
    }

    // Tim theo ten
    public List<SinhVien> timTheoTen(String tuKhoa) {
        List<SinhVien> kq = new ArrayList<>();

        if (tuKhoa == null)
            return kq;

        for (SinhVien sv : danhSach) {
            if (sv.getHoTen() != null
                    && sv.getHoTen().toLowerCase()
                    .contains(tuKhoa.toLowerCase())) {
                kq.add(sv);
            }
        }

        return kq;
    }

    // Tim theo lop
    public List<SinhVien> timTheoLop(String lop) {
        List<SinhVien> kq = new ArrayList<>();

        if (lop == null)
            return kq;

        for (SinhVien sv : danhSach) {
            if (sv.getLop() != null
                    && sv.getLop().equalsIgnoreCase(lop)) {
                kq.add(sv);
            }
        }

        return kq;
    }

    
    public List<SinhVien> timTheoLoai(String loai) {
        List<SinhVien> kq = new ArrayList<>();

        if (loai == null)
            return kq;

        for (SinhVien sv : danhSach) {
            if (sv.getLoai() != null
                    && sv.getLoai().equalsIgnoreCase(loai)) {
                kq.add(sv);
            }
        }

        return kq;
    }

   
    public List<SinhVien> timTheoMon(monhoc monHoc) {
        List<SinhVien> kq = new ArrayList<>();

        for (SinhVien sv : danhSach) {
            if (sv.getMonHoc() == monHoc)
                kq.add(sv);
        }

        return kq;
    }

    // ==================== THONG KE ====================

    public int tongSoLuong() {
        return danhSach.size();
    }

    public double ThanhTien() {
        double tong = 0;

        for (SinhVien sv : danhSach)
            tong += sv.thanhTien();

        return tong;
    }

    // ==================== SAP XEP ====================

    
    public void sapXep(Comparator<SinhVien> cmp) {
        danhSach.sort(cmp);
    }

   
    public void sapXepGiamDan(Comparator<SinhVien> cmp) {
        danhSach.sort(cmp.reversed());
    }

   
    public List<SinhVien> sapXepTheoTen() {
        List<SinhVien> kq = new ArrayList<>(danhSach);

        kq.sort(
                Comparator.comparing(
                        SinhVien::getHoTen,
                        Comparator.nullsLast(
                                String.CASE_INSENSITIVE_ORDER
                        )
                )
        );

        return kq;
    }

  
    public List<SinhVien> sapXepTheoThanhTienGiamDan() {
        List<SinhVien> kq = new ArrayList<>(danhSach);

        kq.sort(
                Comparator.comparingDouble(SinhVien::thanhTien)
                        .reversed()
        );

        return kq;
    }

    // ==================== GROUP BY ====================

  
    public <K> Map<K, List<SinhVien>> nhomTheo(
            Function<SinhVien, K> layKey) {

        Map<K, List<SinhVien>> kq = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);

            kq.computeIfAbsent(
                    key, k -> new ArrayList<>()
            ).add(sv);
        }

        return kq;
    }

    
    public <K> Map<K, Integer> demTheoNhom(
            Function<SinhVien, K> layKey) {

        Map<K, Integer> kq = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            kq.merge(
                    layKey.apply(sv),
                    1,
                    Integer::sum
            );
        }

        return kq;
    }


    public <K> Map<K, Double> tongTheoNhom(
            Function<SinhVien, K> layKey,
            ToDoubleFunction<SinhVien> layGiaTri) {

        Map<K, Double> kq = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);
            double val = layGiaTri.applyAsDouble(sv);

            kq.merge(key, val, Double::sum);
        }

        return kq;
    }

   
    public <K> Map<K, Double> tongTheoNhom_Having(
            Function<SinhVien, K> layKey,
            ToDoubleFunction<SinhVien> layGiaTri,
            double minTong) {

        Map<K, Double> kq = new LinkedHashMap<>();

        for (Map.Entry<K, Double> e :
                tongTheoNhom(layKey, layGiaTri).entrySet()) {

            if (e.getValue() >= minTong)
                kq.put(e.getKey(), e.getValue());
        }

        return kq;
    }

  
    public <K> Map<K, Integer> demTheoNhom_Having(
            Function<SinhVien, K> layKey,
            int minDem) {

        Map<K, Integer> kq = new LinkedHashMap<>();

        for (Map.Entry<K, Integer> e :
                demTheoNhom(layKey).entrySet()) {

            if (e.getValue() >= minDem)
                kq.put(e.getKey(), e.getValue());
        }

        return kq;
    }
}
