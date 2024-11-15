# Öğrenci Ekleme Sistemi

Bu proje, kullanıcıların öğrenci bilgilerini girerek yeni öğrenciler eklemelerine, eklenen öğrencileri listelemelerine ve öğrenci bilgilerini doğrulamalarına olanak tanıyan bir web uygulamasıdır. Bu sistem, küçük çaplı projelerde ve öğrenim amaçlı kullanılabilir.

## İçindekiler

- [Özellikler](#özellikler)
- [Kullanım](#kullanım)
- [Ekran Görüntüleri](#ekran-görüntüleri)
- [Kurulum](#kurulum)
- [Proje Yapısı](#proje-yapısı)
- [Teknolojiler](#teknolojiler)
- [Geliştirme](#geliştirme)
- [Katkıda Bulunma](#katkıda-bulunma)
- [Lisans](#lisans)

---

## Özellikler

Bu uygulama, temel bir öğrenci ekleme ve listeleme sistemine sahip olup aşağıdaki işlevleri içerir:

1. **Yeni Öğrenci Ekleme**: 
   - Kullanıcılar, öğrenci adını ve öğrenci numarasını girerek sisteme yeni öğrenci ekleyebilirler. 
   - Öğrenci adı ve öğrenci numarası bilgileri zorunludur.

2. **Doğrulama İşlemleri**:
   - Öğrenci adı en az 6 karakter olmalıdır. Bu sayede kullanıcıların eksik veya hatalı bilgi girmesi engellenir.
   - Öğrenci numarası tam olarak 4 haneli olmalıdır. Eksik veya fazla karakterli girişlerde kullanıcıya uyarı gösterilir.

3. **Listeleme**:
   - Eklenen öğrenciler, sayfanın alt kısmında liste şeklinde gösterilir.
   - Öğrenci eklenmediğinde "Henüz kayıtlı öğrenci yok." uyarı mesajı kullanıcıya gösterilir.

4. **Hata Mesajları**:
   - Kullanıcılar yanlış bilgi girdiğinde ekranda belirgin hata mesajları gösterilir. Bu, kullanıcı deneyimini iyileştirir ve kullanıcıya hangi bilgileri yanlış girdiğini bildirir.

Bu özellikler sayesinde uygulama, kullanıcıya basit ve işlevsel bir öğrenci kayıt sistemi sunar.

---

## Kullanım

Öğrenci Ekleme Sistemi'nin kullanımı oldukça basittir. Aşağıdaki adımları izleyerek sistemi kolayca kullanabilirsiniz:

1. **Öğrenci Adı Girişi**:
   - Öğrenci adı alanına en az 6 karakter uzunluğunda bir ad girin. 
   - Örneğin: "Ahmet Yılmaz"

2. **Öğrenci Numarası Girişi**:
   - Öğrenci numarası alanına tam olarak 4 basamaklı bir numara girin.
   - Örneğin: "1234"

3. **Ekle Butonuna Tıklayın**:
   - Bilgileri doğru şekilde girdikten sonra "Ekle" butonuna tıklayarak öğrenci ekleme işlemini tamamlayabilirsiniz.
   - Bilgiler yanlışsa hata mesajı alırsınız ve doğru bilgileri girmeniz istenir.

4. **Öğrenci Listesi**:
   - Eklediğiniz öğrenciler, listenin altında sıralanır.
   - Liste, sayfa yenilendiğinde sıfırlanabilir (sunucu taraflı bir veri kaydetme yapısı yoksa).

---

## Ekran Görüntüleri

Aşağıda uygulamanın ekran görüntüleri bulunmaktadır:

### Boş Liste Durumu

Henüz öğrenci eklenmemişse, kullanıcıya **Henüz kayıtlı öğrenci yok.** mesajı gösterilir. Bu mesaj, öğrenci listesinin başlangıçta boş olduğunu belirtir.

![Boş Liste Durumu](./Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-11-15%20114413.png)

### Öğrenci Ekleme ve Listeleme

Öğrenci bilgileri doğru girildiğinde, bilgiler listeye eklenir ve yeni eklenen öğrenciler aşağıda görünür.

![Öğrenci Ekleme ve Listeleme](./Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-11-15%20114715.png)

### Hata Mesajları

Öğrenci adı 6 karakterden kısa veya öğrenci numarası 4 basamaktan farklı ise hata mesajları gösterilir. Bu sayede kullanıcı, hatalı girişler hakkında bilgilendirilir ve gerekli düzeltmeleri yapması sağlanır.

![Hata Mesajları](./Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-11-15%20114734.png)

---

## Kurulum

Bu projeyi kendi bilgisayarınızda çalıştırmak için aşağıdaki adımları takip edebilirsiniz.

### Gerekli Bağımlılıklar

Projenin çalışabilmesi için aşağıdaki gereksinimleri karşılamanız gerekir:
- [Node.js](https://nodejs.org/) (Bu bir web uygulamasıysa)
- Tarayıcı (Chrome, Firefox vb.)

### Adım 1: Projeyi Klonlayın

Terminal veya komut istemcisinde aşağıdaki komutu çalıştırarak projeyi klonlayın:
```bash
git clone https://github.com/kullanici-adi/ogrenci-ekleme-sistemi.git
cd ogrenci-ekleme-sistemi
