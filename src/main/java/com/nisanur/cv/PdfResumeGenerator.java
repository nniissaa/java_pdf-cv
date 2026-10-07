package com.nisanur.cv;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;

public class PdfResumeGenerator {

    private static final Color DARK = new Color(35, 45, 55);
    private static final Color ACCENT = new Color(48, 105, 150);
    private static final Color LIGHT = new Color(235, 242, 247);

    public void generate(Person person, Path outputPath) throws Exception {
        File outputFile = outputPath.toFile();
        File parent = outputFile.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }

        Document document = new Document(PageSize.A4, 42, 42, 42, 42);

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            PdfWriter.getInstance(document, fos);
            document.open();

            String fontPath = findFont();
            BaseFont baseFont = BaseFont.createFont(
                    fontPath,
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
            );

            Font nameFont = new Font(baseFont, 23, Font.BOLD, DARK);
            Font titleFont = new Font(baseFont, 11, Font.NORMAL, ACCENT);
            Font sectionFont = new Font(baseFont, 12, Font.BOLD, Color.WHITE);
            Font bodyFont = new Font(baseFont, 9.5f, Font.NORMAL, DARK);
            Font smallFont = new Font(baseFont, 8.5f, Font.NORMAL, DARK);
            Font boldFont = new Font(baseFont, 9.5f, Font.BOLD, DARK);
            Font photoFont = new Font(baseFont, 8, Font.BOLD, ACCENT);

            PdfPTable header = new PdfPTable(new float[]{3.8f, 1.2f});
            header.setWidthPercentage(100);

            PdfPCell info = new PdfPCell();
            info.setBorder(Rectangle.NO_BORDER);
            info.addElement(new Paragraph(person.getFullName(), nameFont));
            info.addElement(new Paragraph(person.getTitle(), titleFont));
            info.addElement(new Paragraph(
                    person.getEmail() + "  |  " + person.getPhone()
                            + "  |  " + person.getCity(), smallFont));
            header.addCell(info);

            PdfPCell photoCell = new PdfPCell();
            photoCell.setBorder(Rectangle.NO_BORDER);
            photoCell.setHorizontalAlignment(Element.ALIGN_RIGHT);

            if (person.getPhotoPath() != null && new File(person.getPhotoPath()).exists()) {
                Image photo = Image.getInstance(person.getPhotoPath());
                photo.scaleToFit(78, 92);
                photoCell.addElement(photo);
            } else {
                Paragraph placeholder = new Paragraph("FOTOĞRAF\nEKLENECEK", photoFont);
                placeholder.setAlignment(Element.ALIGN_CENTER);
                photoCell.setBackgroundColor(LIGHT);
                photoCell.setFixedHeight(92);
                photoCell.addElement(placeholder);
            }
            header.addCell(photoCell);

            document.add(header);
            document.add(Chunk.NEWLINE);

            addSection(document, "PROFİL", sectionFont);
            document.add(new Paragraph(person.getSummary(), bodyFont));
            document.add(Chunk.NEWLINE);

            addSection(document, "EĞİTİM", sectionFont);
            for (Education e : person.getEducation()) {
                Paragraph p = new Paragraph();
                p.add(new Chunk(
                        e.getSchool() + " — " + e.getDepartment(), boldFont));
                p.add(new Chunk("  (" + e.getPeriod() + ")", smallFont));
                document.add(p);
            }
            document.add(Chunk.NEWLINE);

            addSection(document, "İŞ DENEYİMİ", sectionFont);
            for (Experience e : person.getExperiences()) {
                Paragraph p = new Paragraph();
                p.add(new Chunk(
                        e.getPosition() + " — " + e.getCompany(), boldFont));
                p.add(new Chunk("  " + e.getPeriod(), smallFont));
                p.add(Chunk.NEWLINE);
                p.add(new Chunk(e.getDescription(), bodyFont));
                document.add(p);
                document.add(Chunk.NEWLINE);
            }

            addSection(document, "YETKİNLİKLER", sectionFont);
            document.add(new Paragraph(
                    String.join(" • ", person.getSkills()), bodyFont));

            document.add(Chunk.NEWLINE);
            addSection(document, "İLETİŞİM", sectionFont);
            document.add(new Paragraph(
                    "E-posta: " + person.getEmail()
                            + "\nTelefon: " + person.getPhone()
                            + "\nŞehir: " + person.getCity(), bodyFont));

            document.close();
        }
    }

    private void addSection(Document document, String title, Font font) {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell(new Phrase(title, font));
        cell.setBackgroundColor(ACCENT);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(5);

        table.addCell(cell);
        document.add(table);
        document.add(new Paragraph(" "));
    }

    private String findFont() {
        String[] candidates = {
                "/Library/Fonts/DejaVuSans.ttf",
                "/System/Library/Fonts/Supplemental/Arial Unicode.ttf",
                "/System/Library/Fonts/Supplemental/Arial.ttf",
                "/System/Library/Fonts/Supplemental/Helvetica.ttf"
        };

        for (String candidate : candidates) {
            if (new File(candidate).exists()) {
                return candidate;
            }
        }

        throw new IllegalStateException(
                "Türkçe karakter destekleyen bir font bulunamadı. "
                        + "DejaVu Sans veya Arial Unicode yüklenmelidir.");
    }
}
