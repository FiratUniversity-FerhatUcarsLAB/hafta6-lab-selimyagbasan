/**
 * Ad Soyad: Selim Yağbasan
 * Numara: 250541111
 * Proje: Bir öğrencinin notlarınnı değerlendiren
 * ve detaylı rapor veren program
 * Tarih: 19.11.2025
 */
import java.util.Scanner;

public class Proje1_NotSistemi {

    //Not Girişi
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Vize notunu girin: ");
        int vizeNot = in.nextInt();

        System.out.print("Final notunu girin: ");
        int finalNot = in.nextInt();

        System.out.print("Ödev notunu girin: ");
        int odevNot = in.nextInt();

        double ortalama = calculateAverage(vizeNot, finalNot, odevNot);

    // Raporun yazılması
        System.out.println("\n==== Öğrenci Not Raporu ====");
        System.out.println("Vize Notu     : " + vizeNot);
        System.out.println("Final Notu    : " + finalNot);
        System.out.println("Ödev Notu     : " + odevNot);
        System.out.println("---------------------------");
        System.out.printf("Ortalama      : %.2f%n", ortalama);
        System.out.println("Harf Notu     : " + getLetterGrade(ortalama));
        System.out.println("Durum         : " + (isPassingGrade(ortalama) ? "GEÇTİ" : "KALDI"));
        System.out.println("Onur Listesi  : " + (isHonorList(ortalama, vizeNot, finalNot, odevNot) ? "EVET" : "HAYIR"));
        System.out.println("Bütünleme     : " + (hasRetakeRight(ortalama) ? "VAR" : "YOK"));
        System.out.println("\n==== Öğrenci Not Raporu ====");
        in.close();
    }

    // Ortalama hesaplamaları ve harf notunun verilmesi:

    public static double calculateAverage(int vize, int finalNot, int odev) {
        return vize * 0.3 + finalNot * 0.4 + odev * 0.3;
    }

    public static boolean isPassingGrade(double ort) {
        return ort >= 50;
    }

    public static String getLetterGrade(double ort) {
        if (ort >= 90) return "A";
        else if (ort >= 80) return "B";
        else if (ort >= 70) return "C";
        else if (ort >= 60) return "D";
        else return "F";
    }

    public static boolean isHonorList(double ort, int vize, int finalNot, int odev) {
        return ort >= 85 && vize >= 70 && finalNot >= 70 && odev >= 70;
    }

    public static boolean hasRetakeRight(double ort) {
        return ort >= 40 && ort < 50;
    }
}