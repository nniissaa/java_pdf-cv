# Java PDF Özgeçmiş Uygulaması

## Projenin amacı
Bu proje Java kullanılarak kişisel bilgileri, eğitim bilgilerini, üç farklı iş deneyimini ve yetkinlikleri içeren bir özgeçmişi PDF formatında üretir.

Uygulamada grafiksel arayüz kullanılmamıştır. Program çalıştırıldığında örnek bilgiler `Person` nesnesine aktarılır ve PDF dosyası `output/Nisanur_Dermenci_Ozgecmis.pdf` konumunda oluşturulur.

## Kullanılan teknolojiler
- Java 17
- Maven
- OpenPDF
- IntelliJ IDEA 
- Git ve GitHub

## Kullanılan nesneler ve sınıflar

### 1. Person
Özgeçmiş sahibinin tüm bilgilerini tutar:
- ad soyad
- meslek/unvan
- e-posta
- telefon
- şehir
- profil açıklaması
- fotoğraf yolu
- yetenekler
- eğitim listesi
- deneyim listesi

Bilgilerin tek bir nesnede toplanması veri yönetimini kolaylaştırır.

### 2. Education
Bir eğitim kaydını temsil eder. Okul, bölüm ve tarih bilgilerini içerir.

### 3. Experience
Bir iş deneyimini temsil eder. Şirket, pozisyon, çalışma dönemi ve açıklama bilgilerini içerir.

### 4. PdfResumeGenerator
`Person` nesnesini alır ve PDF dosyasını oluşturur. PDF üretme sorumluluğunun ayrı bir sınıfta tutulması kodun daha düzenli ve sürdürülebilir olmasını sağlar.

### 5. Main
Programın başlangıç noktasıdır. Örnek `Person`, `Education` ve `Experience` nesnelerini oluşturur ve PDF üreticisini çalıştırır.

## Neden bu nesneleri kullandım?
Gerçek hayattaki varlıkları doğrudan sınıflara ayırmak programın anlaşılmasını kolaylaştırır. Örneğin bir iş deneyiminin şirketi, pozisyonu, dönemi ve açıklaması birlikte anlamlıdır. Bu nedenle bu bilgiler `Experience` sınıfında tutulmuştur. Aynı şekilde eğitim bilgileri `Education` sınıfında, kişisel bilgiler ise `Person` sınıfında tutulmuştur.

## Programın çalıştırılması
Terminalde proje klasöründe:

```bash
mvn clean compile
mvn exec:java
```

Çalıştırma sonunda:

```text
output/Nisanur_Dermenci_Ozgecmis.pdf
```

dosyası oluşur.

## Fotoğraf ekleme
Ödevde özgeçmişte fotoğraf bulunması gerektiği için gerçek fotoğrafınızı şu isimle proje içine koyun:

```text
src/main/resources/vesikalık.jpg
```

Sonra programı tekrar çalıştırın.


## GitHub teslimi
GitHub repository'sine aşağıdaki dosyalar yüklenebilir:

- pom.xml
- src/main/java/com/nisanur/cv/Main.java
- src/main/java/com/nisanur/cv/Person.java
- src/main/java/com/nisanur/cv/Education.java
- src/main/java/com/nisanur/cv/Experience.java
- src/main/java/com/nisanur/cv/PdfResumeGenerator.java
- README.md
- src/main/resources/foto.jpg

`target/` klasörü ve IDE'ye ait gereksiz dosyalar yüklenmemelidir.

## Yapay zekâ kullanım açıklaması
## Yapay Zekâ ile Çalışma Süreci

Bu projeyi geliştirirken ChatGPT'den bir yardımcı ve öğrenme aracı olarak faydalandım. Proje sürecinde uygulamanın yapısını planlamak, Java sınıflarının sorumluluklarını belirlemek, PDF oluşturma işlemini anlamak ve karşılaştığım hataları çözmek için birlikte çalıştık.

Geliştirme sürecinde sınıfların neden ayrı tutulduğunu, nesnelerin nasıl oluşturulduğunu ve PDF üretme işleminin nasıl çalıştığını anlamaya yönelik açıklamalardan yararlandım. Aldığım önerileri kendi proje gereksinimlerime göre değerlendirdim ve uygulamayı IntelliJ IDEA üzerinde çalıştırarak sonuçlarını kontrol ettim.

Bu süreçte amacım yalnızca çalışan bir uygulama oluşturmak değil, kullandığım kodların mantığını anlamak ve Java programlama bilgimi geliştirmekti. ChatGPT, geliştirme sürecinde fikir alışverişi yaptığım, sorularımı yanıtlayan ve sorunları çözmeme yardımcı olan bir destek aracı olarak kullanıldı.
