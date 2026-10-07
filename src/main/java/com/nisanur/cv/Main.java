package com.nisanur.cv;

import java.nio.file.Path;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        try {
            Person person = createSampleResume();
            Path output = Path.of("output", "Nisanur_Dermenci_Ozgecmis.pdf");
            new PdfResumeGenerator().generate(person, output);
            System.out.println("PDF başarıyla oluşturuldu: " + output.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("PDF oluşturulurken hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static Person createSampleResume() {
        List<Education> education = List.of(
                new Education(
                        "Kırklareli Üniversitesi",
                        "Yazılım Mühendisliği",
                        "2025 - Devam ediyor")
        );
        List<Experience> experiences = List.of(
                new Experience(
                        "Code Yazılım",
                        "Web Geliştirme Stajyeri",
                        "2025",
                        "Web projelerinde HTML, CSS ve JavaScript kullanarak sayfa düzenlemeleri yaptım ve mevcut kodların geliştirilmesine yardımcı oldum."),
                new Experience(
                        "Teknosoft",
                        "Yazılım Geliştirme Asistanı",
                        "2026",
                        "Java ile geliştirilen uygulamalarda hata tespiti, kod düzenleme ve temel test çalışmalarına destek oldum."),
                new Experience(
                        "Data Bilişim",
                        "Junior Java Geliştirici",
                        "2026 - 2027",
                        "Kurumsal yazılım projelerinde yeni özellik geliştirme, dokümantasyon ve ekip içi kod incelemelerine katkı sağladım.")
        );
        return new Person(
                "Nisanur Dermenci",
                "Yazılım Mühendisliği Öğrencisi",
                "nisanur.dermenci@example.com",
                "+90 5555555555",
                " Kırklareli,Türkiye",
                "Yazılım geliştirme alanında kendini geliştiren, algoritma ve nesne yönelimli programlama konularına ilgi duyan bir öğrenciyim. Java ve temel yazılım geliştirme süreçlerinde deneyim kazanmayı hedefliyorum.",
                "src/main/resources/vesikalık.jpeg",
                List.of("Java", "C", "OOP", "Algoritmalar", "Git/GitHub", "Problem Çözme"),
                education,
                experiences
        );
    }
}
