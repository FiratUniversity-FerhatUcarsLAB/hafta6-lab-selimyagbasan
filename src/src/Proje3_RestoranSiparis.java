/**
 * Ad Soyad: Selim Yağbasan
 * Numara: 250541111
 * Proje:Menü, miktar ve özel durumları yöneten sipariş sistemi
 * Tarih: 19.11.2025
 */

/**
 * Ad Soyad: Selim Yağbasan
 * Numara: 250541111
 * Proje: Akıllı Restoran Sipariş Sistemi (Görev 3)
 * Tarih: 2025
 */

import java.util.Scanner;

public class Proje3_RestoranSiparis {

    // FIYAT METOTLARI

    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;
            case 2: return 120;
            case 3: return 110;
            case 4: return 65;
            default: return 0;
        }
    }

    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;
            case 2: return 45;
            case 3: return 55;
            default: return 0;
        }
    }

    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;
            case 2: return 12;
            case 3: return 35;
            case 4: return 25;
            default: return 0;
        }
    }

    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;
            case 2: return 55;
            case 3: return 35;
            default: return 0;
        }
    }

    // ISIM METOTLARI (Sipariş Özeti için)

    public static String getMainDishName(int secim) {
        switch (secim) {
            case 1: return "Izgara Tavuk";
            case 2: return "Adana Kebap";
            case 3: return "Levrek";
            case 4: return "Mantı";
            default: return "Seçilmedi";
        }
    }

    public static String getAppetizerName(int secim) {
        switch (secim) {
            case 1: return "Çorba";
            case 2: return "Humus";
            case 3: return "Sigara Böreği";
            default: return "Seçilmedi";
        }
    }

    public static String getDrinkName(int secim) {
        switch (secim) {
            case 1: return "Kola";
            case 2: return "Ayran";
            case 3: return "Taze Meyve Suyu";
            case 4: return "Limonata";
            default: return "Seçilmedi";
        }
    }

    public static String getDessertName(int secim) {
        switch (secim) {
            case 1: return "Künefe";
            case 2: return "Baklava";
            case 3: return "Sütlaç";
            default: return "Seçilmedi";
        }
    }

    // DİĞER METOTLAR

    public static boolean isComboOrder(boolean ana, boolean icecek, boolean tatli) {
        return ana && icecek && tatli;
    }

    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }

    public static double calculateDiscount(double tutar, boolean combo, boolean ogrenci, int saat) {
        double indirim = 0;

        if (combo) indirim += tutar * 0.15;
        if (isHappyHour(saat)) indirim += 5;
        if (ogrenci) indirim += tutar * 0.10;
        if (tutar >= 200) indirim += tutar * 0.10;

        return indirim;
    }

    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }

    // MAIN

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== AKILLI RESTORAN SISTEMI ===");

        // ANA YEMEK
        System.out.println("\nAna Yemekler:");
        System.out.println("1 - Izgara Tavuk (85 TL)");
        System.out.println("2 - Adana Kebap (120 TL)");
        System.out.println("3 - Levrek (110 TL)");
        System.out.println("4 - Mantı (65 TL)");
        System.out.print("Seçiminiz (1-4, yoksa 0): ");
        int ana = sc.nextInt();

        // BAŞLANGIÇ
        System.out.println("\nBaşlangıçlar:");
        System.out.println("1 - Çorba (25 TL)");
        System.out.println("2 - Humus (45 TL)");
        System.out.println("3 - Sigara Böreği (55 TL)");
        System.out.print("Seçiminiz (1-3, yoksa 0): ");
        int bas = sc.nextInt();

        // İÇECEK
        System.out.println("\nİçecekler:");
        System.out.println("1 - Kola (15 TL)");
        System.out.println("2 - Ayran (12 TL)");
        System.out.println("3 - Taze Meyve Suyu (35 TL)");
        System.out.println("4 - Limonata (25 TL)");
        System.out.print("Seçiminiz (1-4, yoksa 0): ");
        int icecek = sc.nextInt();

        // TATLI
        System.out.println("\nTatlılar:");
        System.out.println("1 - Künefe (65 TL)");
        System.out.println("2 - Baklava (55 TL)");
        System.out.println("3 - Sütlaç (35 TL)");
        System.out.print("Seçiminiz (1-3, yoksa 0): ");
        int tatli = sc.nextInt();

        // SAAT
        System.out.print("\nSaat (8-23): ");
        int saat = sc.nextInt();

        // ÖĞRENCİ
        System.out.print("Öğrenci misiniz? (E/H): ");
        boolean ogrenci = sc.next().equalsIgnoreCase("E");

        // FİYATLAR
        double f1 = getMainDishPrice(ana);
        double f2 = getAppetizerPrice(bas);
        double f3 = getDrinkPrice(icecek);
        double f4 = getDessertPrice(tatli);

        double araToplam = f1 + f2 + f3 + f4;

        boolean combo = isComboOrder(f1 > 0, f3 > 0, f4 > 0);

        double indirim = calculateDiscount(araToplam, combo, ogrenci, saat);

        double toplam = araToplam - indirim;

        double bahsis = calculateServiceTip(toplam);

        // SİPARİŞ ÖZETİ

        System.out.println("\n=== SİPARİŞ ÖZETİ ===");
        System.out.println("Ana Yemek : " + getMainDishName(ana) + " (" + f1 + " TL)");
        System.out.println("Başlangıç : " + getAppetizerName(bas) + " (" + f2 + " TL)");
        System.out.println("İçecek    : " + getDrinkName(icecek) + " (" + f3 + " TL)");
        System.out.println("Tatlı     : " + getDessertName(tatli) + " (" + f4 + " TL)");

        System.out.println("\nAra Toplam : " + araToplam + " TL");
        System.out.println("İndirimler : -" + indirim + " TL");
        System.out.println("Toplam     : " + toplam + " TL");
        System.out.println("Bahşiş Önerisi (10%): " + bahsis + " TL");

        System.out.println("\n=== AFİYET OLSUN ===");
    }
}
